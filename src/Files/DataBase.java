package Files;

import java.io.*;
import java.util.*;

public class DataBase {
     List<Question> dataQuestion;
	 Question question;
	 List<String> Dados;

	public DataBase() {
	}

	public List<Question> getDataQuestion() {
		return dataQuestion;
	}

	public  void FileSTR(String diretorio, List<Question> dataQuestion) {
		FileReader Fileopen;
		BufferedReader BuffFileopen;
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
