package Files;

import java.util.*;

public class Estatistica {
	private List<Integer> resp = new ArrayList<Integer>();
	private String strbff = "";
	private List<Integer> Gabarito = new ArrayList<Integer>();

	public String getResp() {
		strbff = "Questão: " + resp.get(0).toString() + ", acertos = " + resp.get(1).toString() + ", erros = "
				+ resp.get(2).toString() + "\n";
		resp.clear();
		Gabarito.clear();
		return strbff;
	}

	public void setResp(List<Integer> gabarito) {
		resp = gabarito;
	}

	public List<Integer> getGabarito() {
		return Gabarito;
	}

	public void setGabarito(List<Integer> gabarito) {
		Gabarito = gabarito;
		setResp(Gabarito);
	}
}
