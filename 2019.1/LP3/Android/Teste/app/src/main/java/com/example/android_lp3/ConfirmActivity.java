package com.example.android_lp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Form2Activity.EXTRA_MESSAGE);

        TextView txcNome = findViewById(R.id.txcNome);
        TextView txcEmail = findViewById(R.id.txcEmail);
        TextView txcUF = findViewById(R.id.txcUF);

        String values[] = message.split(";");

        txcNome.setText(values[0]);
        txcEmail.setText(values[1]);
        txcUF.setText(values[2]);
    }
}
