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
                JList<?> list = (JList<?>) source;
                int selectedIndex = list.getSelectedIndex(); // Get the selected index
                if (selectedIndex != -1) { // Check if an item is selected
                    Object selectedValue = list.getSelectedValue(); // Get the selected value
                    String nomAction = selectedValue.toString(); // Convert it to a string
                    client.lire();


                }
            }
        }
    }
}
