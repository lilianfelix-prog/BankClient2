package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import com.atoudeft.vue.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurOperationsCompte implements ActionListener {
    private Client client;
    private PanneauDepot panneauDepot;
    private PanneauRetrait panneauRetrait;
    private PanneauFacture panneauFacture;
    private PanneauTransfert panneauTransfert;




    public EcouteurOperationsCompte(Client client) {
        this.client = client;
        this.panneauDepot = panneauDepot;
        this.panneauRetrait = panneauRetrait;
        this.panneauFacture = panneauFacture;
        this.panneauTransfert = panneauTransfert;

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
                    client.envoyer("DEPOT "+ panneauDepot.getMontant());

                case "RETRAIT":
                    client.envoyer("RETRAIT "+ panneauRetrait.getMontant() );
                    break;

                case "TRANSFERT":
                    client.envoyer("TRANSFERT "+ panneauTransfert.getMontant()+" "+ panneauTransfert.getNomCompteDestinataire());
                    break;

                case "FACTURE":
                    client.envoyer("FACTURE "+ panneauFacture.getMontant()+" "+  panneauFacture.getNumeroDeFacture()+ " "+ panneauFacture.getDescription());
                    break;

            }


        }
    }

}
