package Tela;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.TextArea;

@SuppressWarnings("serial")
public class Window extends JFrame {

	private static JPanel contentPane;
	private static TextArea textAreaMensage;
	private static TextArea textAreaEstatistica;
	private static JTextField textFieldMensage;
	private static JTextField textFieldip;
	private static JTextField textFieldport;
	private static Choice choiceQuestion;
	private static Choice choiceAlter;
	private static JLabel labelSetServer;
	private static JLabel labelSetPort;
	private static JLabel labelQuestion;
	private static JLabel labelAlternativa;
	private static JLabel labelResposta;
	private static JLabel labelEstimativas;
	private static JLabel lblEstatsticas;
	private static Button buttonSend;
	private static String auxx;
	private static String fromserver;
	private static String menssagem;
	private static String straux;
	private static String fromservertotalestatisticas = "";
	private static DatagramSocket clientSocket;
	private static DatagramPacket sendPacket;
	private static DatagramPacket receivePacket;
	private static InetAddress IPAddress;
	private static int[][] matrix = new int [5][2];
	private static byte[] sendData;
	private static byte[] receiveData;
	private static String sentence;
	private static String modifiedSentence;

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

	public Window() {
		setType(Type.UTILITY);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 349);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textAreaMensage = new TextArea();
		textAreaMensage.setEditable(false);
		textAreaMensage.setBackground(new Color(0, 0, 0));
		textAreaMensage.setBounds(10, 162, 311, 128);
		contentPane.add(textAreaMensage);

		textAreaEstatistica = new TextArea();
		textAreaEstatistica.setEditable(false);
		textAreaEstatistica.setForeground(Color.ORANGE);
		textAreaEstatistica.setBackground(Color.BLACK);
		textAreaEstatistica.setBounds(327, 162, 325, 128);
		contentPane.add(textAreaEstatistica);

		choiceQuestion = new Choice();
		choiceQuestion.setBounds(400, 11, 104, 20);
		choiceQuestion.add("1");
		choiceQuestion.add("2");
		choiceQuestion.add("3");
		choiceQuestion.add("4");
		choiceQuestion.add("5");
		getContentPane().add(choiceQuestion);

		choiceAlter = new Choice();
		choiceAlter.setBounds(400, 42, 104, 20);
		choiceAlter.add("1");
		choiceAlter.add("2");
		choiceAlter.add("3");
		choiceAlter.add("4");
		choiceAlter.add("5");
		contentPane.add(choiceAlter);

		labelSetServer = new JLabel("Set IP");
		labelSetServer.setForeground(Color.BLACK);
		labelSetServer.setFont(new Font("Arial Black", Font.BOLD, 14));
		labelSetServer.setBounds(10, 11, 98, 20);
		contentPane.add(labelSetServer);

		labelSetPort = new JLabel("Set Port");
		labelSetPort.setForeground(Color.BLACK);
		labelSetPort.setBackground(Color.BLACK);
		labelSetPort.setFont(new Font("Arial Black", Font.BOLD, 14));
		labelSetPort.setBounds(10, 42, 87, 20);
		contentPane.add(labelSetPort);

		labelQuestion = new JLabel("Quest\u00E3o");
		labelQuestion.setFont(new Font("Arial Black", Font.BOLD, 14));
		labelQuestion.setForeground(Color.BLACK);
		labelQuestion.setBackground(Color.BLACK);
		labelQuestion.setBounds(278, 11, 81, 20);
		contentPane.add(labelQuestion);

		labelAlternativa = new JLabel("Alternativa");
		labelAlternativa.setFont(new Font("Arial Black", Font.BOLD, 14));
		labelAlternativa.setForeground(Color.BLACK);
		labelAlternativa.setBackground(Color.BLACK);
		labelAlternativa.setBounds(278, 42, 98, 20);
		contentPane.add(labelAlternativa);

		labelResposta = new JLabel("Resposta");
		labelResposta.setFont(new Font("Arial Black", Font.BOLD, 14));
		labelResposta.setForeground(Color.BLACK);
		labelResposta.setBackground(Color.BLACK);
		labelResposta.setBounds(546, 11, 81, 15);
		contentPane.add(labelResposta);

		textFieldip = new JTextField();
		textFieldip.setBounds(125, 13, 104, 20);
		contentPane.add(textFieldip);
		textFieldip.setColumns(10);
		textFieldip.setText("localhost");

		textFieldport = new JTextField();
		textFieldport.setBounds(125, 42, 104, 20);
		contentPane.add(textFieldport);
		textFieldport.setColumns(10);
		textFieldport.setText("9876");

		textFieldMensage = new JTextField();
		textFieldMensage.setBounds(535, 42, 103, 20);
		contentPane.add(textFieldMensage);
		textFieldMensage.setColumns(10);

		labelEstimativas = new JLabel("Estimativas");
		labelEstimativas.setFont(new Font("Arial Black", Font.BOLD, 14));
		labelEstimativas.setBounds(85, 137, 114, 14);
		contentPane.add(labelEstimativas);

		lblEstatsticas = new JLabel("Estat\u00EDsticas");
		lblEstatsticas.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblEstatsticas.setBounds(424, 137, 114, 14);
		contentPane.add(lblEstatsticas);
		
		buttonSend = new Button("Send Mensage");
		buttonSend.setForeground(new Color(0, 255, 0));
		buttonSend.setBackground(new Color(105, 105, 105));
		buttonSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (choiceQuestion.getSelectedItem().equals("1") && choiceAlter.getSelectedItem().equals("5")
							&& textFieldMensage.getText().length() == 5) {
						menssagem = choiceQuestion.getSelectedItem() + ';' + choiceAlter.getSelectedItem().toString()
								+ ';' + textFieldMensage.getText().toUpperCase();
						StartClient();
						textAreaMensage.append(fromserver);
					} else if (choiceQuestion.getSelectedItem().equals("2") && choiceAlter.getSelectedItem().equals("4")
							&& textFieldMensage.getText().length() == 4) {
						menssagem = choiceQuestion.getSelectedItem() + ';' + choiceAlter.getSelectedItem().toString()
								+ ';' + textFieldMensage.getText().toUpperCase();
						StartClient();
						textAreaMensage.append(fromserver);
					}
					else if (choiceQuestion.getSelectedItem().equals("3") && choiceAlter.getSelectedItem().equals("3")
							&& textFieldMensage.getText().length() == 3) {
						menssagem = choiceQuestion.getSelectedItem() + ';' + choiceAlter.getSelectedItem().toString()
								+ ';' + textFieldMensage.getText().toUpperCase();
						StartClient();
						textAreaMensage.append(fromserver);
					}
					else if (choiceQuestion.getSelectedItem().equals("4") && choiceAlter.getSelectedItem().equals("2")
							&& textFieldMensage.getText().length() == 2) {
						menssagem = choiceQuestion.getSelectedItem() + ';' + choiceAlter.getSelectedItem().toString()
								+ ';' + textFieldMensage.getText().toUpperCase();
						StartClient();
						textAreaMensage.append(fromserver);
					} else if (choiceQuestion.getSelectedItem().equals("5") && choiceAlter.getSelectedItem().equals("1")
							&& textFieldMensage.getText().length() == 1) {
						menssagem = choiceQuestion.getSelectedItem() + ';' + choiceAlter.getSelectedItem().toString()
								+ ';' + textFieldMensage.getText().toUpperCase();
						StartClient();
						textAreaMensage.append(fromserver);
					} else {
						JOptionPane.showMessageDialog(null, "Erro encontrado nas informações declaradas!!!");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textAreaMensage.setForeground(Color.RED);
				textAreaEstatistica.setText(fromservertotalestatisticas);
			}
		});

		buttonSend.setBounds(261, 80, 114, 51);
		contentPane.add(buttonSend);
	}
	
	public void StartClientTCP() throws IOException{
		BufferedReader InFromUser = new BufferedReader(new InputStreamReader(System.in;
		Socket clientSocket = new Socket ("localhost", 6789);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		sentence = inFromUser.readLine();
		outToServer.writeBytes(sentence + '\n');
		modifiedSentence = inFromServer.readLine();
		System.out.println("FROM SERVER: " + modifiedSentence);;
		clientSocket.close();
		
	}

	public void StartClientUDP() throws IOException {
		clientSocket = new DatagramSocket();
		IPAddress = InetAddress.getByName(textFieldip.getText());
		sendData = new byte[1024];
		receiveData = new byte[1024];
		sentence = "";
		modifiedSentence = "";
		sentence = menssagem;
		sendData = sentence.getBytes();
		sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress,
				Integer.parseInt(textFieldport.getText()));
		clientSocket.send(sendPacket);
		receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		modifiedSentence = new String(receivePacket.getData());
		fromserver = modifiedSentence + "\n";

		if (modifiedSentence.charAt(9) == '1') {
			matrix[0][0] += Character.getNumericValue((modifiedSentence.charAt(22)));
			matrix[0][1] += Character.getNumericValue(modifiedSentence.charAt(33));
		} else if (modifiedSentence.charAt(9) == '2') {

			matrix[1][0] += Character.getNumericValue((modifiedSentence.charAt(22)));
			matrix[1][1] += Character.getNumericValue(modifiedSentence.charAt(33));
		} else if (modifiedSentence.charAt(9) == '3') {
			matrix[2][0] += Character.getNumericValue((modifiedSentence.charAt(22)));
			matrix[2][1] += Character.getNumericValue(modifiedSentence.charAt(33));
		} else if (modifiedSentence.charAt(9) == '4') {
			matrix[3][0] += Character.getNumericValue((modifiedSentence.charAt(22)));
			matrix[3][1] += Character.getNumericValue(modifiedSentence.charAt(33));
		}
		if (modifiedSentence.charAt(9) == '5') {
			matrix[4][0] += Character.getNumericValue((modifiedSentence.charAt(22)));
			matrix[4][1] += Character.getNumericValue(modifiedSentence.charAt(33));
		}
		auxx = matrixstr();
		fromservertotalestatisticas = auxx + "\n";
	}

	public static String matrixstr() {
		straux = "";
		straux = "Questão 1: total de acertos = " + matrix[0][0] + " , " + "total de erros = " + matrix[0][1] + "\n"
				+ "Questão 2: total de acertos = " + matrix[1][0] + " , " + "total de erros = " + matrix[1][1] + "\n"
				+ "Questão 2: total de acertos = " + matrix[2][0] + " , " + "total de erros = " + matrix[2][1] + "\n"
				+ "Questão 4: total de acertos = " + matrix[3][0] + " , " + "total de erros = " + matrix[3][1] + "\n"
				+ "Questão 5: total de acertos = " + matrix[4][0] + " , " + "total de erros = " + matrix[4][1] + "\n";
		return straux;
	}
}