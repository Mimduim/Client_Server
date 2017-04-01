package Files;

public class ServerDataUDP {
	
	private byte[] sendData = new byte[1024];
	
	public ServerDataUDP(byte[] sendData){
		this.sendData = sendData;
		
		
	}

	public byte[] getSendData() {
		return sendData;
	}

	public void setSendData(byte[] sendData) {
		this.sendData = sendData;
	}
}
