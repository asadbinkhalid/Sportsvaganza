package com.asad.sportsvaganza.Activities;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.text.TextUtils;
import android.widget.EditText;

import com.asad.sportsvaganza.R;

public class Activity_Login_Main extends AppCompatActivity {

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
                if (strPassword.length()<6){
                    etPass.setError("Password Contains Less Than 6 Characters");
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
                    Intent intent = new Intent(Activity_Login_Main.this, Activity2_gamesList.class);
                    startActivity(intent);
                }
                else
                    return;
            }
        });
    }
}
