package br.com.osvaldsoza.alcoolougasolina;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText edAlcool, edGaslina;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edAlcool = findViewById(R.id.iAlcool);
        edGaslina = findViewById(R.id.iGasolina);
        resultado = findViewById(R.id.txtResultado);
    }

    public void calcular(View view) {

        String vlrAlcool = edAlcool.getText().toString();
        String vlrGasolina = edGaslina.getText().toString();

        boolean isCamposValidos = validarCampos(vlrAlcool, vlrGasolina);

        if(isCamposValidos){
            Double alcool = Double.parseDouble(vlrAlcool);
            Double gasolina = Double.parseDouble(vlrGasolina);

            if(alcool / gasolina >= 0.7){
                resultado.setText("Melhor colocar gasolina");
            }else{
                resultado.setText("Melhor colocar álcool");
            }
            edAlcool.setText("");
            edGaslina.setText("");
        }else{
            resultado.setText("Preencha os campos!");
        }
    }

    public boolean validarCampos(String pAlcool, String pGasolina) {
        boolean camposValidados = true;
        if (pAlcool == null || pAlcool.equals("") || pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }
        return camposValidados;
    }
}
