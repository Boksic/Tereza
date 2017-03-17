package com.nlrd.tereza.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.nlrd.tereza.R;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tv = (TextView) findViewById(R.id.aboutus);
        tv.setText("Tereza, la plateforme qui vous rapproche !.\n " +
                "Réservez en ligne chez le coiffeur qui est fait pour vous." +
                "Accédez aux agendas en continu (même le dimanche soir à 23h)" +
                "Vérifiez la qualité du coiffeur grâce aux avis laissés." +
                "Découvrez les prestations et les prix au moment de les réserver. \n \n" +

                "Ne soyez plus interrompu par la sonnerie du téléphone." +
                "Mettez votre planning en ligne pour que vos clients réservent." +
                "La plage horaire est réservée selon la prestation demandée par le client." +
                "La grille de réservation a été conçue en collaboration avec des coiffeurs.");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
