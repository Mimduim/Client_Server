package UDP;


import java.io.*;
import java.net.*;
import java.util.*;

public class ServidorUDP {
	
	
	
	public static void main(String args[]) throws IOException {

		DatagramSocket serverSocket = new DatagramSocket(9876);
		

		while (true) {

			
			
			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];

			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

			serverSocket.receive(receivePacket);

			String sentence = new String(receivePacket.getData());

			int port = receivePacket.getPort();

			InetAddress IPAddress = receivePacket.getAddress();
				
			
			String capitalizedSentence =  sentence.toUpperCase();


			sendData = capitalizedSentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

			serverSocket.send(sendPacket);

		}
		//serverSocket.close();
	}
}
