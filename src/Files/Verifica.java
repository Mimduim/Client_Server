package Files;

import java.util.*;

public class Verifica {

	List<Question> question;
	Estatistica estatistica;

	public void Search(String[] str) {
		int acertos = 0, erros = 0, index = 0;
		int[][] temp = new int[10][3];

		for (Iterator<Question> iterator = question.iterator(); iterator.hasNext();) {

			Question auxquestion = (Question) iterator.next();
			
			if (auxquestion.getNumQuest() == Integer.parseInt(str[0])) {
				if (auxquestion.getNumAlter() == Integer.parseInt(str[1])) {
					for (int i = 2; i < auxquestion.getResposta().length; i++) {
						if (str[i] == auxquestion.getResposta()[i])
							acertos += 1;
						else
							erros += 1;
					}
				}
			}

			
				temp[index][0] = auxquestion.getNumQuest();
				temp[index][1] = acertos;
				temp[index][2] = erros;
				index ++;

		}
		estatistica.setGabarito(temp);
	}

}
