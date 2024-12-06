package com.atoudeft.controleur;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurListeComptes extends MouseAdapter {

    private Client client;
    public EcouteurListeComptes(Client client) {
        this.client = client;
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();

            Object source = evt.getSource();
            if (source instanceof JList) {
                JList<String> list = (JList<String>) source;
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    Object selectedValue = list.getSelectedValue();
                    String nomAction = selectedValue.toString();
                    int index1 = nomAction.indexOf('[')+1;
                    int index2 = nomAction.indexOf(']');
                    String type = nomAction.substring(index1, index2);
                    client.envoyer("SELECT " + type.toLowerCase());
                }
            }
        }
    }
}
