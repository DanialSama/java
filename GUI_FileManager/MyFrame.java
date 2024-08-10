package GUI_FileManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	private String frameType;
	MyFrame(String title){
		this.setTitle(title);
	}
	void createDefaultFrame(){
		frameType = "Default";
		this.setSize(700,700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(0xA7E6FF));
		this.setLayout(new BorderLayout());
	}
	void start(){
		if(frameType.equals("Default")) {
			this.setVisible(true);			
		}
	}
}
