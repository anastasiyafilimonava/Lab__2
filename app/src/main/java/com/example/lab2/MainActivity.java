package com.example.lab2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // наш ответ
        ActivityResultLauncher<Intent> MainActivityResultExec = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result ->
        {
            if (result.getResultCode() == Activity.RESULT_OK)
            {
                Bundle arguments = result.getData().getExtras();
                String value = arguments.get("answerData").toString();
                TextView text = (TextView) findViewById(R.id.lastInfo);
                text.setText(value);
            }
        });

        // кнопка отправки
        Button button = (Button) findViewById(R.id.SendButton);
        button.setOnClickListener(v ->
        {
            EditText text = (EditText) findViewById(R.id.FirstInfo);
            Intent intent = new Intent(v.getContext(), SecondActivity.class);
            intent.putExtra("cardData",text.getText().toString());
            MainActivityResultExec.launch(intent);
        });
    }
    */

    // через устаревший метод startActivityForResult
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // кнопка отправки
        Button button = (Button) findViewById(R.id.SendButton);
        button.setOnClickListener(v ->
        {
            EditText text = (EditText) findViewById(R.id.FirstInfo);
            Intent intent = new Intent(v.getContext(), SecondActivity.class);
            intent.putExtra("cardData",text.getText().toString());
            startActivityForResult(intent, 10);
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            if (resultCode == Activity.RESULT_OK) {
                Bundle arguments = data.getExtras();
                String result = data.getStringExtra("answerData");
                String value = arguments.get("answerData").toString();
                TextView text = (TextView) findViewById(R.id.lastInfo);
                text.setText(value);
            }
        }
    }

}