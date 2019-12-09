import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;

import java.io.*;
import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.net.*;

public class UserInterface extends JFrame {
	
	ArrayList<Film> movies = new ArrayList<Film>();
	
	class ButtonHandler implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "You decided to do Something!");
			}
	}

	
	public void setupMenu() {
	
	//Creates the blank menu bar
	JMenuBar mbar = new JMenuBar();
	
	//Creates the Menu Item File
	JMenu mnuFile = new JMenu("File");
	JMenu mnuHelp = new JMenu("Help");
	JMenuItem miExit = new JMenu("Exit");
	miExit.addActionListener(new ActionListener() {
	
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	mnuHelp.add(miExit);
	mbar.add(mnuFile);
	mbar.add(mnuHelp);
	setJMenuBar(mbar);
	}
	
	public UserInterface() {
		setTitle("Web Scraper");
		setBounds(250,150,500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		
		
		
		JPanel panNorth = new JPanel();
		panNorth.setLayout(new FlowLayout());
		JLabel webLabel = new JLabel("Enter URL: ");
		panNorth.add(webLabel);
		c.add(panNorth, BorderLayout.NORTH);
		
	    JTextField urlTextField = new JTextField("", 45);
	    urlTextField.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));
	    urlTextField.setForeground(Color.BLACK);
	    urlTextField.setHorizontalAlignment(JTextField.LEFT);  // Text alignment
	    //urlTextField.setToolTipText("This is a JTextField");
	    panNorth.add(urlTextField);
	    c.add(panNorth, BorderLayout.NORTH);
	    
	    
	     JTextArea text = new JTextArea();
	    //Font f = new Font("Arial",Font.BOLD,12);
		//text.setFont(f);
	    text.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		text.setEditable(false);
		text.setBackground(Color.WHITE);
		text.setForeground(Color.BLACK);
		text.setText("The data will go here.");
	    c.add(text,BorderLayout.CENTER);
		JButton btnFetch = new JButton("Fetch");
		//btnFetch.addActionListener(fetchHandler);  // the frame itself listens
		panNorth.add(btnFetch);
		c.add(panNorth, BorderLayout.NORTH);
		btnFetch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Fetching...");
				
				String storeURL = "";
				String mstr = "";

				if(e.getSource() == btnFetch)
				{
					storeURL = urlTextField.getText();
					movies = FilmParser.parseFilms(storeURL);
					mstr = FilmParser.returnFilms(movies);
					text.setText(mstr);
					//text.append();
					
				}
			}
		});
		JButton btnText = new JButton("Save to text");
		ButtonHandler handler = new ButtonHandler();
		btnText.addActionListener(handler);  // the frame itself listens
		panSouth.add(btnText);
		c.add(panSouth, BorderLayout.SOUTH);
		btnText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Saved");
				
				if(e.getSource() == btnText)
				{
	
					 class Second extends JFrame implements ActionListener{
						private JLabel enterName;
						private JTextField name;
						private JButton click;
						private String storeName = "";
	
						public Second()
						{
							setLayout(null);
							setSize(300,300);
							
							setDefaultCloseOperation(EXIT_ON_CLOSE);
							enterName = new JLabel("Enter the file name: ");
							click = new JButton("OK");
							name = new JTextField();
							enterName.setBounds(60, 30, 120, 30);
							name.setBounds(80, 60, 130, 30);
							click.setBounds(100, 200, 60, 30);
							click.addActionListener(this);
							add(click);
							add(name);
							add(enterName);
							
						}
							
						public void actionPerformed(ActionEvent e){
							if(e.getSource() == click){
								storeName = name.getText();
								String extension = storeName.substring(storeName.lastIndexOf(".")).toLowerCase();
								if (extension.equals(".txt"))
								{
									SaveToFile.writeTextFile(movies, storeName);
									System.out.println("Text File Written.");
								}
								else
									System.out.println("Invalid File Extention!");
								JOptionPane.showMessageDialog(null, "File name is: " + storeName);
								System.exit(0);
							}
						}
					}
					Second sec = new Second();
					sec.setVisible(true);
					
					
					/*
					Scanner sc = new Scanner(System.in);
					System.out.print("\nEnter the name ofthe file: ");
					String fname = sc.nextLine();
					String extension = fname.substring(fname.lastIndexOf(".")).toLowerCase();
					if (extension.equals(".txt"))
					{
						SaveToFile.writeTextFile(movies, fname);
						System.out.println("Text File Written.");
					}
					else
						System.out.println("Invalid File Extention!");
						*/
					
				}
			}
		});
		
		JButton btnJson = new JButton("Save to json");
		ButtonHandler handler2 = new ButtonHandler();
		btnJson.addActionListener(handler2);  // the frame itself listens
		panSouth.add(btnJson);
		c.add(panSouth, BorderLayout.SOUTH);
		btnJson.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Saved");
				
				if (e.getSource() == btnJson)
				{
					Scanner sc = new Scanner(System.in);
					System.out.print("\nEnter the name ofthe file: ");
					String fname = sc.nextLine();
					String extension = fname.substring(fname.lastIndexOf(".")).toLowerCase();
					if (extension.equals(".json"))
					{
						SaveToFile.writeToJSONFile(movies, fname);	
						System.out.println("JSON File Written.");
					}
					else
						System.out.println("Invalid File Extention!");
				}
				
			}
		});

		setupMenu();


	}
	
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("You pressed the button.");
		
		
	}



	public static void main(String[] args) {
		UserInterface frm = new UserInterface();
		frm.setVisible(true);
		
		//ArrayList<Film> movies = FilmParser.parseFilms();
		//FilmParser.printFilms(movies);
		
		
		
	
	}
}
