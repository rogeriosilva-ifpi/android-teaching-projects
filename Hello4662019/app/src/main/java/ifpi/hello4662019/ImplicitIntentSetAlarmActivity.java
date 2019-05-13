package ifpi.hello4662019;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ImplicitIntentSetAlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent_set_alarm);
    }

    public void setAlarme(View view){
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR, 16);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 33);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Aula");


        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }


    }

    public void obterContato(View view){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, 100);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK){
            Uri contato = data.getData();

            // TODO: obter dados do contato.
            String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NORMALIZED_NUMBER};
            Cursor cursor = getContentResolver().query(contato, projection,
                    null, null, null);
            // If the cursor returned is valid, get the phone number
            if (cursor != null && cursor.moveToFirst()) {
                int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NORMALIZED_NUMBER);
                String number = cursor.getString(numberIndex);
                // Do something with the phone number
                Toast.makeText(this, "Phone: " + number, Toast.LENGTH_SHORT).show();
            }

        }
    }
}
