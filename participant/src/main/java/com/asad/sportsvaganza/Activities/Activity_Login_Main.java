package com.asad.sportsvaganza.Activities;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.asad.businesslogic.Globals;
import com.asad.businesslogic.Main;
import com.asad.sportsvaganza.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Activity_Login_Main extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button signup = findViewById(R.id.button_login);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean check = true;
                EditText etUserName = (EditText) findViewById(R.id.username);
                String strUserName = etUserName.getText().toString();
                EditText etPass = (EditText) findViewById(R.id.password);
                String strPassword = etPass.getText().toString();

                if (strUserName.contains(" ")){
                    etUserName.setError("The Username Should Not Contain Any Spaces");
                    check = false;
                }
                if(TextUtils.isEmpty(strUserName)) {
                    etUserName.setError("Username Field Cannot Be Left Empty");
                    check = false;
                }
                if (TextUtils.isEmpty(strPassword)){
                    etPass.setError("Password Field Cannot Be Left Empty");
                    check = false;
                }
                if (check) {
                    mAuth.signInWithEmailAndPassword(strUserName, strPassword)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        Retrofit retrofit = new Retrofit.Builder()
                                                .baseUrl(Api.BASE_URL)
                                                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                                                .build();
                                        Api api = retrofit.create(Api.class);
                                        Call<List<Hero>> call = api.getHeros();
                                        call.enqueue(new Callback<List<Hero>>() {
                                            @Override
                                            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {

                                                List<Hero> heroList = response.body();
                                                for (Hero h: heroList)
                                                {
                                                    Log.d("name",h.getName());
                                                }

                                            }

                                            @Override
                                            public void onFailure(Call<List<Hero>> call, Throwable t) {

                                            }
                                        });
                                        Main.getInstance();
                                        Globals.isLogin = true;
                                        Intent intent = new Intent(Activity_Login_Main.this, Activity2_gamesList.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();

                                    }
                                }
                            });

                }
            }
        });
        FirebaseApp.initializeApp(getApplicationContext());
        mAuth = FirebaseAuth.getInstance();
    }
}
