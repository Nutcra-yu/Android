package zyu.android.callback.sample1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import zyu.android.callback.R;

public class MainActivity extends AppCompatActivity {

    Button btn_CompanyA;
    TextView tvResult;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_CompanyA =findViewById(R.id.bCompany);
        tvResult=findViewById(R.id.tvResult);

        btn_CompanyA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CompanyA cA=new CompanyA();
                CompanyB cB=new CompanyB();

                cA.setCallBack(cB);

                String answer= cA.Work();
                tvResult.setText(answer);

            }
        });

    }
}

