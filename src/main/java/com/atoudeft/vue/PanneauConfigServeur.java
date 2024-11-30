package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauConfigServeur extends JPanel {
    private JTextField txtAdrServeur, txtNumPort;

    /**
     * Initialisation de l’adresse IP et le port d’écoute du serveur dans les 2 champs de texte
     * @param adr
     * @param port
     */
    public PanneauConfigServeur(String adr, int port) {
        this.txtAdrServeur = new JTextField(15);
        this.txtNumPort = new JTextField(5);

        this.txtAdrServeur.setText(adr);
        this.txtNumPort.setText("" + port);
    }
    public String getAdresseServeur() {
        return txtAdrServeur.getText();
    }
    public String getPortServeur() {
        return txtNumPort.getText();
    }
}
