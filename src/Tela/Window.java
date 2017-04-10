package Tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Files.ClientUDP;
import Files.ServerUDP;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JList;

public class Window extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	// private Color color;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(57, 103, 121, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(242, 30, 182, 220);
		textArea.setBackground(Color.RED);
		contentPane.add(textArea);
        ////////////////        ////////////////        ////////////////
		// Button Server
		JButton buttonServer = new JButton("Server Connection OFF");
		buttonServer.setBackground(Color.RED);
		buttonServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServerUDP serverup = new ServerUDP();
				try {
					serverup.Start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				buttonServer.setText("Server Connection ON");
				buttonServer.setBackground(Color.GREEN);
				textArea.setBackground(Color.BLACK);
				textArea.setForeground(Color.WHITE);
			}
		});
		buttonServer.setBounds(22, 11, 172, 22);
		contentPane.add(buttonServer);
		////////////////        ////////////////        ////////////////
		// Button Client
		JButton buttonClient = new JButton("Client Connection OFF");
		buttonClient.setBackground(Color.RED);
		buttonClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientUDP client = new ClientUDP();
				try {
					client.Start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				buttonClient.setBackground(Color.GREEN);
			}
		});
		buttonClient.setBounds(22, 31, 172, 22);
		contentPane.add(buttonClient);
        ////////////////        ////////////////        ////////////////
		// Button Send
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "";
				str = "Client: " + textField.getText() + "\n";
				//textArea.setText(str);
				textArea.append(str);
				textField.setText("");
				
			}
		});
		btnNewButton.setBounds(67, 134, 105, 61);
		contentPane.add(btnNewButton);
        ////////////////        ////////////////        ////////////////		
		JLabel jlabelClient = new JLabel("Client");
		jlabelClient.setBounds(97, 78, 46, 14);
		contentPane.add(jlabelClient);
		
		JLabel jlabelServer = new JLabel("Server");
		jlabelServer.setBounds(313, 11, 46, 14);
		contentPane.add(jlabelServer);	
		
	}
	
}
