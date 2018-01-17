package com.example.rogermac.hellomenus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ActionMode actionMode;

    public ActionMode.Callback actionModeCallBack = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.actionmode_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {

            Toast.makeText(getApplicationContext(),
                    "Teste action mode click",
                    Toast.LENGTH_SHORT).show();

            actionMode.finish();

            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            MainActivity.this.actionMode = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // register for context menu
        Button btnCtxMenu = findViewById(R.id.btn_ctx_menu);
        Button btnCtxMenu2 = findViewById(R.id.btn_ctx_menu2);
        registerForContextMenu(btnCtxMenu);
        registerForContextMenu(btnCtxMenu2);

        // action mode
        Button btnActionMode = findViewById(R.id.btn_ctx_actionbar);

        btnActionMode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                // ja esta em ActionMode
                if (actionMode != null){
                    return false;
                }

                //Entrar em ActionMode
                actionMode = MainActivity.this.startActionMode(actionModeCallBack);
                view.setSelected(true);
                return true;
            }
        });

        // Popup menu
        Button btnPopupMenu = findViewById(R.id.btn_popup);
            // onclick via lambda java 8
        btnPopupMenu.setOnClickListener((view) -> {
            //inflar menu
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
            MenuInflater inflater = popupMenu.getMenuInflater();
            inflater.inflate(R.menu.popup_menu, popupMenu.getMenu());

            //Click listener
            popupMenu.setOnMenuItemClickListener((menuItem) -> {
                switch (menuItem.getItemId()){
                    case R.id.popup_item01: popupAction01(); break;
                    case R.id.popup_item02: popupAction02(); break;
                }
                return true;
            });

            // exibir popupmenu
            popupMenu.show();

        });

    }

    // actionbar options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void clickFavorite(MenuItem item) {
//        Toast.makeText(this, "Favoritar 2", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, SegundaActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_favorite:
                Toast.makeText(this, "Favoritar 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_item_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // contextMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        // select Context Menu to show
        if (v.getId() == R.id.btn_ctx_menu){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.context_menu, menu);
        }else{
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.context_menu_02, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.context_item_01:
                executarAcao01();
                return true;
            case R.id.context_item_02:
                executarAcao02();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    private void executarAcao02() {
        Toast.makeText(this, "Acao 02", Toast.LENGTH_SHORT).show();
    }

    private void executarAcao01() {
        Toast.makeText(this, "Acao 01", Toast.LENGTH_SHORT).show();
    }

    private void popupAction01() {
        Toast.makeText(this, "Popup Acao 01", Toast.LENGTH_SHORT).show();
    }

    private void popupAction02() {
        Toast.makeText(this, "Popup Acao 02", Toast.LENGTH_SHORT).show();
    }
}
