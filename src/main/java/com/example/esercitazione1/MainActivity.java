package com.example.esercitazione1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button cancella;
    static final int REQUESTE_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recupero il Testo
        name = (EditText) findViewById(R.id.insertName);

        Log.d("MainActivity", "onCreate()");//stringa, valore //inserisco un messaggioda vedere in Logcat

        //Recupero il Bottone
        Button bClick = (Button) findViewById(R.id.buttonCiao); //RECUPERO DEL BOTTONE DALLA GRAFICA
        cancella = (Button) findViewById(R.id.bt_cancella);

        //────────────Al Click del Bottone────────────//
        //Click
        bClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = name.getText().toString();//getText prende il testo scritto
                //getText()  restituisce un editable, toString  prendo la stringa

                //────────────GENERAZIONE DEL MESSAGGIO────────────//
                Toast messaggio = Toast.makeText(getApplicationContext(), "Ciao " + nome, Toast.LENGTH_SHORT);
                messaggio.show();//MOSTRO IL MESSAGGIO

                Intent i = new Intent(getApplicationContext(), second_page.class);//contesto di partenza, nome activity di destinazione //per trasferire dati tra activity serve il bundle
                i.putExtra("testo", nome); //INVIO DEI DATI
                //startActivity(i);//lancio l'altra activity
                startActivityForResult(i, REQUESTE_CODE);//mi metto nelle condizioni di accettare dati da altre activity
                //bisogna sovrascrivere onActivityResult()
            }
        });

        //────────────Eliminazione del Contenuto della Casella testuale────────────//
        cancella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CLEAR TEXT
                name.getText().clear();
                //name.setText("");
            }
        });

    }
    //al click di Ciao...
    public void sendMessage(View view){
        Intent intent = new Intent(getApplicationContext(), second_page.class);
        intent.putExtra("chiave", "Ciao");//primo parametro stringa perché è un array associativo, chiave e valore
        startActivity(intent); //avvio l'intent
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult( requestCode, resultCode, data);
        if (requestCode==REQUESTE_CODE){
            String message = data.getStringExtra("MESSAGE");//tutte le stringhe che hanno MESSAGE come chiave
            name.setText(message);
        }
    }
/*i primi due (|int requestCode, int resultCode,|) servono per recuperarli e confrontarli; se quello che richiedo è lo stesso che ritorna
la seconda activity mi deve restituire 1 altrimenti non riesco ad associare; come una corrispondenza di chiavi
 */
}
