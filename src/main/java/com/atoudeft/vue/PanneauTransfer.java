package com.atoudeft.vue;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Panneau qui permet de gérer la configuration TRANSFÉRER

public class PanneauTransfer extends JPanel {
    private JTextField txtMontant, txtCompteDestinataire;
    private JButton btnValider;
    private Client client;

    public PanneauTransfer(Client client) {
        this.client = client;

        this.setLayout(new GridLayout(3, 2));

        //  Ajoute un JLabel et un champ de texte pour saisir le montant
        this.add(new JLabel("Montant : "));
        txtMontant = new JTextField();
        this.add(txtMontant);

        // Ajoute un JLabel et un champ de texte pour saisir le compte destinataire
        this.add(new JLabel("Compte destinataire : "));
        txtCompteDestinataire = new JTextField();
        this.add(txtCompteDestinataire);

        // Crée  le bouton Valider
        btnValider = new JButton("Valider");
        btnValider.setActionCommand("VALIDER_TRANSFERT");
        this.add(new JLabel());
        this.add(btnValider);

        //Ajoute l'écouteur d'action pour le bouton
        btnValider.addActionListener(e -> validerTransfert());
    }



    private void validerTransfert() {

        // Récupère les valeurs saisies
        String montant = txtMontant.getText();
        String compteDestinataire = txtCompteDestinataire.getText();

        // Vérifie si le montant est bien saisie et c'est un chiffre
        if (montant.isEmpty() || !montant.matches("\\d+(\\.\\d{1,2})?")) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un montant valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Vérifie l'entrée du compte destinataire est vide
        if (compteDestinataire.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un compte destinataire valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Envoi de la commande de transfert au serveur
        client.envoyer("TRANSFERT " + montant + " " + compteDestinataire);

        // réinitialise les champs de texte après l'envoi
        txtMontant.setText("");
        txtCompteDestinataire.setText("");

    }
}