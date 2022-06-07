package com.example.atividade4;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProcessarTask extends AsyncTask<Integer, Integer, Void> {

    Button btnIniciar;
    TextView txtContador;

    public ProcessarTask(Button btnIniciar, TextView txtContador){
        this.btnIniciar = btnIniciar;
        this.txtContador = txtContador;
    }

    // Método executado antes da thread iniciar
    @Override
    protected void onPreExecute() {
        btnIniciar.setEnabled(false);
        txtContador.setVisibility(View.VISIBLE);
    }

    // Método que atualiza a View com o resultado
    @Override
    protected void onPostExecute(Void unused) {
        btnIniciar.setEnabled(true);
    }

    // Método que informa a qtd. do progresso
    @Override
    protected void onProgressUpdate(Integer... values) {
        int p = values[0];
        txtContador.setText(String.valueOf(p).toString());
    }

    // Método executado por uma thread, que retorna um objeto , o qual será passado como parâmetro para o método onPostExecute()
    // Regra: não pode interagir com elementos da interface gráfica
    @Override
    protected Void doInBackground(Integer... integers) {
        int max = integers[0];
        for(int i=max; i >= 0; i--){
            SystemClock.sleep(1000);     // método usado para informar o progresso
            publishProgress(i);
       }
        return null;
    }
}
