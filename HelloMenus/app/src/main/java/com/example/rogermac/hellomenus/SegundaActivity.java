package com.example.rogermac.hellomenus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private ActionMode actionMode;
    private ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            MenuInflater inflater = actionMode.getMenuInflater();
            inflater.inflate(R.menu.actionmode_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {

            switch (menuItem.getItemId()){
                case R.id.actionmode_item01:
                    //Action 01
                    break;
                case R.id.actionmode_item02:
                    //Action 02
                    break;
            }

            actionMode.finish();

            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            SegundaActivity.this.actionMode = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView txtSaudacao = findViewById(R.id.txt_saudacao);
        txtSaudacao.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                // Exibir a Contextual ActionBar: Ativar ActionMode
                if (actionMode != null)
                    return false;

                actionMode = SegundaActivity.this.startActionMode(actionModeCallback);

                return false;
            }
        });
    }
}






