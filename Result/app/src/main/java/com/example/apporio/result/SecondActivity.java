package com.example.apporio.result;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText text2;
    Button click2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        text2=findViewById(R.id.editText2);
        click2=findViewById(R.id.button2);



        click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                String n=intent1.getStringExtra("name");

               setResult(RESULT_OK,intent1.putExtra("text",(n+text2)));
               finish();
            }
        });



    }
}
