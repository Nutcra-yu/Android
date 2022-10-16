package com.example.githubnewaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Email;
    private EditText Topics;
    private EditText Age;
    private Button Create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name   = findViewById(R.id.Name);
        Email  = findViewById(R.id.Email);
        Topics = findViewById(R.id.Topics);
        Age    = findViewById(R.id.Age);
        Create = findViewById(R.id.Create);

        Create.setOnClickListener((view) ->{
            User user = new User(
                    Name.getText().toString(),
                    Email.getText().toString(),
                    Integer.parseInt(Age.getText().toString()),
                    Topics.getText().toString().split(",")
            );

            sendNetworkRequest(user);
        });
    }

    private void sendNetworkRequest(User user)
    {
        //create Okhttp client
        OkHttpClient.Builder okhttpClientBuilder =  new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okhttpClientBuilder.addInterceptor(logging);

        // create Retrofit instance
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClientBuilder.build());

        Retrofit retrofit = builder.build();

        //get client & call object for the request
        UserClient client = retrofit.create(UserClient.class);
        Call<User> call = client.createAccount(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(MainActivity.this, "Yeah! User-ID:" + response.body().getId(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "sth went wrong :( ", Toast.LENGTH_SHORT).show();
            }
        });


    }

}