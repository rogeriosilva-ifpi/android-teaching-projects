package codes.wise.hellointent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editUsuario;
    private EditText editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //binding
        editUsuario = (EditText) findViewById(R.id.editUsuario);
        editSenha = (EditText) findViewById(R.id.editSenha);
    }

    public void entrar(View view){
        String usuario = editUsuario.getText().toString();
        String senha = editSenha.getText().toString();

        if (usuario.equals("rogerio") && senha.equals("123")){
            //Abrir a tela de boas vinda
            editSenha.getText().clear();

            Intent abrirFeedIntent = new Intent(this, FeedActivity.class);

            //Botar pacotes na intent
            abrirFeedIntent.putExtra("usuario", "Rogerio Silva");

            //Iniciar
            startActivity(abrirFeedIntent);
        }else{
            String msg = "Usuario e/ou senha incorreto(s).";
            Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}








