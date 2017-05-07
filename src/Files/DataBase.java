package Files;

import java.io.*;
import java.util.*;

public class DataBase {
	private static List<Question> dataQuestion;
	private static Question question;
	private static FileReader Fileopen;
	private static BufferedReader BuffFileopen;

	public DataBase() {	}

	public List<Question> getDataQuestion() {
		return dataQuestion;
	}

	public  void FileSTR(String diretorio, List<Question> dataQuestion) {
		try {
			Fileopen = new FileReader(diretorio);
			BuffFileopen = new BufferedReader(Fileopen);
			while (BuffFileopen.ready()) {
				String linha = BuffFileopen.readLine();
				// Dsesenvolvimento.
				while (linha != null) {
					String[] slot = linha.split(";");
					question = new Question(Integer.parseInt(slot[0]), Integer.parseInt(slot[1]), slot[2]);
					dataQuestion.add(question);
					linha = BuffFileopen.readLine();
				}
			}
			BuffFileopen.close();
		} catch (FileNotFoundException erro) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", erro.getMessage());
		} catch (IOException erro) {
			System.err.printf("Erro: %s.\n", erro.getMessage());
		}
	}

	public void inicialize() {
		dataQuestion = new ArrayList<Question>();
		FileSTR("Gabarito.txt", dataQuestion);
	}

}
