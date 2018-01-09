package com.example.ranielle.localizealtiplano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginLocalize extends AppCompatActivity {
    private TextView textv;
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login_localize);
        super.onCreate(savedInstanceState);

        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tlogin= (TextView) findViewById(R.id.tLogin);
                TextView tSenha= (TextView) findViewById(R.id.tSenha);
                String login = tlogin.getText().toString();
                String senha = tSenha.getText().toString();
                if (login.equals("ranielle@gmail.com")&senha.equals("1234")){
                    alert("Login realizado com sucesso");
                }
                else{
                    alert("Usuário ou senha incorretos");
                }


            }

        });

    }
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // Para o layout preencher toda tela do cel (remover a barra de tit.)
        //getSupportActionBar().hide();
        public void naocad(View v){ //Função responsável pelo onclick do textview ( sempre que ela for alterada deve se alterar tmb no .xml do text view
            Intent intent = new Intent(LoginLocalize.this, UsnaoCad.class);
            startActivity(intent);
        }




    private void alert(String s){
        Toast.makeText(this,s, Toast.LENGTH_LONG).show();
    }




}

