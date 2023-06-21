package zyu.android.callback.sample2;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class PersonB implements View.OnClickListener {

    private Context context;

    public PersonB(Context context){
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context,"answer_B",Toast.LENGTH_SHORT).show();
    }
}
