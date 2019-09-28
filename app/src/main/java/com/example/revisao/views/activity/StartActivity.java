package com.example.revisao.views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.revisao.R;
import com.google.android.material.textfield.TextInputLayout;


public class StartActivity extends AppCompatActivity {

    private TextInputLayout inputNome;
    private Button btnEnviar;
    public final static String NOME_KEY = "nome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // este é o metodo que permite a localização de um "componente"
        // atráves de um R.id. associando ao atributo criado aqui nessa classe
        initView();

        // aqui estou dizendo para ele escutar o click no botão e executar o metodo criado que esta dentro
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validacaoInputTextEEnviarParaWelcomeActivity();

            }
        });
        //Implementar a lógica de ação do botão enviar


    }

    private void validacaoInputTextEEnviarParaWelcomeActivity(){

        String nome = inputNome.getEditText().getText().toString();


        //Esse metodo faz a validação dos dados digitados
        if(nome.isEmpty()){  //se o a variavel que recebe "inputNome" for vazia...
            inputNome.setError("Digite o seu nome");  //... se true, chame o metodo setError que mostra a mensagem de erro no campo inputNome

        } else { //se false, não estiver vázio...

            // construa uma intent e inicialize...             ...inteção de sair da StartActivity para a WelcomeActivity...
            Intent intencaoDeirParaTelaWelcome = new Intent(StartActivity.this,WelcomeActivity.class);

            // ... agora construa um pacote "bundle" e inicialize...
            Bundle pacoteCominputNomeQuevaiComAIntent = new Bundle();

            //... coloque o valor e chave e seu valor dentro do meu "pacote" bundle...
            pacoteCominputNomeQuevaiComAIntent.putString(NOME_KEY,nome);

            //... aqui é onde mescalmos os dados do bundle com o da intent
            intencaoDeirParaTelaWelcome.putExtras(pacoteCominputNomeQuevaiComAIntent);

            //... este metodo irá iniciar minha activity indicada e colocar na parte superior da pilha
            startActivity(intencaoDeirParaTelaWelcome);







        }



    }

    private void initView(){
        inputNome = findViewById(R.id.textInputLayoutNome);
        btnEnviar = findViewById(R.id.btnEnviar);
    }

    //Implementar a lógica do método de envio de dados para activity
    private void enviaNomeActivity(String nome){

    }

}
