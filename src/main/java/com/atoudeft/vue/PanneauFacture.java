
package com.atoudeft.vue;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.*;

//Panneau qui permet de gérer la configuration FACTURE
public class PanneauFacture extends JPanel {
    private JTextField txtMontant, txtDescription, txtNumFact;
    private JButton btnValider;
    private Client client;

    public PanneauFacture(Client client) {

        //Initialise l'objet client
        this.client = client;

        this.setLayout(new GridLayout(4, 2));


        // Ajoute un JLabel et un champ texte pour le montant, numéro de facture et une description
        this.add(new JLabel("Montant : "));
        txtMontant = new JTextField();
        this.add(txtMontant);

        this.add(new JLabel("numero de facture : "));
        txtNumFact = new JTextField();
        this.add(txtNumFact);

        this.add(new JLabel("decriptions : "));
        txtDescription = new JTextField();
        this.add(txtDescription);


        // Crée et définit la commande d'action pour le bouton Valider
        btnValider = new JButton("Valider");
        btnValider.setActionCommand("VALIDER_FACTURE");
        this.add(new JLabel());
        this.add(btnValider);

        // Ajoute un écouteur d'action au bouton Valider
        btnValider.addActionListener(e -> validerFacture());
    }


    private void validerFacture() {

        // Récupère les valeurs saisies de l'utilisateur  ( Montant, numéro de facture et description)
        String montant = txtMontant.getText();
        String description = txtDescription.getText();
        String numFact = txtNumFact.getText();

        // Affiche un erreur si le montant est vide
        if (montant.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un montant valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Affiche un erreur si le numéro de facture est vide
        if (numFact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un numero de facture valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        // Affiche un erreur si la description est vide
        if (description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer une description valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Envoie la commande FACTURE au serveur avec les valeurs saisies
        client.envoyer("FACTURE " + montant + " " + numFact + " " + description);

        // Réinitialise les champs de texte après l'envoi
        txtMontant.setText("");
        txtDescription.setText("");
        txtNumFact.setText("");
    }
}