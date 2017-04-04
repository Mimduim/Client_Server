package Files;

import java.util.*;


public class DataBase {
	
      List<Question> dataQuestion;

	
	public DataBase(){}
	
	public List<Question> getDataQuestion(){
		return dataQuestion;
	}
	
	public  void  inicialize(){
		
		dataQuestion = new ArrayList<Question>();
		
		Question quest1 = new Question();
		List<String> strings = new ArrayList<String>();
		String  str = new String("1;5;VVFFV");
		strings.addAll(Arrays.asList(str.split(";")));
		quest1.setNumQuest(Integer.parseInt(strings.get(0)));
		quest1.setNumAlter(Integer.parseInt(strings.get(1)));	
		quest1.setResposta(strings.get(2));		
		dataQuestion.add(quest1);
		
		Question quest2 = new Question();
		strings.clear();
	    str = new String("2;4;VVFF");
		strings.addAll(Arrays.asList(str.split(";")));
		quest2.setNumQuest(Integer.parseInt(strings.get(0)));
		quest2.setNumAlter(Integer.parseInt(strings.get(1)));		
		quest2.setResposta(strings.get(2));
		dataQuestion.add(quest2);
		
		Question quest3 = new Question();
		strings.clear();
	    str = new String("3;3;VVF");
		strings.addAll(Arrays.asList(str.split(";")));
	    quest3.setNumQuest(Integer.parseInt(strings.get(0)));
	    quest3.setNumAlter(Integer.parseInt(strings.get(1)));		
	    quest3.setResposta(strings.get(2));
		dataQuestion.add(quest3);
		
		Question quest4 = new Question();
		strings.clear();
	    str = new String("4;2;VV");
		strings.addAll(Arrays.asList(str.split(";")));
	    quest4.setNumQuest(Integer.parseInt(strings.get(0)));
	    quest4.setNumAlter(Integer.parseInt(strings.get(1)));		
	    quest4.setResposta(strings.get(2));
		dataQuestion.add(quest4);
		
		Question quest5 = new Question();
		strings.clear();
	    str = new String("1;1;V");
		strings.addAll(Arrays.asList(str.split(";")));
	    quest5.setNumQuest(Integer.parseInt(strings.get(0)));
	    quest5.setNumAlter(Integer.parseInt(strings.get(1)));		
	    quest5.setResposta(strings.get(2));
		dataQuestion.add(quest5);
	
	}

}
