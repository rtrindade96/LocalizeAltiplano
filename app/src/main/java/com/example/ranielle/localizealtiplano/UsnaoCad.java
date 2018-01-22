package com.example.ranielle.localizealtiplano;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import models.UserForm;

public class UsnaoCad extends AppCompatActivity {
    public static String USER_FORM_OBJECT_TAG = "USER_FORM_OBJECT";

    private Button btCtCad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usnao_cad);
    }

    public void handleContinueClick(View v) {
        UserForm signUpInfo = new UserForm();

        Intent intent = new Intent(UsnaoCad.this, UsnaoCadcont.class);

        RadioButton wantsToAdvertiseYesButton = (RadioButton) findViewById(R.id.want_to_advertise_yes);
        RadioButton wantsToAdvertiseNoButton = (RadioButton) findViewById(R.id.want_to_advertise_no);

        RadioButton livesInAltiplanoYesButton = (RadioButton) findViewById(R.id.lives_in_altiplano_yes);
        RadioButton livesInAltiplanoNoButton = (RadioButton) findViewById(R.id.lives_in_altiplano_no);


        Boolean wantsToAdvertiseYesButtonStatus = wantsToAdvertiseYesButton.isChecked();
        Boolean wantsToAdvertiseNoButtonStatus = wantsToAdvertiseNoButton.isChecked();

        Boolean livesInAltiplanoYesButtonStatus = livesInAltiplanoYesButton.isChecked();
        Boolean livesInAltiplanoNoButtonStatus = livesInAltiplanoNoButton.isChecked();


        if((!wantsToAdvertiseYesButtonStatus && !wantsToAdvertiseNoButtonStatus) || (!livesInAltiplanoYesButtonStatus && !livesInAltiplanoNoButtonStatus)){
            System.out.println("You must check all the buttons!!!");
            // Alert user that he must check all the buttons!
        } else {
            signUpInfo.livesInAltiplano = livesInAltiplanoYesButtonStatus;
            signUpInfo.wantsToAdvertise = wantsToAdvertiseYesButtonStatus;

            Bundle b = new Bundle();
            b.putSerializable(USER_FORM_OBJECT_TAG, signUpInfo);
            intent.putExtras(b);

            startActivity(intent);
        }

    }
}
