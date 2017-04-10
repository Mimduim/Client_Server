package Files;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ServerUDP {

	static List<String> str = new ArrayList<String>();

	public void Start() throws IOException {

		DatagramSocket serverSocket = new DatagramSocket(9876);

		while (true) {

			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];

			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

			serverSocket.receive(receivePacket);

			String sentence = new String(receivePacket.getData());

			int port = receivePacket.getPort();

			InetAddress IPAddress = receivePacket.getAddress();

			ProccesInfo proccesinfo = new ProccesInfo();
			proccesinfo.Inicialize(sentence);

			String capitalizedSentence = "\n";

			str.add(proccesinfo.response());
			for (int i = 0; i < str.size(); i++) {
				capitalizedSentence += str.get(i);
			}

			sendData = capitalizedSentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

			serverSocket.send(sendPacket);

		}
		// serverSocket.close();
	}
}
