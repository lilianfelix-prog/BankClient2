package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Panneau qui gère les boutons

public class PanneauOperationsCompte extends JPanel {

    // Création des boutons pour le panneau
    private JButton bEpargne, bDepot, bRetrait, bTransfert, bFacture, bHistorique, bOperation;



    private JLabel lblSolde;

    // Initialise les boutons les labels pour les opérations bancaires
    public PanneauOperationsCompte() {
        bEpargne = new JButton("Créer compte épargne");
        bDepot = new JButton("Déposer");
        bRetrait = new JButton("Retirer");
        bTransfert = new JButton("Transferer");
        bFacture = new JButton("Payer Facture");
        bHistorique = new JButton("Historique du compte");
        lblSolde = new JLabel("Solde : ");





        // Assigne les commandes d'action spécifique pour chaque bouton
        bEpargne.setActionCommand("EPARGNE");
        bDepot.setActionCommand("DEPOT");
        bRetrait.setActionCommand("RETRAIT");
        bTransfert.setActionCommand("TRANSFER");
        bFacture.setActionCommand("FACTURE");
        bHistorique.setActionCommand("HIST");



        // Configure le layout et ajoute les composants pour à l'interface graphique
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.add(lblSolde);
        this.add(bEpargne);
        this.add(bDepot);
        this.add(bRetrait);
        this.add(bTransfert);
        this.add(bFacture);
        this.add(bHistorique);


    }

    // Ajoute un écouteur d'événement pour chaque bouton
    public void setEcouteur(ActionListener ecouteur) {
        bEpargne.addActionListener(ecouteur);
        bDepot.addActionListener(ecouteur);
        bRetrait.addActionListener(ecouteur);
        bTransfert.addActionListener(ecouteur);
        bFacture.addActionListener(ecouteur);
        bHistorique.addActionListener(ecouteur);


    }
    // aller chercher le JLabel du solde pour l'afficher
    public JLabel getLblSolde() {
        return lblSolde;
    }

}
