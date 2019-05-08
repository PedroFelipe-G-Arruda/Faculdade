package com.example.android_lp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;



public class Form2Activity extends AppCompatActivity {
    private EditText textNome, textEmail;
    private AutoCompleteTextView autoUF;
    public static final String EXTRA_MESSAGE = "br.cba.ifmt.lp3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);

        textNome = (EditText)findViewById(R.id.textNome);
        textEmail = (EditText)findViewById(R.id.textEmail);
        autoUF = (AutoCompleteTextView) findViewById(R.id.autoUF);
        final Button buttonEnviar = (Button)findViewById(R.id.buttonEnviar);

        String[] ufs = {"AC", "MT", "MS", "MG", "PA", "PR", "SP", "RJ","AM"};
        autoUF.setThreshold(1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_dropdown_item_1line,ufs);
        autoUF.setAdapter(adapter);

        buttonEnviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                buttonEnviar_onClick(view);
            }
        });
    }

    public void buttonEnviar_onClick(View view){
        Intent intent = new Intent(this,ConfirmActivity.class);
        String message = textNome.getText().toString()+";"+textEmail.getText()+";"+autoUF.getText();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
