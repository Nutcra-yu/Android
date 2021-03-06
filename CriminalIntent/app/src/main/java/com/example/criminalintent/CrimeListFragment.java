package com.example.criminalintent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class CrimeListFragment extends Fragment
{
    private RecyclerView mCrimeRecyclerview;
    private CrimeAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_crime_list, container ,false);

        mCrimeRecyclerview = (RecyclerView) view
                .findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI()
    {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();

        mAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerview.setAdapter(mAdapter);
    }

    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private Crime mCrime;
        private TextView mTitleTextView;
        private TextView mDataTextView;

        public void bind(Crime crime)
        {
            mCrime = crime;
            mTitleTextView.setText(mCrime.getTitle());
            mDataTextView.setText(mCrime.getDate().toString());
        }

        public CrimeHolder(LayoutInflater inflater, ViewGroup parent)
        {
            super(inflater.inflate(R.layout.list_item_crime, parent, false));
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.crime_title);
            mDataTextView = (TextView) itemView.findViewById(R.id.crime_date);
        }

        @Override
        public void onClick(View view)
        {
            Toast.makeText(getActivity(),
                    mCrime.getTitle() + "clicked!" ,
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>
    {
        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CrimeHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position)
        {
            Crime crime = mCrimes.get(position);
            holder.bind(crime);
        }

        @Override
        public int getItemCount()
        {
            return mCrimes.size();
        }
    }



}
