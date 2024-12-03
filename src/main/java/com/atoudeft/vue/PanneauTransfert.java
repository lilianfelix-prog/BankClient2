package com.atoudeft.vue;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauTransfert extends JPanel {
    private JTextField txtMontant, txtCompteDestinataire;
    private JButton btnValider;
    private Client client;

    public PanneauTransfert(Client client) {
        this.client = client;

        this.setLayout(new GridLayout(3, 2));

        // Input for amount
        this.add(new JLabel("Montant : "));
        txtMontant = new JTextField();
        this.add(txtMontant);

        // Input for destination account
        this.add(new JLabel("Compte destinataire : "));
        txtCompteDestinataire = new JTextField();
        this.add(txtCompteDestinataire);

        // Validation button
        btnValider = new JButton("Valider");
        btnValider.setActionCommand("VALIDER_TRANSFERT");
        this.add(new JLabel()); // Spacer
        this.add(btnValider);

        // Action listener for the button
        btnValider.addActionListener(e -> validerTransfert());
    }

    private void validerTransfert() {
        // Fetch inputs
        String montant = txtMontant.getText();
        String compteDestinataire = txtCompteDestinataire.getText();

        // Validate inputs
        if (montant.isEmpty() || !montant.matches("\\d+(\\.\\d{1,2})?")) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un montant valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (compteDestinataire.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un compte destinataire valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Send command to the server
        client.envoyer("TRANSFERT " + montant + " " + compteDestinataire);

        // Clear inputs after sending
        txtMontant.setText("");
        txtCompteDestinataire.setText("");
        JOptionPane.showMessageDialog(this, "Transfert envoyé avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
    }
}