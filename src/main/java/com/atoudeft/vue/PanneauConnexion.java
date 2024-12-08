package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauConnexion extends JPanel {
    private JTextField txtNumCompteClient, txtNip;
    private JButton bNouveau, bConnecter;


    public PanneauConnexion() {

        // Crée des étiquettes pour le numéro du compte-client et NIP
        JLabel lNumCompteClient = new JLabel("Numero compte-client : "),
                lNip = new JLabel("NIP : ");

        // Crée des champs de texte pour saisir le numéro de compte-client et NIP
        txtNumCompteClient = new JTextField(30);
        txtNip = new JTextField(30);

        // Ajoute des bordures aux champs de texte avec un titre
        txtNumCompteClient.setBorder(BorderFactory.createTitledBorder("Numero compte-client : "));
        txtNip.setBorder(BorderFactory.createTitledBorder("NIP : "));

        // Crée des boutons pour la création d'un compte et la connexion
        bNouveau = new JButton("Créer compte");
        bConnecter = new JButton("Connexion");

        //  Commandes d'action pour les boutons
        bNouveau.setActionCommand("NOUVEAU");
        bConnecter.setActionCommand("CONNECT");

        // crée des panneaux pour organiser les éléments graphiques
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel pTout = new JPanel(new GridLayout(3,1));

        // Ajoute les champs de texte et les boutons dans les panneaux
        p1.add(txtNumCompteClient);
        p2.add(txtNip);
//
//        p2.add(lNip);
//        p2.add(txtNip);

        p3.add(bNouveau);
        p3.add(bConnecter);

        // Configurer dela disposition du panneau principal
        this.setLayout(new BorderLayout());
        pTout.add(p1);
        pTout.add(p2);
        pTout.add(p3);
        this.add(pTout, BorderLayout.NORTH);
        //Bordure autoure du panneau de connexion
        this.setBorder(BorderFactory.createLineBorder(new Color(0x00000000,true),200));
    }
    //Associe un écouteur d'événements pour gérer les actions des utilisateurs
    public void setEcouteur(ActionListener ecouteur) {
        bNouveau.addActionListener(ecouteur);
        bConnecter.addActionListener(ecouteur);
    }

    // renvoie le texte saisi dans le champ de texte du numéro de compte-client
    public String getNumeroCompteClient() {
        return this.txtNumCompteClient.getText();
    }

    // renvoie le texte saisie dans le champ de texte du NIP
    public String getNip() {
        return this.txtNip.getText();
    }

    // reinitilaise le champs de texte du numéro du compte-client et NIP
    public void effacer() {
        this.txtNumCompteClient.setText("");
        this.txtNip.setText("");
    }
}
