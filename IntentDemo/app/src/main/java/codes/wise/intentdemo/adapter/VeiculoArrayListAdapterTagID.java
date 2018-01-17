package codes.wise.intentdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import codes.wise.intentdemo.R;
import codes.wise.intentdemo.model.Veiculo;

/**
 * Created by rogermac on 07/02/17.
 */

public class VeiculoArrayListAdapterTagID extends ArrayAdapter<Veiculo> {

    private List<Veiculo> mVeiculos;
    Context mContext;

    public VeiculoArrayListAdapterTagID(Context context, int resource, List<Veiculo> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mVeiculos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView txtNome;

        //Devido à Reciclagem
        if (convertView == null){

            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.item_lista, parent, false);
            //Guarda isso para reuso
            txtNome = (TextView) convertView.findViewById(R.id.txtNomeCarro);

            //Only Android 4.0+
            convertView.setTag(R.id.txtNomeCarro, txtNome);
        }else{
            //Reuso da view.
            txtNome = (TextView) convertView.getTag(R.id.txtNomeCarro);
        }

        Veiculo veiculo = mVeiculos.get(position);
        txtNome.setText(veiculo.getNome());

        return convertView;
    }

}

