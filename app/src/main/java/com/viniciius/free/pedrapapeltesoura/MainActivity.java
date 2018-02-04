package com.viniciius.free.pedrapapeltesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //PEGANDO A ESCOLHA DO USUARIO
    public void choise_pedra (View view){
        this.usuarioChoice("pedra");
    }
    public void choise_papel (View view){
        this.usuarioChoice("papel");
    }
    public void choise_tesoura (View view){
        this.usuarioChoice("tesoura");
    }


    int contador=0;


    //TRATATIVA PARA GERAR O RESULTADO DO PC ALEATORIO
    public void usuarioChoice (String escolhido){

        //img do resultado
        ImageView imagemResultado =findViewById(R.id.img_resultado);

        TextView txtresultado = findViewById(R.id.txtTexto_contador);
        int int_txtresultado = Integer.parseInt(txtresultado.getText().toString());
        System.out.println(escolhido);


        /* Número aleatório para gerar de 0 à 2 (papel, tesoura, pedra)
        */
        int n_aleatorio = new Random().nextInt(3);

        String[] n_escolhas = {"pedra","papel","tesoura"};
        String n_AleatEscolha = n_escolhas[n_aleatorio];
        System.out.println(n_AleatEscolha);


        //comparando se valor escolhido p/ usuario == valor aleatorio

        switch (n_AleatEscolha){
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra_icon); break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel_icon);break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura_icon);
        }

        //COMPARANDO ESCOLHA X ESCOLHA ALEATÓRIA

        if(n_AleatEscolha == "pedra" && escolhido == "tesoura" ||
                n_AleatEscolha == "papel" && escolhido == "pedra" ||
                n_AleatEscolha == "tesoura" && escolhido == "papel"){
            contador = contador - 1;
        }else
        if(escolhido == "pedra" && n_AleatEscolha =="tesoura" ||
                escolhido == "papel" && n_AleatEscolha == "pedra" ||
                escolhido == "tesoura" && n_AleatEscolha == "papel"){
            contador = contador+1;
        }


        txtresultado.setText( String.valueOf(contador) );

    }


}