
package com.atoudeft.vue;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.*;

//Panneau qui permet de gérer la cofiguration FACTURE
public class PanneauFacture extends JPanel {
    private JTextField txtMontant, txtDescription, txtNumFact;
    private JButton btnValider;
    private Client client;

    public PanneauFacture(Client client) {
        this.client = client;

        this.setLayout(new GridLayout(4, 2));


        this.add(new JLabel("Montant : "));
        txtMontant = new JTextField();
        this.add(txtMontant);

        this.add(new JLabel("numero de facture : "));
        txtNumFact = new JTextField();
        this.add(txtNumFact);

        this.add(new JLabel("decriptions : "));
        txtDescription = new JTextField();
        this.add(txtDescription);



        btnValider = new JButton("Valider");
        btnValider.setActionCommand("VALIDER_FACTURE");
        this.add(new JLabel());
        this.add(btnValider);


        btnValider.addActionListener(e -> validerFacture());
    }

    private void validerFacture() {

        String montant = txtMontant.getText();
        String description = txtDescription.getText();
        String numFact = txtNumFact.getText();


        if (montant.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un montant valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (numFact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un numero de facture valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        if (description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer une description valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }


        client.envoyer("FACTURE " + montant + " " + numFact + " " + description);


        txtMontant.setText("");
        txtDescription.setText("");
        txtNumFact.setText("");
    }
}