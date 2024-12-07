
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
        this.client = client;

        this.setLayout(new GridLayout(2, 2));

        // Input for amount
        this.add(new JLabel("Montant : "));
        txtMontant = new JTextField();
        this.add(txtMontant);

        // Validation button
        btnValider = new JButton("Valider");
        btnValider.setActionCommand("VALIDER_DEPOT");
        this.add(new JLabel()); // Spacer
        this.add(btnValider);

        // Action listener for the button
        btnValider.addActionListener(e -> validerDepot());
    }

    private void validerDepot() {
        // Fetch the entered amount
        String montant = txtMontant.getText();

        // Validate input
        if (montant.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un montant valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Send command to the server
        client.envoyer("DEPOT " + montant);

        // Clear the input field after sending
        txtMontant.setText("");
        JOptionPane.showMessageDialog(this, "Depot envoyé avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
    }
}