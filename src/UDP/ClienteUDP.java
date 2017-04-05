package UDP;

import java.io.*;
import java.net.*;

public class ClienteUDP {

	public static void main(String args[]) throws IOException {

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader Per = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");

		String pergunta = "";
		String sentence = "";
		System.out.println(" Enviar resposta: \nsim ou não?");
		pergunta = Per.readLine();

		System.out.println("Digite a pergunta:\n");
		

		while (pergunta != "sim" || pergunta != "Sim") {
			
			
		
			byte[] sendData = new byte[1024];
			byte[] receiveData = new byte[1024];

			sentence =  inFromUser.readLine();
			
			
			sendData = sentence.getBytes();

			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
			clientSocket.send(sendPacket);

			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.receive(receivePacket);

			String modifiedSentence = new String(receivePacket.getData());
			System.out.print("FROM SERVER: " + modifiedSentence);
	
	}

		// clientSocket.close();
	}

}
