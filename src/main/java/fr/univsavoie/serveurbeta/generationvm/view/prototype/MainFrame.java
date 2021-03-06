package fr.univsavoie.serveurbeta.generationvm.view.prototype;

import fr.univsavoie.serveurbeta.generationvm.engine.XMLParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame implements ActionListener{

	private XMLParser xmlParser;
	//Header
	private JLabel titre;
	//info VM
	private JLabel labAuteur;
	private JTextField auteur;
	private JLabel labNomvm;
	private JTextField nomvm;
	private JLabel labDescription;
	private JTextField description;
	//liste paquets
	private List<String> mesPaquets;
	private DefaultListModel<String> monModel;
	private JList<String> listePaquets;
	//buttons sortie
	private JButton annuler;
	private JButton valider;
	//panel
	private JPanel panelGeneral;
	private JPanel panelInfos;
	private JPanel panelListe;
	private JPanel panelButtons;
	private JPanel panelTitre;
	//listener

	//magic number
	private int width = 400;
	private int height = 300;
	private int gridWidth = 3;
	private int gridHeight = 3;

	public MainFrame (){

		this.setTitle("Config.xml");
		this.setSize(width, height);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.initialise();
		this.setVisible(true);
	}

	/**
	 * Initialise la fenetre principale
	 * 
	 * @author nicolas
	 */
	private void initialise(){

		//header
		titre = new JLabel("Projet Axway");
		//infos VM
		labAuteur = new JLabel("Auteur :");
		labNomvm = new JLabel("Nom de la VM :");
		labDescription = new JLabel("Description :");

		auteur = new JTextField();
		nomvm = new JTextField();
		description = new JTextField();

		//initialise la liste paquet depuis l'arraylist
		mesPaquets = new ArrayList<String>();
		mesPaquets.add("tar");
		mesPaquets.add("geany");
		mesPaquets.add("gedit");
		mesPaquets.add("wget");
		mesPaquets.add("openssh");
		mesPaquets.add("lynx");

		monModel = new DefaultListModel<String>();
		listePaquets = new JList<String>(monModel);
		for (String unPaquet : mesPaquets){
			monModel.addElement(unPaquet);
		}
		listePaquets.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


		//buttons
		annuler = new JButton("Annuler");
		valider = new JButton("Valider");

		//init du panel titre
		panelTitre = new JPanel();
		panelTitre.setLayout(new FlowLayout());
		//init du panel info
		panelInfos = new JPanel();
		panelInfos.setLayout(new GridLayout(gridWidth,gridHeight));
		//init du panel Liste
		panelListe = new JPanel();
		panelListe.setLayout(new BorderLayout());
		//init du panel general
		panelGeneral = new JPanel();
		panelGeneral.setLayout(new BorderLayout());
		//init du panel button
		panelButtons = new JPanel();
		panelButtons.setLayout(new FlowLayout());

		//ajout des differents panels
		panelTitre.add(titre);
		panelGeneral.add(panelTitre,BorderLayout.NORTH);

		panelInfos.add(labAuteur);
		panelInfos.add(auteur);
		panelInfos.add(labNomvm);
		panelInfos.add(nomvm);
		panelInfos.add(labDescription);
		panelInfos.add(description);
		panelListe.add(panelInfos,BorderLayout.NORTH);

		panelListe.add(listePaquets,BorderLayout.SOUTH);
		panelGeneral.add(panelListe,BorderLayout.CENTER);

		panelButtons.add(annuler);
		panelButtons.add(valider);
		panelGeneral.add(panelButtons,BorderLayout.SOUTH);

		panelListe.add(new JScrollPane(listePaquets));

		this.setContentPane(panelGeneral);

		//ajout des listeners
		annuler.addActionListener(this);
		valider.addActionListener(this);

		this.xmlParser = XMLParser.createEmptyConfig();
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == annuler){
			this.dispose();
		}
		if(e.getSource() == valider){

			String infos = "Auteur : "+auteur.getText()+"\nNom VM : "+nomvm.getText()+"\nDescription : "+description.getText()+"\n";
			List<String> paquetsSelectionnes = listePaquets.getSelectedValuesList();
			for (String unPaquet : paquetsSelectionnes){
				infos += unPaquet+", ";
				this.xmlParser.getXmlModel().addPackage(unPaquet);
			}
			JOptionPane.showMessageDialog(null, infos);
		}
	}

	public static void main (String[] args){

		new MainFrame();
	}

}
