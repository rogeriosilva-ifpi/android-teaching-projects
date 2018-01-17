package codes.wise.intentdemo;

import android.Manifest;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Permission;

public class SegundaActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int PERMISSION_CALL_PHONE_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        //Pegar a intent de chamada e o parametro enviado
        Intent intent = getIntent();
        String pacote = intent.getStringExtra("pacote");

        //Colocar o valor recebido na tela
        TextView label = (TextView) findViewById(R.id.labelRecebido);
        label.setText(pacote);

        //Associar esta active como listener do botao
        Button btnConcluido = (Button) findViewById(R.id.btnretorno);
        btnConcluido.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        EditText edRetorno = (EditText) findViewById(R.id.caixaretorno);

        if (view.getId() == R.id.btnretorno) {
            Intent intent = new Intent();
            intent.putExtra("retorno", edRetorno.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.ligar:
                Uri uriLigar = Uri.parse("tel:86994593247");
                Intent intentligar = new Intent(Intent.ACTION_CALL, uriLigar);

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)){

                        new AlertDialog.Builder(this)
                                .setMessage("Precisamos de autorização para usar o App Telefone.")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        ActivityCompat.requestPermissions(SegundaActivity.this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_CALL_PHONE_CODE);
                                    }
                                })
                                .setNegativeButton("Cancelar", null)
                                .show();

                    }else{
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_CALL_PHONE_CODE);
                    }
                    return true;
                }

                startActivity(intentligar);
                break;

            case R.id.openurl:
                Uri uriURL = Uri.parse("http://www.globo.com");
                Intent intentURL = new Intent(Intent.ACTION_VIEW, uriURL);
                startActivity(intentURL);
                break;

            case R.id.hello:
                //Intent intentHello = new Intent("codes.wise.intent.action.HELLO_ACTION");
                Intent intentHello = new Intent(this, HelloActivity.class);
                startActivity(intentHello);
                break;

//            case R.id.hello_notication:
//                Intent intent = new Intent(this, HelloActivity.class);
//                PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
//                createAndAddNotification(pi, R.drawable.icon_notify, "OK..notificou?");
//                break;
//            case R.id.so_mobile:
//                Intent intentSO = new Intent(this, MobileSOActivity.class);
//                startActivity(intentSO);
//                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CALL_PHONE_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Obrigado por autorizar. Agora vc pode fazer ligacoes.", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Se desejar realizar chamadas mais tarde deve autorizar.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }


    public void createAndAddNotification(PendingIntent pi, int notificatinIcon, String notification){
        long notificationTimeStamp = System.currentTimeMillis();
        Notification notification1 = (new Notification.Builder(this))
                .setSmallIcon(notificatinIcon)
                .setContentTitle("Notificacao")
                .setContentText(notification)
                .setContentIntent(pi)
                .build();

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(10, notification1);
    }
}
