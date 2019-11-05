package com.example.sistranfe_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sistranfe_app.R;

public class MainActivity extends AppCompatActivity {

    private EditText editTextdafault;
    private Button btnListInput;
    private Button btnListDefault;

    private Integer minToList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        btnListInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                minToList = Integer.parseInt(editTextdafault.getText().toString());
                if (minToList   != null && minToList < 0) {
                    Intent intent = new Intent(getApplicationContext(), ListNfe.class);
                    intent.putExtra("minToList", minToList);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this,
                            "Preencha o campo de minutos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnListDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                minToList = 15;
                if (minToList != null) {
                    Intent intent = new Intent(getApplicationContext(), ListNfe.class);
                    intent.putExtra("minToList", minToList);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this,
                            "Erro ao buscar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    public void initComponents(){
        editTextdafault.findViewById(R.id.editTextdafault);
        btnListInput.findViewById(R.id.btnListInput);
        btnListDefault.findViewById(R.id.btnListDefault);
    }
}
