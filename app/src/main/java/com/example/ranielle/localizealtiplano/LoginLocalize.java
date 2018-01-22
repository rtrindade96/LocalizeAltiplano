package com.example.ranielle.localizealtiplano;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginLocalize extends AppCompatActivity {
    private static final String TAG = "LoginLocalize Activity";
    private TextView textv;
    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_localize);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }


    //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // Para o layout preencher toda tela do cel (remover a barra de tit.)
    //getSupportActionBar().hide();
    public void naocad(View v){ //Função responsável pelo onclick do textview ( sempre que ela for alterada deve se alterar tmb no .xml do text view
        Intent intent = new Intent(LoginLocalize.this, UsnaoCad.class);
        startActivity(intent);
    }

    public void handleLoginClick(View v){

        TextView tlogin= (TextView) findViewById(R.id.tLogin);
        TextView tSenha= (TextView) findViewById(R.id.tSenha);
        String login = tlogin.getText().toString();
        String senha = tSenha.getText().toString();

        if(!login.isEmpty() && !senha.isEmpty()) {
            mAuth.signInWithEmailAndPassword(login, senha)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                                Intent intent = new Intent(LoginLocalize.this, MainUsCom.class);
                                startActivity(intent);

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(LoginLocalize.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                            }

                            // ...
                        }
                    });
        }
    }




    private void alert(String s){
        Toast.makeText(this,s, Toast.LENGTH_LONG).show();
    }




}

