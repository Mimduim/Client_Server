package Tela;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JPanel implements ActionListener {
	
    private Color color;
	private JButton UpServer;
	private JFrame jframe;

	public Button() {
		UpServer = new JButton("UpServer");
        this.add(UpServer); //this é opcional. Referencia o painel.
        UpServer.addActionListener(this);

	}
	
	public void NewButton() {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

}