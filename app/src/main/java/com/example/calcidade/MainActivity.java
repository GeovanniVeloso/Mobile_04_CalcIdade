package com.example.calcidade;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MainActivity extends AppCompatActivity {

    private EditText tnDia;
    private EditText tnMes;
    private EditText tnAno;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tnDia = findViewById(R.id.tnDia);
        tnDia.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
        tnMes = findViewById(R.id.tnMes);
        tnMes.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
        tnAno = findViewById(R.id.tnAno);
        tnAno.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
        Button btCalc = findViewById(R.id.btCalc);
        btCalc.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);

        btCalc.setOnClickListener(op -> calc());

    }

    private void calc() {

        int dia = Integer.parseInt(tnDia.getText().toString());
        int mes = Integer.parseInt(tnMes.getText().toString());
        int ano = Integer.parseInt(tnAno.getText().toString());
        LocalDate dataNasc = LocalDate.of(ano, mes, dia);
        LocalDate now = LocalDate.now();

        int age = (int)ChronoUnit.YEARS.between(dataNasc, now);

        String res = "A sua idade é "+age+" anos";

        tvRes.setText(res);

    }
}