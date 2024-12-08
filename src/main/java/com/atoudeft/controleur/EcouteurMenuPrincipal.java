package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import com.atoudeft.vue.PanneauConfigServeur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2024-11-01
 */
// classe qui gère la connexion du serveur
public class EcouteurMenuPrincipal implements ActionListener {
    private Client client;
    private JFrame fenetre;


    //Initialise l'objet client qui gère la connexion et la communication
    // et la fenetre principale de la fenêtre
    public EcouteurMenuPrincipal(Client client, JFrame fenetre) {
        this.client = client;
        this.fenetre = fenetre;
    }

    // Gère les événements des actions Connecter, déconnecter,
    // configurer IP adresse, port du serveur et la fermeture de l'application
    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        String action;
        String alias;
        int res;

        if (source instanceof JMenuItem) {
            action = ((JMenuItem)source).getActionCommand();
            switch (action) {
                case "CONNECTER":
                    if (!client.isConnecte()) {
                        if (!client.connecter()) {
                            JOptionPane.showMessageDialog(fenetre, "Le serveur ne répond pas");
                            break;
                        }
                    }
                    break;
                case "DECONNECTER":
                    if (!client.isConnecte())
                        break;
                    res = JOptionPane.showConfirmDialog(fenetre, "Vous allez vous déconnecter",
                            "Confirmation Déconnecter",
                            JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                    if (res == JOptionPane.OK_OPTION){
                        client.deconnecter();
                    }
                    break;
                case "CONFIGURER":

                    JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
                    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                    //ajouter les textfields avec l'adresse ip et port deja initialise
                    JLabel labelIP = new JLabel("Adresse IP:");
                    JTextField fieldIP = new JTextField(client.getAdrServeur(), 15);

                    JLabel labelPort = new JLabel("Port:");
                    JTextField fieldPort = new JTextField("" + client.getPortServeur(), 5);

                    panel.add(labelIP);
                    panel.add(fieldIP);
                    panel.add(labelPort);
                    panel.add(fieldPort);

                    boolean validInput = false;
                    //tant que la valeur du port n'est pas entier afficher confirmation
                    while(!validInput) {
                        int result = JOptionPane.showConfirmDialog(
                                null,
                                panel,
                                "Configuration serveur",
                                JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.PLAIN_MESSAGE
                        );

                        if (result == JOptionPane.OK_OPTION) {
                            try {
                            String ipAddress = fieldIP.getText();
                            //numberformatexception est lance si le text n'est pas un int
                            int port = Integer.parseInt(fieldPort.getText());

                            //fournir donnees au client
                            client.setAdrServeur(ipAddress);
                            client.setPortServeur(port);
                            System.out.println("Configuration reussie: IP = " + ipAddress + ", Port = " + port);
                            validInput = true;

                            } catch (NumberFormatException ex) {
                                //message d'erreur pour port invalide
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Le port doit être un entier valide entre 1 et 65535.",
                                        "Erreur de saisie",
                                        JOptionPane.ERROR_MESSAGE
                                );
                            }

                        } else {
                            //si bouton cancel est active
                            System.out.println("Configuration canceled.");
                            break;
                        }
                    }
                    break;
                case "QUITTER":
                    if (client.isConnecte()) {
                        res = JOptionPane.showConfirmDialog(fenetre, "Vous allez vous déconnecter",
                                "Confirmation Quitter",
                                JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                        if (res == JOptionPane.OK_OPTION){
                            client.deconnecter();
                            System.exit(0);
                        }
                    }
                    else
                        System.exit(0);
                    break;
            }
        }
    }
}