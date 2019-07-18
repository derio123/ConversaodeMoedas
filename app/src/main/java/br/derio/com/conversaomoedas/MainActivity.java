package br.derio.com.conversaomoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obter e identificar os elementos da Interface
        //EditText valor = findViewById(R.id.edit_value);
        //valor.getText();

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = findViewById(R.id.edit_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.edit_euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calcule);

        //onClick
        this.mViewHolder.buttonCalculate.setOnClickListener(this);
        this.mViewHolder.textDolar.setOnClickListener(this);
        this.mViewHolder.textEuro.setOnClickListener(this);

        this.clearValues();
    }

    //Trata os elementos no onClick
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_calcule){
            String value = this.mViewHolder.editValue.getText().toString();
            if ("".equals(value)){
                //Mostra a msm pro usuario
                Toast.makeText(this, this.getText(R.string.informe_valor), Toast.LENGTH_LONG).show();
            } else{
                Double real = Double.valueOf(value);
                this.mViewHolder.textDolar.setText(String.format("%.2f", (real / 4)));
                this.mViewHolder.textEuro.setText(String.format("%.2f", (real / 5)));
            }
        }
    }

    //ViewHolder
    private static class ViewHolder { //Só chama uma o "findViewById"
        EditText editValue; //Agrega todos os elementos da interface
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
    }

    //Limpar os valores
    private void clearValues(){
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }
}
