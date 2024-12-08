
package com.atoudeft.vue;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

//panneau qui permet de gérer DEPOT
public class PanneauDepot extends JPanel {
    private JTextField txtMontant;
    private JButton btnValider;
    private Client client;

    public PanneauDepot(Client client) {
        // Initialise l'objet client
        this.client = client;

        // définit la disposition du panneau grille
        this.setLayout(new GridLayout(2, 2));

        // Ajoute un Jlabel  et un champ de texte pour écrire le montant
        this.add(new JLabel("Montant : "));
        txtMontant = new JTextField();
        this.add(txtMontant);

        // Crée et définit la commande d'action le bouton Valider
        btnValider = new JButton("Valider");
        btnValider.setActionCommand("VALIDER_DEPOT");
        this.add(new JLabel()); // Spacer
        this.add(btnValider);

        // Ajoute un écouteur d'action au bouton Valider
        btnValider.addActionListener(e -> validerDepot());
    }

    // Vérifie si le montant saisie
    private void validerDepot() {

        // Récupère le montant saisi dans le champ de texte
        String montant = txtMontant.getText();

        // le montant n'est pas vide
        if (montant.isEmpty() ) {

            //Affiche un message d'erreur si le montant est vide
            JOptionPane.showMessageDialog(this, "Veuillez entrer un montant valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Envoie la commande de dépôt avec le montant au serveur
        client.envoyer("DEPOT " + montant);

        // Réinitilaise le champ de texte après l'envoi
        txtMontant.setText("");
        JOptionPane.showMessageDialog(this, "Depot envoyé avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
    }
}