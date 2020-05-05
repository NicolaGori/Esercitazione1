package com.example.esercitazione1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class second_page extends AppCompatActivity {

    Button bt_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);


        //RECUPERO IL BOTTONE
        bt_home = findViewById(R.id.bt_home);
        //AL CLICK DEL BOTTONE
        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //VISUALIZZARE CIO' CHE ARRIVA DALLA PRIMA ACTIVITY
                //recuperare l'activity
                Intent intent = getIntent();//prendo l'intent
                Bundle b = intent.getExtras();//prendo tutto il "fagotto" || SERVE A RECUPERARE I DATI PASSATI //getExtras le prende tutte, getStringExtras prende tutte le stringhe che corrispondono alla chiave
                String testo = b.getString("chiave");//dentro testo valore della variabile

                //TORNO ALLA PRIMA
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("Message", "");
                setResult(1, i);//1 perchè era quello che si aspettava la MainActivity, e poi metto l'intent
                finish();//una volta fato il click, avviato l'intent, l'intent vuol far partire la seconda activity (già presente in memoria ma in pausa), automaticamente verrà visualizzata l'activity precedente
            }
        });

    }
}

////Sostituire la textView
//        TextView etichetta = (TextView)findViewById(R.id.txt_BenArrivato);//recupere la textView e sostituire Ben Arrivato
//        etichetta.setText(testo);