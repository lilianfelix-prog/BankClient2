
package com.atoudeft.vue;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.*;

public class PanneauFacture extends JPanel {
    private JTextField txtMontant, txtDescription, txtNumFact;
    private JButton btnValider;
    private Client client;

    public PanneauFacture(Client client) {
        this.client = client;

        this.setLayout(new GridLayout(3, 2));

        // Input for amount
        this.add(new JLabel("Montant : "));
        txtMontant = new JTextField();
        this.add(txtMontant);

        this.add(new JLabel("numero de facture : "));
        txtNumFact = new JTextField();
        this.add(txtNumFact);
        // Input for destination account
        this.add(new JLabel("decriptions : "));
        txtDescription = new JTextField();
        this.add(txtDescription);


        // Validation button
        btnValider = new JButton("Valider");
        btnValider.setActionCommand("VALIDER_FACTURE");
        this.add(new JLabel()); // Spacer
        this.add(btnValider);

        // Action listener for the button
        btnValider.addActionListener(e -> validerFacture());
    }

    private void validerFacture() {
        // Fetch inputs
        String montant = txtMontant.getText();
        String description = txtDescription.getText();
        String numFact = txtNumFact.getText();

        // Validate inputs
        if (montant.isEmpty() || !montant.matches("\\d+(\\.\\d{1,2})?")) {
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

        // Send command to the server
        client.envoyer("FACTURE " + montant + " " + numFact + " " + description);

        // Clear inputs after sending
        txtMontant.setText("");
        txtDescription.setText("");
        txtNumFact.setText("");
    }
}