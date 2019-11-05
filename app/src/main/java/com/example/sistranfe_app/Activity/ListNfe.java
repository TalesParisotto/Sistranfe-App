package com.example.sistranfe_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.example.sistranfe_app.R;
import com.example.sistranfe_app.adapter.AdapterNfeList;
import com.example.sistranfe_app.api.NfeService;
import com.example.sistranfe_app.helper.RetrofitConfig;
import com.example.sistranfe_app.listener.RecyclerItemClickListener;
import com.example.sistranfe_app.model.Resultado;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListNfe extends AppCompatActivity {

    private Button btnProcess;
    private RecyclerView rycyclerNfeList;
    private AdapterNfeList adapterNfeList;
    private Resultado resultado;
    private Bundle dados;

    private List<Resultado> listNfeResultado = new ArrayList<>();

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nfe);

        dados = getIntent().getExtras();

        initComponenets();

        recuperarNfeList();
    }

    private void recuperarNfeList() {

        NfeService nfeService = retrofit.create(NfeService.class);
        nfeService.recuperarRepo(
                dados.toString()
        ).enqueue(new Callback<Resultado>() {
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                if (response.isSuccessful()) {
                    resultado = response.body();
                    listNfeResultado.add(resultado);
                    configurarRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {

            }
        });

    }

    public void configurarRecyclerView () {

        adapterNfeList = new AdapterNfeList(listNfeResultado  /*, this*/);
        rycyclerNfeList.setHasFixedSize(true);
        rycyclerNfeList.setLayoutManager(new LinearLayoutManager(this));
        rycyclerNfeList.setAdapter(adapterNfeList);

        //Configura evento de clique
        rycyclerNfeList.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        this,
                        rycyclerNfeList,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, final int position) {

                                Toast.makeText(ListNfe.this, "O item foi clicado",
                                        Toast.LENGTH_SHORT).show();

                               // Intent i = new Intent(getApplicationContext(),PullActivity.class);
                                //startActivity(i);

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

    }

    public void initComponenets(){
        btnProcess.findViewById(R.id.btnProcess);
        rycyclerNfeList.findViewById(R.id.RycyclerNfeList);
        retrofit = RetrofitConfig.getRetrofit();
    }
}
