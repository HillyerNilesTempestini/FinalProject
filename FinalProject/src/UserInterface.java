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

public class UserInterface extends JFrame {
	
	class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "You decided to do Something!");
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
		JButton btnText = new JButton("Save to text");
		ButtonHandler handler = new ButtonHandler();
		btnText.addActionListener(handler);  // the frame itself listens
		panSouth.add(btnText);
		c.add(panSouth, BorderLayout.SOUTH);
		
		JButton btnJson = new JButton("Save to json");
		ButtonHandler handler2 = new ButtonHandler();
		btnJson.addActionListener(handler2);  // the frame itself listens
		panSouth.add(btnJson);
		c.add(panSouth, BorderLayout.SOUTH);
		
		JPanel panNorth = new JPanel();
		panNorth.setLayout(new FlowLayout());
		JLabel webLabel = new JLabel("Enter URL: ");
		panNorth.add(webLabel);
		c.add(panNorth, BorderLayout.NORTH);
		
	    JTextField urlTextField = new JTextField("URL Text Field", 45);
	    urlTextField.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));
	    urlTextField.setForeground(Color.BLACK);
	    urlTextField.setHorizontalAlignment(JTextField.LEFT);  // Text alignment
	    //urlTextField.setToolTipText("This is a JTextField");
	    panNorth.add(urlTextField);
	    c.add(panNorth, BorderLayout.NORTH);
	    
		JButton btnFetch = new JButton("Fetch");
		ButtonHandler fetchHandler = new ButtonHandler();
		btnFetch.addActionListener(fetchHandler);  // the frame itself listens
		panNorth.add(btnFetch);
		c.add(panNorth, BorderLayout.NORTH);
		
		JTextArea text = new JTextArea();
		Font f = new Font("Arial",Font.BOLD,12);
		text.setFont(f);
		text.setEditable(false);
		text.setBackground(Color.WHITE);
		text.setForeground(Color.BLACK);
		text.setText("The data will go here.");
		c.add(text,BorderLayout.CENTER);
		setupMenu();


	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("You pressed the button.");
		
	}


	public static void main(String[] args) {
		UserInterface frm = new UserInterface();
		frm.setVisible(true);
	}
}
