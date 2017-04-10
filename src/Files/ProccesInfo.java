
package Files;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProccesInfo {

	Estatistica estatistica;
    Verifica verifica;
	Question quest;
	List<String> strings ;
	public ProccesInfo() {
	}

	public void Inicialize(String requestCLient) {


	    this.estatistica = new Estatistica();		
		strings = new ArrayList<String>();
		Question quest = new Question();
		strings.addAll(Arrays.asList(requestCLient.split(";")));
		quest.setNumQuest(Integer.parseInt(strings.get(0)));
		quest.setNumAlter(Integer.parseInt(strings.get(1)));		
		quest.setResposta(strings.get(2));		
	    verifica = new Verifica();
		estatistica.setGabarito(verifica.Search(quest));
	}

	public String response() {
		return estatistica.getResp();
	}
}

/*
 * package Files;
 * 
 * import java.util.ArrayList; import java.util.Arrays; import java.util.List;
 * 
 * public class ProccesInfo { String requestCLient; Estatistica estatistica;
 * 
 * public ProccesInfo(){} public void Inicialize(String requestCLient){
 * 
 * this.estatistica = new Estatistica();
 * 
 * List<String> strings = new ArrayList<String>(); Question quest = new
 * Question(); strings.addAll(Arrays.asList(requestCLient.split(";")));
 * quest.setNumQuest(Integer.parseInt(strings.get(0)));
 * quest.setNumAlter(Integer.parseInt(strings.get(1)));
 * quest.setResposta(strings.get(2));
 * 
 * Verifica verifica = new Verifica();
 * 
 * estatistica.setGabarito(verifica.Search(quest));
 * 
 * }
 * 
 * public String response(){ return estatistica.getResp(); } }
 */