package Files;

public class Estatistica {

	StringBuffer resp;
	int[][] Gabarito = new int[10][3];

	public StringBuffer getResp() {
		return resp;
	}

	public void setResp(int[][] gabarito) {

		for (int i = 0; i < Gabarito.length; i++) {
			for (int j = 0; j < Gabarito.length; j++) {
				this.resp.append("Questão " + Gabarito[i][j] + ':' + "acertos = " + Gabarito[i][j] + 'e' + "erros ="
						+ Gabarito[i][j] + "\n");
			}
		}

	}

	public int[][] getGabarito() {
		return Gabarito;
	}

	public void setGabarito(int[][] gabarito) {
		Gabarito = gabarito;
		setResp(Gabarito);
	}

	public StringBuffer str() {

		return resp;
	}

}
