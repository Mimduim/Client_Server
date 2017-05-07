
package Files;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProccesInfo {
	private Estatistica estatistica;
	private Verifica verifica;
	private Question quest;
	private List<String> strings;

	public ProccesInfo() {}

	public void Inicialize(String requestCLient) {
		this.estatistica = new Estatistica();
		strings = new ArrayList<String>();
		quest = new Question();
		strings.addAll(Arrays.asList(requestCLient.split(";")));
		quest.setNumQuest(Integer.parseInt(strings.get(0)));
		quest.setNumAlter(Integer.parseInt(strings.get(1)));
		quest.setResposta(strings.get(2));
		this.verifica = new Verifica();
		estatistica.setGabarito(verifica.Search(quest));	
	}

	public String response() {
		return estatistica.getResp();
	}
}