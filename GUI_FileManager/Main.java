package GUI_FileManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Main{
	public static MyFrame frame;
	static JPanel buttonPanel = new JPanel();
	public static JPanel textareaPanel = new JPanel();
	public static MyTextArea textArea;
	public static MyButton saveButton;
	public static MyButton readButton;
	public static MyButton exitButton;
	
	public static void main(String[] args) {
//		------------------------------------------------ Create Buttons ------------------------------------------------
		saveButton = new MyButton("Save File");
		saveButton.createDefaultButton();
		
		readButton = new MyButton("Read File");
		readButton.createDefaultButton();
		
		exitButton = new MyButton("Exit");		
		exitButton.createDefaultButton();
		exitButton.set_exitButton();
//		------------------------------------------------ Create Text Area --------------------------------------------
		textArea = new MyTextArea("Write Here : ",33,33);
		textArea.set_DefaultTextArea();
//		------------------------------------------------ Create Frame ------------------------------------------------
		frame = new MyFrame("File Manager");
		frame.createDefaultFrame();
//		------------------------------------------------  Panels Setting -------------------------------------------
		buttonPanel.setLayout(new GridLayout(9,0,0,0));
		buttonPanel.setBackground(new Color(0x50727B));
		
		textareaPanel.setBackground(new Color(0x50727B));
//		------------------------------------------------ add Components to Panels -------------------------------------------
		buttonPanel.add(saveButton);
		buttonPanel.add(readButton);
		buttonPanel.add(exitButton);
		
		textareaPanel.add(textArea.textAreaReturn());
//		------------------------------------------------ add Components to Frame -------------------------------------------
		frame.setJMenuBar(new MyMenu());
		frame.add(buttonPanel,BorderLayout.WEST);
		frame.add(textareaPanel,BorderLayout.CENTER);
//		------------------------------------------------ Start The Programm -------------------------------------------
		frame.start();
		start();
	}

	private static void start() {
		int result = JOptionPane.showConfirmDialog(frame, MessageFactory.File_Question_Create,MessageFactory.Header_Question,JOptionPane.YES_NO_OPTION);
		if(result == 0) {
			if(Laboratory.switchON(frame)) {
				JOptionPane.showMessageDialog(frame, MessageFactory.File_Success_Create,MessageFactory.Header_Success,JOptionPane.INFORMATION_MESSAGE);
				freeze();				
			}
		}else {
			JOptionPane.showMessageDialog(frame, MessageFactory.File_Info_Choose);
			freeze();						
		}
	}
	public static void freeze() {
		 saveButton.setEnabled(false);
		 readButton.setEnabled(false);
	}
	public static void unFreeze() {
		saveButton.setEnabled(true);
		readButton.setEnabled(true);
		Main.textArea.setEnabled(true);
	}
}
