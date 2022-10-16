package com.example.demoforapifox2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText student_id;
    private EditText password;
    private Button send;
    private TextView code;
    private TextView message;
    private TextView data;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        student_id = findViewById(R.id.id);
        password = findViewById(R.id.password);
        send = findViewById(R.id.send);
        code = findViewById(R.id.code);
        message = findViewById(R.id.message);
        data = findViewById(R.id.data);

        send.setOnClickListener((view)->
        {
            SEND send = new SEND(
                    student_id.getText().toString(),
                    password.getText().toString()
            );

            sendNet(send);

        });
    }

    private void sendNet(SEND send)
    {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://119.3.2.168:8080/api/v1/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        Blackboard blackboard = retrofit.create(Blackboard.class);
        Call<BACK> call = blackboard.login(send);

        call.enqueue(new Callback<BACK>() {
            @Override
            public void onResponse(Call<BACK> call, Response<BACK> response) {
                if (response.isSuccessful())
                {
                    code.setText(response.body().getCode().toString());
                    data.setText(response.body().getData().toString());
                    message.setText(response.body().getMessage());
                }
                else
                {
                    Toast.makeText(MainActivity.this, "sth wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BACK> call, Throwable t) {
                Toast.makeText(MainActivity.this, "hhhh", Toast.LENGTH_SHORT).show();
            }
        });

    }

}