package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static String EXTRA_REPLY = "extra.REPLY";
    private TextView gotTextView;
    private EditText editTextToSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        gotTextView = findViewById(R.id.gotTextView);
        editTextToSend = findViewById(R.id.editTextToSend);

        Intent intent = getIntent();
        gotTextView.setText(intent.getStringExtra(MainActivity.EXTRA_MESSAGE));
    }

    public void BackToMainActivity(View view) {
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, editTextToSend.getText().toString());
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}