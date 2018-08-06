package com.example.apporio.spinnerproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Logic {

    Spinner sp2,sp3;
    EditText editText;
    TextView textView;
    Button button;
    String spinner1,spinner2;

    private Context context;

     public Logic(final Context context, Spinner sp2, Spinner sp3, EditText e1, TextView t3, final Button btn){
        this.sp2= sp2;
        this.sp3 = sp3;
        this.editText= e1;
        this.textView= t3;
        this.button= btn;

        this.context = context;


        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner1=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                spinner2=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editText.getText().toString().trim().isEmpty()){
                    Toast.makeText(context, "Please enter value", Toast.LENGTH_SHORT).show();
                }else {
                    Double d = Double.parseDouble(editText.getText().toString());

                    if (spinner1.equals("Doller") && spinner2.equals("Rupee")) {
                        Double output = (d * 68);
                        textView.setText("" + output);

                    } else if (spinner1.equals("Doller") && spinner2.equals("Dinar")) {

                        Double output = (d * 0.71);
                        textView.setText("" + output);

                    } else if (spinner1.equals("Rupee") && spinner2.equals("Doller")) {


                        Double output = (d * 0.01);
                        textView.setText("" + output);

                    } else if (spinner1.equals("Rupee") && spinner2.equals("Dinar")) {


                        Double output = (d * 0.0044);
                        textView.setText("" + output);

                    } else if (spinner1.equals("Dinar") && spinner2.equals("Rupee")) {


                        Double output = (d * 97.06);
                        textView.setText("" + output);

                    } else if (spinner1.equals("Dinar") && spinner2.equals("Doller")) {

                        Double output = (d * 1.41);
                        textView.setText("" + output);

                    } else if (spinner1.equals("Meter") && spinner2.equals("km")) {

                        Double output = (d / 1000);
                        textView.setText("" + output);

                    } else if (spinner1.equals("Meter") && spinner2.equals("Cm")) {

                        Double output = (d * 100);
                        textView.setText("" + output);

                    } else if (spinner1.equals("km") && spinner2.equals("Meter")) {

                        Double output = (d * 1000);
                        textView.setText("" + output);

                    } else if (spinner1.equals("km") && spinner2.equals("Cm")) {

                        Double output = (d * 100000);
                        textView.setText("" + output);

                    } else if (spinner1.equals("Cm") && spinner2.equals("Meter")) {

                        Double output = (d / 100);
                        textView.setText("" + output);

                    } else if (spinner1.equals("Cm") && spinner2.equals("km")) {

                        Double output = (d / 100000);
                        textView.setText("" + output);

                    } else if (spinner1.equals("Cm") && spinner2.equals("km")) {

                        Double output = (d / 100000);
                        textView.setText("" + output);

                    } else if (spinner1.equals("Doller") && spinner2.equals("Doller")) {

                        // editText.setError("Selection match");

                        textView.setText("");
                        editText.setError("Parameter match!");
                        editText.setText("");

                    } else if (spinner1.equals("Rupee") && spinner2.equals("Rupee")) {
                        //  editText.setError("Selection match");

                        textView.setText("");
                        editText.setError("Parameter match!");
                        editText.setText("");


                    } else if (spinner1.equals("Dinar") && spinner2.equals("Dinar")) {

                        //  editText.setError("Selection match");

                        textView.setText("");
                        editText.setError("Parameter match!");
                        editText.setText("");


                    } else if (spinner1.equals("Meter") && spinner2.equals("Meter")) {

//                    editText.setError("Selection match");

                        textView.setText("");
                        editText.setError("Parameter match!");
                        editText.setText("");


                    } else if (spinner1.equals("km") && spinner2.equals("km")) {

                        //   editText.setError("Selection match");

                        textView.setText("");
                        editText.setError("Parameter match!");
                        editText.setText("");


                    } else if (spinner1.equals("Cm") && spinner2.equals("Cm")) {

                        //   editText.setError("Selection match");

                        textView.setText("");
                        editText.setError("Parameter match!");
                        editText.setText("");


                    }

                }
            }
        });

    }

}
