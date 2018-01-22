package com.example.ranielle.localizealtiplano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import models.User;
import models.UserForm;

public class UsnaoCadcont extends AppCompatActivity {
    public static String USER_FORM_OBJECT_TAG = "USER_FORM_OBJECT";

    private Button contCad;
    public static String TAG = "UsnaoCadCont";


    Boolean mWantsToAdvertise;
    Boolean mLivesInAltiplano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usnao_cadcont);


        contCad = (Button) findViewById(R.id.btContcad2);
        contCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserForm userForm = (UserForm) getIntent().getSerializableExtra(UsnaoCad.USER_FORM_OBJECT_TAG);

                userForm.fullName = ((EditText) findViewById(R.id.tNome)).getText().toString();
                userForm.CEP = ((EditText) findViewById(R.id.tCep)).getText().toString();
                userForm.street = ((EditText) findViewById(R.id.tEndereco)).getText().toString();
                userForm.city = ((EditText) findViewById(R.id.tCidade)).getText().toString();
                userForm.state = ((EditText) findViewById(R.id.tEstado)).getText().toString();
                userForm.CPF = ((EditText) findViewById(R.id.tCPF)).getText().toString();
                userForm.phone = ((EditText) findViewById(R.id.tTel)).getText().toString();

                if(userForm.fullName.isEmpty() || userForm.CEP.isEmpty() || userForm.street.isEmpty() || userForm.state.isEmpty() ||
                        userForm.CPF.isEmpty() || userForm.phone.isEmpty()) {
                    // Notify error
                    Log.d(TAG, "Form is incomplete");
                } else {
                    Intent intent = new Intent(UsnaoCadcont.this, FinalCad.class);
                    Bundle b = new Bundle();
                    b.putSerializable(USER_FORM_OBJECT_TAG, userForm);
                    intent.putExtras(b);
                    startActivity(intent);
                }

            }
        });
    }
}
