package com.nlrd.tereza.models;

import java.io.Serializable;

/**
 * Created by dharmesh panchal on 18-09-2016.
 */
public class HomeObject implements Serializable {
    public String news_id = "";
    public String news_title = "Ceci est un grand TITRE :D ";
    public String news_description = "Tereza, la plateforme qui vous rapproche !.\n " +
            "Réservez en ligne chez le coiffeur qui est fait pour vous." +
            "Accédez aux agendas en continu (même le dimanche soir à 23h)" +
            "Vérifiez la qualité du coiffeur grâce aux avis laissés." +
            "Découvrez les prestations et les prix au moment de les réserver. \n \n" +

            "Ne soyez plus interrompu par la sonnerie du téléphone." +
            "Mettez votre planning en ligne pour que vos clients réservent." +
            "La plage horaire est réservée selon la prestation demandée par le client." +
            "La grille de réservation a été conçue en collaboration avec des coiffeurs.";
    public String news_authorname = "Mme Tereza";
    public String news_published_date = "01-01-2017";

}
