package com.example.atividade4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnIniciar;
    private TextView txtContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = findViewById(R.id.btnIniciar);
        txtContador = findViewById(R.id.txtContador);

        btnIniciar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        ProcessarTask task = new ProcessarTask(btnIniciar,txtContador);
        task.execute(10);
    }
}
