package com.example.sistranfe_app.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistranfe_app.R;
import com.example.sistranfe_app.model.Resultado;
import java.util.List;


public class AdapterNfeList extends RecyclerView.Adapter<AdapterNfeList.MyViewHolder> {

    private List<Resultado> listNfe;

    public AdapterNfeList(List<Resultado> listNfe) {
        this.listNfe = listNfe;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_nfe_list, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        Resultado resultadoNfe = listNfe.get(i);
        Log.d("corpo", "adapterNfe: acao:" + resultadoNfe.acao + "  cd_ASNELN_IDE: " + resultadoNfe.cd_ASNELN_IDE + "  cd_EMPGCB_EMI: " + resultadoNfe.cd_EMPGCB_EMI);
        holder.acao.setText( resultadoNfe.acao );
        holder.cd_ASNELN_IDE.setText( String.valueOf(resultadoNfe.cd_ASNELN_IDE));
        holder.cd_EMPGCB_EMI.setText(String.valueOf(resultadoNfe.cd_EMPGCB_EMI));
        holder.st_ASNELN_STC.setText(resultadoNfe.st_ASNELN_STC);
        holder.cd_NSORI.setText(String.valueOf(resultadoNfe.cd_NSORI));

    }

    @Override
    public int getItemCount() {
        return listNfe.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView acao;
        TextView cd_EMPGCB_EMI;
        TextView cd_ASNELN_IDE;
        TextView st_ASNELN_STC;
        TextView cd_NSORI;

        public MyViewHolder(View itemView) {
            super(itemView);

            acao                     = itemView.findViewById(R.id.acao);
            cd_EMPGCB_EMI            = itemView.findViewById(R.id.cd_EMPGCB_EMI);
            cd_ASNELN_IDE            = itemView.findViewById(R.id.cd_ASNELN_IDE);
            st_ASNELN_STC            = itemView.findViewById(R.id.st_ASNELN_STC);
            st_ASNELN_STC            = itemView.findViewById(R.id.st_ASNELN_STC);
            cd_NSORI                 = itemView.findViewById(R.id.cd_NSORI);
        }
    }
}
