package com.example.ranielle.localizealtiplano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UsnaoCad extends AppCompatActivity {
    private Button btCtCad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usnao_cad);
        btCtCad = (Button) findViewById(R.id.btContcad);
        btCtCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsnaoCad.this, UsnaoCadcont.class);
                startActivity(intent);
            }
        });
    }
}
