package com.example.apporio.openapp;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    BarChart barChart;
    String rs;
    String ra;
    int i;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barChart=findViewById(R.id.barchart);

        conexionBD();


        ArrayList<BarEntry> barEntries = new ArrayList<>(); //edades

        for (a = 1; a == i; a++) {

            barEntries.add(new BarEntry(Float.parseFloat(ra), i));

        }


        BarDataSet barDataSet = new BarDataSet(barEntries, "  EDADES");



        ArrayList<String> Day = new ArrayList<>(); //nombres
        for (i = 0; i > 0; i++) {
            Day.add(rs);
        }


        BarData theData = new BarData((IBarDataSet) Day, barDataSet);
        barChart.setData(theData);

     //   barChart.setVisibleXRange(20); // allow 20 values to be displayed at once on the x-axis, not more
        barChart.moveViewToX(10);

        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);

     //   barChart.setDescription("INDICADOR DE EDADES OPDM");
    }
    public Connection conexionBD() {
        Connection conexionBD = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexionBD = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.67;databaseName=opdm;user=Jose;password=123;");

            Statement sentencia = conexionBD.createStatement();
            ResultSet rs = sentencia.executeQuery("select nombre from usuarios");
            Statement sentenia1 = conexionBD.createStatement();
            ResultSet ra = sentenia1.executeQuery("select codigo from ususarios");


            while (rs.next()) {


            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return conexionBD;
    }

}
