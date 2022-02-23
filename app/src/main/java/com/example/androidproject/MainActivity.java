package com.example.androidproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    private EditText editText;
    private TextView gotTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        gotTextView = findViewById(R.id.gotTextView);
    }


    public void createSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, editText.getText().toString());
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if(resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                gotTextView.setText(reply);
            }
        }
    }
}