
        package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauRetrait extends JPanel {
    private JTextField txtMontant;
    private JButton btnValider;

    public PanneauRetrait() {
        this.setLayout(new GridLayout(2, 2));
        this.add(new JLabel("Montant : "));
        txtMontant = new JTextField();
        this.add(txtMontant);
        btnValider = new JButton("Valider");
        btnValider.setActionCommand("VALIDER_RETRAIT");
        this.add(btnValider);
    }

    public String getMontant() {
        return txtMontant.getText();
    }

    public void setEcouteur(ActionListener ecouteur) {
        btnValider.addActionListener(ecouteur);
    }
}
