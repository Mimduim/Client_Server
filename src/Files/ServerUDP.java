package Files;

import java.io.*;
import java.net.*;

public class ServerUDP {
	private static DatagramSocket serverSocket;
	private static DatagramPacket receivePacket;
	private static DatagramPacket sendPacket;
	private static InetAddress IPAddress;
	private static ProccesInfo proccesinfo;
	private static String capitalizedSentence;
	private static String sentence;
	private static byte[] receiveData;
	private static byte[] sendData;
	private static int port;

	public static void main(String[] args) throws IOException {
		serverSocket = new DatagramSocket(9873);
		while (true) {
			receiveData = new byte[1024];
			sendData = new byte[1024];
			capitalizedSentence = "";
			receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			sentence = new String(receivePacket.getData());
			port = receivePacket.getPort();
			IPAddress = receivePacket.getAddress();
			proccesinfo = new ProccesInfo();
			proccesinfo.Inicialize(sentence);
			capitalizedSentence = proccesinfo.response();
			sendData = capitalizedSentence.getBytes();
			sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			serverSocket.send(sendPacket);
		}
		// serverSocket.close();
	}

}
