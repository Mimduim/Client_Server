package Tela;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Window extends JFrame{
	
	private Button button;
	private JFrame frame;
	
	//private Color color;
    public  Window() {
    	frame = new JFrame("Questionário");

    }

    public void CreateWindow() {
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(500, 500);
    	frame.setVisible(true);
    	frame.add(new Button());
    }
    
  

}
