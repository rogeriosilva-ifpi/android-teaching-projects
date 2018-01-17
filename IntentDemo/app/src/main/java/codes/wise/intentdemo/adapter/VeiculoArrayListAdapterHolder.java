package codes.wise.intentdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import codes.wise.intentdemo.R;
import codes.wise.intentdemo.model.Veiculo;

/**
 * Created by rogermac on 07/02/17.
 */

public class VeiculoArrayListAdapterHolder extends ArrayAdapter<Veiculo> {

    private List<Veiculo> mVeiculos;
    Context mContext;

    public VeiculoArrayListAdapterHolder(Context context, int resource, List<Veiculo> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mVeiculos = objects;
    }

    private static class ViewHolder{
        public final TextView txtNome;

        public ViewHolder(TextView txtNome){
            this.txtNome = txtNome;
        }
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView txtNome;

        if (convertView == null){
            //Devido à Reciclagem e evitando muitos findViewById
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.item_lista, parent, false);
            //Guarda isso para reuso
            txtNome = (TextView) convertView.findViewById(R.id.txtNomeCarro);
            convertView.setTag(new ViewHolder(txtNome));
        }else{
            //Reuso da view.
            ViewHolder holder = (ViewHolder) convertView.getTag();
            txtNome = holder.txtNome;
        }

        Veiculo veiculo = mVeiculos.get(position);
        txtNome.setText(veiculo.getNome());

        return convertView;
    }

}

