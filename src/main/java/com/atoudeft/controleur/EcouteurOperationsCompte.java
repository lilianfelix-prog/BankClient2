package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import com.atoudeft.vue.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurOperationsCompte implements ActionListener {
    private Client client;
    private PanneauPrincipal panneauPrincipal;

    public EcouteurOperationsCompte(Client client, PanneauPrincipal panneauPrincipal) {
        this.client = client;
        this.panneauPrincipal = panneauPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //gestion de l'action du bouton epragne
        Object source = e.getSource();
        String nomAction;
        if (source instanceof JButton) {
            nomAction = ((JButton)source).getActionCommand();
            switch (nomAction) {
                case "EPARGNE":
                    client.envoyer("EPARGNE ");
                    break;
                case "DEPOT":
                    panneauPrincipal.afficherPanneauOperation("DEPOT");
                    break;

                case "RETRAIT":
                    panneauPrincipal.afficherPanneauOperation("RETRAIT");
                    break;

                case "TRANSFERT":
                    panneauPrincipal.afficherPanneauOperation("TRANSFERT");
                    break;

                case "FACTURE":
                    panneauPrincipal.afficherPanneauOperation("FACTURE");
                    break;

                case "HIST":
                    panneauPrincipal.afficherHistoriqueCompte("HIST");
            }

        }
    }

}
