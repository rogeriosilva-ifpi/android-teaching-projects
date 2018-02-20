package com.example.rogermac.helloswipeview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by rogermac on 06/02/18.
 */

public class PageFragment extends Fragment{

    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    //Método construtor de PageFragment
    public static PageFragment newInstance(int page) {
        //Argumentos para anexar ao Fragment
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);

        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflar o layout da pagina
        View view = inflater.inflate(R.layout.fragment_tab, container, false);

        //Preencher os dados da pagina de acordo com número da pagina(tab)
        TextView textView = (TextView) view;
        textView.setText("Fragment #" + mPage);

        return view;
    }

}
