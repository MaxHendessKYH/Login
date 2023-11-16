package com.example.mvc_123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userNameInput;
    EditText userPassowrdInput;
    DataManager dataManager = new DataManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameInput = findViewById(R.id.editText_Name);
        userPassowrdInput = findViewById(R.id.editText_Password);
        Button loginBtn = findViewById(R.id.button_login);
        Button registerBtn = findViewById(R.id.button_register);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v)
            {
                String name = userNameInput.getText().toString();
                String password = userPassowrdInput.getText().toString();
                User u = dataManager.createUser(name, password);
                Toast.makeText(MainActivity.this,"Create user:" + u.toString(), Toast.LENGTH_SHORT).show();
            }

        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String name = userNameInput.getText().toString();
                String password = userPassowrdInput.getText().toString();
                if(DataManager.validateUser(name, password)) {
                    Intent intent = new Intent(MainActivity.this, MemberActivity.class);
                    startActivity(intent);
//                    Toast.makeText(MainActivity.this, "Login succesfull", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}