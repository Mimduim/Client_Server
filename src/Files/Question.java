package Files;

public class Question {
	
	private  int NumQuest;
	private  int NumAlter;
	private  String Resposta;

	public Question(){}
	
	public Question (int NQ, int NA, String R){
		this.NumQuest = NQ;
		this.NumAlter = NA;
		this.Resposta = R;		
	}

	public  int getNumQuest() {
		return NumQuest;
	}


	public  void setNumQuest(int numQuest) {
		NumQuest = numQuest;
	}


	public  int getNumAlter() {
		return NumAlter;
	}


	public  void setNumAlter(int numAlter) {
		NumAlter = numAlter;
	}


	public  String getResposta() {
		return Resposta;
	}


	public  void setResposta(String resposta) {
		Resposta = resposta;
	}
}
