package zyu.android.callback.sample2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import zyu.android.callback.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button somebody = findViewById(R.id.ask_A);
        Button somebody2 = findViewById(R.id.ask_B);

        PersonA a = new PersonA(MainActivity2.this);
        somebody.setOnClickListener(a);

        PersonB b = new PersonB(MainActivity2.this);
        somebody2.setOnClickListener(b);
    }
}