
        package com.atoudeft.vue;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

        //Panneau qui permet de gérer La configuration RETRAIT
        public class PanneauRetrait extends JPanel {
            private JTextField txtMontant;
            private JButton btnValider;
            private Client client;

            public PanneauRetrait(Client client) {
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
                btnValider.addActionListener(e -> validerRetrait());
            }

            private void validerRetrait() {
                // Fetch the entered amount
                String montant = txtMontant.getText();

                // Validate input
                if (montant.isEmpty() || !montant.matches("\\d+(\\.\\d{1,2})?")) {
                    JOptionPane.showMessageDialog(this, "Veuillez entrer un montant valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Send command to the server
                client.envoyer("RETRAIT " + montant);

                // Clear the input field after sending
                txtMontant.setText("");
            }
        }