package com.example.ranielle.localizealtiplano;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FinalCad extends AppCompatActivity {
    private FirebaseAuth mAuth;
    public static String TAG = "FinalCad";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_cad);

        mAuth = FirebaseAuth.getInstance();
    }

    public void handleSignUpClick(View v){
        String email = ((EditText) findViewById(R.id.tEmail)).getText().toString();
        String password = ((EditText) findViewById(R.id.tCSenha)).getText().toString();
        String repeatedPassword = ((EditText) findViewById(R.id.tCRSenha)).getText().toString();

        if(email.isEmpty() || password.isEmpty() || repeatedPassword.isEmpty()) {
            // Alert user to fill all forms


        } else if(!password.equals(repeatedPassword)) {
            // Alert user that passwords do not match.
        } else {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();


                                // TODO: register user data in Firebase

                                Intent intent = new Intent(FinalCad.this, MainUsCom.class);
                                startActivity(intent);


                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(FinalCad.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });
        }

    }
}

