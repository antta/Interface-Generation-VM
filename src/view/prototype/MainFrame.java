package view.prototype;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

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
	public String[] mesPaquets = {"kiwi","Jenkins"};
	private JList<String> listePaquets;
	//buttons sortie
	private JButton annuler;
	private JButton valider;
	//panel
	private JPanel panelGeneral;
	private JPanel panelInfos;
	private JPanel panelListe;
	private JPanel panelButtons;
	//listener

	public MainFrame (){

		this.setSize(400, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.initialise();
		this.setVisible(true);
	}

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

		//liste paquet
		listePaquets = new JList<>(mesPaquets);

		//buttons
		annuler = new JButton("Annuler");
		valider = new JButton("Valider");

		//init du panel info
		panelInfos = new JPanel();
		panelInfos.setLayout(new GridLayout(3,3));		
		//init du panel general
		panelGeneral = new JPanel();
		panelGeneral.setLayout(new BorderLayout());
		//init du panel button
		panelButtons = new JPanel();
		panelButtons.setLayout(new FlowLayout());

		//ajout des differents panels
		panelGeneral.add(titre,BorderLayout.NORTH);

		panelInfos.add(labAuteur);
		panelInfos.add(auteur);
		panelInfos.add(labNomvm);
		panelInfos.add(nomvm);
		panelInfos.add(labDescription);
		panelInfos.add(description);
		panelGeneral.add(panelInfos,BorderLayout.CENTER);

		panelGeneral.add(listePaquets,BorderLayout.CENTER);
		
		
		panelButtons.add(annuler);
		panelButtons.add(valider);
		panelGeneral.add(panelButtons,BorderLayout.SOUTH);

		this.setContentPane(panelGeneral);
		
		//titre.setBounds(10, 50, 200, 50);
		panelInfos.setBounds(0, 0, 300, 300);

	}

	public static void main (String[] args){

		MainFrame maFen = new MainFrame();
	}
}
