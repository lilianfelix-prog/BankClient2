package com.atoudeft.vue;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauTransfer extends JPanel {
    private JTextField txtMontant, txtCompteDestinataire;
    private JButton btnValider;
    private Client client;

    public PanneauTransfer(Client client) {
        this.client = client;

        this.setLayout(new GridLayout(3, 2));

        // Input for amount
        this.add(new JLabel("Montant : "));
        txtMontant = new JTextField();
        this.add(txtMontant);


        this.add(new JLabel("Compte destinataire : "));
        txtCompteDestinataire = new JTextField();
        this.add(txtCompteDestinataire);


        btnValider = new JButton("Valider");
        btnValider.setActionCommand("VALIDER_TRANSFERT");
        this.add(new JLabel());
        this.add(btnValider);


        btnValider.addActionListener(e -> validerTransfert());
    }

    private void validerTransfert() {

        String montant = txtMontant.getText();
        String compteDestinataire = txtCompteDestinataire.getText();


        if (montant.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un montant valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (compteDestinataire.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un compte destinataire valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }


        client.envoyer("TRANSFERT " + montant + " " + compteDestinataire);


        txtMontant.setText("");
        txtCompteDestinataire.setText("");
        JOptionPane.showMessageDialog(this, "Transfert envoyé avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
    }
}