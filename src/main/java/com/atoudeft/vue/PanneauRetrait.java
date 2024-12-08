
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

                // Ajoute un label et un champ de texte pour saisir le montant
                this.add(new JLabel("Montant : "));
                txtMontant = new JTextField();
                this.add(txtMontant);

                // cree un bouton "Valider"
                btnValider = new JButton("Valider");
                btnValider.setActionCommand("VALIDER_DEPOT");
                this.add(new JLabel()); // espace
                this.add(btnValider);

                // ajouter un event listener au boutton valider
                // methode validerDepot est executer quand un event e est detecte (fonction lambda)
                btnValider.addActionListener(e -> validerRetrait());
            }

            private void validerRetrait() {

                // Récupère le montant saisie
                String montant = txtMontant.getText();

                // Vérifie si le montant est bien saisie et c'est un chiffre
                if (montant.isEmpty() || !montant.matches("\\d+(\\.\\d{1,2})?")) {
                    JOptionPane.showMessageDialog(this, "Veuillez entrer un montant valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Envoie la commande de retrait au serveur
                client.envoyer("RETRAIT " + montant);

                // Efface le champ de texte après l'envoi
                txtMontant.setText("");
            }
        }