package codes.wise.intentdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import codes.wise.intentdemo.R;
import codes.wise.intentdemo.model.Veiculo;

/**
 * Created by rogermac on 07/02/17.
 */

public class VeiculoArrayListAdapter extends ArrayAdapter<Veiculo> {

    private List<Veiculo> mVeiculos;
    Context mContext;

    public VeiculoArrayListAdapter(Context context, int resource, List<Veiculo> veiculos) {
        super(context, resource, veiculos);
        this.mContext = context;
        this.mVeiculos = veiculos;
    }


    @NonNull
    @Override
    public View getView(int position, View row, ViewGroup parent) {

        //Verificar se é uma linha nova ou reciclada
        if (row == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            row = layoutInflater.inflate(R.layout.item_lista, parent, false);
        }

        //Pega os componentes da linhas
        TextView txtNome = (TextView) row.findViewById(R.id.txtNomeCarro);
        TextView txtNomeMontadora = (TextView) row.findViewById(R.id.txtNomeMontadora);
        TextView txtPreco = (TextView) row.findViewById(R.id.txtPreco);

        //Pega o objeto Veiculo na lista de veiculos
        Veiculo veiculo = mVeiculos.get(position);

        //Ajusta os valores do componentes da linha.
        txtNome.setText(veiculo.getNome());
        txtNomeMontadora.setText(veiculo.getMontadora());
        txtPreco.setText(veiculo.getValor());

        return row;
    }

}

