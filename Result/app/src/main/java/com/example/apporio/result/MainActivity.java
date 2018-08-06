package com.example.apporio.result;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView result;
    EditText text;
    Button click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=findViewById(R.id.editText);
        result=findViewById(R.id.textView);
        click=findViewById(R.id.button);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=text.getText().toString();
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("name",name);
                startActivityForResult(intent,111);
                //text.setText(""+out);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){

            case 111:

                if(resultCode==RESULT_OK){
                   String value =  data.getStringExtra("text");
                    result.setText(""+value);
                }

        }

    }
}
