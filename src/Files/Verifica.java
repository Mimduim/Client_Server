package Files;

import java.util.*;

public class Verifica {
	DataBase database;
	List<Integer> list;

	public Verifica() {

	}

	

	public List<Integer> Search(Question question) {
		database = new DataBase();
		database.inicialize();
		list = new ArrayList<Integer>();
		int acertos = 0, erros = 0;
		

		for (Iterator<Question> iterator = database.getDataQuestion().iterator(); iterator.hasNext();) {

			Question auxquestion = (Question) iterator.next();
			
			if (auxquestion.getNumQuest() == question.getNumQuest()) {
				if (auxquestion.getNumAlter() == question.getNumAlter()) {
					for (int i = 0; i < auxquestion.getResposta().length(); i++) {
						if (question.getResposta().charAt(i) == auxquestion.getResposta().charAt(i))
							acertos += 1;
						else
							erros += 1;
					}
				}
			}		
		}
		list.add(question.getNumQuest());
		list.add(acertos);
		list.add(erros);
		return list;
	}
}
