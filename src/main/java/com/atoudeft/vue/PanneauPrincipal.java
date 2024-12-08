package com.atoudeft.vue;

import com.atoudeft.client.Client;
import com.atoudeft.controleur.EcouteurConnexion;
import com.atoudeft.controleur.EcouteurListeComptes;
import com.atoudeft.controleur.EcouteurOperationsCompte;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2024-11-01
 */
public class PanneauPrincipal  extends JPanel {
    private Client client;

    private PanneauConnexion panneauConnexion;
    private JPanel panneauCompteClient;
    private PanneauOperationsCompte panneauOperationsCompte;

    private DefaultListModel<String> numerosComptes;
    private JList<String> jlNumerosComptes;
    private JDesktopPane bureau;
    private JPanel panneauDetails; // Panel for operation-specific forms
    private CardLayout cardLayout;

    private PanneauDepot panneauDepot;
    private PanneauRetrait panneauRetrait;
    private PanneauTransfer panneauTransfer;
    private PanneauFacture panneauFacture;


    // Initialise les composants
    public PanneauPrincipal(Client client) {
        this.client = client;

        // Initialise les panneaux
        panneauConnexion = new PanneauConnexion();
        panneauConnexion.setEcouteur(new EcouteurConnexion(client,panneauConnexion));

        panneauOperationsCompte = new PanneauOperationsCompte();
        panneauOperationsCompte.setEcouteur(new EcouteurOperationsCompte(client, this));
        //panneauOperationsCompte.setSolde();

        // Initialise les panneaux d'opérations spécifiques Depot, retrait, transfert et facture
        panneauDepot = new PanneauDepot(client);
        panneauRetrait = new PanneauRetrait(client);
        panneauTransfer = new PanneauTransfer(client);
        panneauFacture = new PanneauFacture(client);

        // Panneau principal du compte client
        panneauCompteClient = new JPanel();

        panneauCompteClient.setLayout(new BorderLayout());
        panneauCompteClient.setBackground(Color.WHITE);
        panneauOperationsCompte.setBackground(Color.WHITE);

        numerosComptes = new DefaultListModel<>();

        // Initialise le modèle de lsite pour les numéros de comptes
        jlNumerosComptes = new JList<>(numerosComptes);
        jlNumerosComptes.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        jlNumerosComptes.setBorder(BorderFactory.createTitledBorder("Comptes bancaires"));
        jlNumerosComptes.setPreferredSize(new Dimension(250,500));

        // Affiche les formulaires d'opération spécifiques selon
        panneauDetails = new JPanel();
        cardLayout = new CardLayout();
        panneauDetails.setLayout(cardLayout);
        panneauDetails.add(new JLabel("Sélectionnez une opération"), "DEFAULT");
        panneauDetails.add(panneauDepot, "DEPOT");
        panneauDetails.add(panneauRetrait, "RETRAIT");
        panneauDetails.add(panneauTransfer, "TRANSFER");
        panneauDetails.add(panneauFacture, "FACTURE");


        // Dont know what is this
        panneauCompteClient.add(panneauOperationsCompte, BorderLayout.NORTH);
        panneauCompteClient.add(jlNumerosComptes, BorderLayout.WEST);
        panneauCompteClient.add(panneauDetails, BorderLayout.CENTER);

        //Enregistrement de l'écouteur de souris:
        jlNumerosComptes.addMouseListener(new EcouteurListeComptes(client));

        this.setLayout(new BorderLayout());

        this.add(panneauConnexion, BorderLayout.NORTH);
        this.add(panneauCompteClient, BorderLayout.CENTER);

        panneauCompteClient.setVisible(false);
    }

    /**
     * Vide les éléments d'interface du panneauPrincipal.
     */
    public void vider() {
        this.numerosComptes.clear();
        this.bureau.removeAll();
    }
    // affiche différentes opérations en utilisant un CardLayout
    public void afficherPanneauOperation(String nomPanneau) {
        cardLayout.show(panneauDetails, nomPanneau);
    }
    // Cache le panneau de connexion et facce le contenu
    public void cacherPanneauConnexion() {
        panneauConnexion.effacer();
        panneauConnexion.setVisible(false);
    }
    // Affiche le panneau de connexion
    public void montrerPanneauConnexion() {
        panneauConnexion.setVisible(true);
    }
    // Cache le panneau du compte-client et vide la liste de comptes
    public void cacherPanneauCompteClient() {
        panneauCompteClient.setVisible(false);
        this.numerosComptes.clear();
    }
    // Affiche le panneau du compte client
    public void montrerPanneauCompteClient() {
        panneauCompteClient.setVisible(true);
    }
    /**
     * Affiche un numéro de compte dans le JList des comptes.
     *
     * @param str chaine contenant le numéros de compte
     */
    public void ajouterCompte(String str) {
        numerosComptes.addElement(str);
    }

    // cree une fenetre et affiche l'histoique des transactions dans un boîte de message
    public void afficherHistoriqueCompte(String historique) {

        JTextArea textArea = new JTextArea(historique);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);


        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));


        JOptionPane.showMessageDialog(
                this,
                scrollPane,
                "Historique du compte",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // Mets à jour et affiche le solde du compte sur le panneau d'opération
    public void setSolde(String solde){
        panneauOperationsCompte.getLblSolde().setText("Solde: " + solde);
    }



}



