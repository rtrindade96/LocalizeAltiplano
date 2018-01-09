package com.example.ranielle.localizealtiplano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UsnaoCadcont extends AppCompatActivity {
    private Button contCad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usnao_cadcont);
        contCad = (Button) findViewById(R.id.btContcad2);
        contCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsnaoCadcont.this, FinalCad.class);
                startActivity(intent);
            }
        });
    }
}
