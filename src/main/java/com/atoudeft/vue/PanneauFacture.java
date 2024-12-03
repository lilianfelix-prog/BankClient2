
package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauFacture extends JPanel {
    private JTextField txtMontant;
    private JButton btnValider;



    private JTextField description;



    private JTextField numeroDeFacture;

    public PanneauFacture() {
        this.setLayout(new GridLayout(2, 2));
        this.add(new JLabel("Montant : "));
        this.add(new JLabel("Description : "));
        this.add(new JLabel("numero de facture : "));
        txtMontant = new JTextField();
        description = new JTextField();
        numeroDeFacture = new JTextField();
        this.add(txtMontant);
        this.add(description);
        this.add(numeroDeFacture);
        btnValider = new JButton("Valider");
        btnValider.setActionCommand("VALIDER_FACTURE");

        this.add(btnValider);
    }

    public String getMontant() {
        return txtMontant.getText();
    }

    public void setEcouteur(ActionListener ecouteur) {
        btnValider.addActionListener(ecouteur);
    }
    public String getDescription() {
        return description.getText();
    }
    public String getNumeroDeFacture() {
        return numeroDeFacture.getText();
    }
}