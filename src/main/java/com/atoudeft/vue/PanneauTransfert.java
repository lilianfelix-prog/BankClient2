package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauTransfert extends JPanel {
    private JTextField txtMontant;
    private JButton btnValider;


    private JTextField nomCompteDestinataire;

    public PanneauTransfert() {
        this.setLayout(new GridLayout(2, 2));
        this.add(new JLabel("Montant : "));
        this.add(new JLabel("Numéro du compte destinataire: "));
        txtMontant = new JTextField();
        nomCompteDestinataire = new JTextField();
        this.add(txtMontant);
        this.add(nomCompteDestinataire);
        btnValider = new JButton("Valider");
        btnValider.setActionCommand("VALIDER_TRANSFERT");


        this.add(btnValider);
    }

    public String getMontant() {
        return txtMontant.getText();
    }

    public void setEcouteur(ActionListener ecouteur) {
        btnValider.addActionListener(ecouteur);
    }
    public String getNomCompteDestinataire() {
        return nomCompteDestinataire.getText();
    }
}
