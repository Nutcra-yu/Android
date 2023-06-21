package zyu.android.callback.sample2;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class PersonA implements View.OnClickListener {

    private Context context;

    public PersonA(Context context){
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context,"answer_A",Toast.LENGTH_SHORT).show();
    }
}
