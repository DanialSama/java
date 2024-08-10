package GUI_FileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MyButton extends JButton implements ActionListener{

	MyButton(String name){
		this.setText(name);
	}
	
	void createDefaultButton() {
		this.setPreferredSize(new Dimension(150,50));
		this.setFont(new Font("b Biger Over",Font.PLAIN,14));
		this.setFocusable(false);
		this.setForeground(Color.BLACK);
		this.setBackground(Color.LIGHT_GRAY);		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		this.addActionListener(this);
	}
	void set_exitButton() {
		this.setForeground(Color.WHITE);
		this.setBackground(Color.RED);
		this.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Save File":
			String pen = Main.textArea.getText();
			if(!pen.isBlank()) {
				if(MyFileManager.writeFile(pen,Main.frame)) {
					JOptionPane.showMessageDialog(Main.frame, MessageFactory.File_Success_Save, MessageFactory.Header_Success, JOptionPane.INFORMATION_MESSAGE);									
				}
			}else {
				JOptionPane.showMessageDialog(Main.frame, MessageFactory.File_Info_Empty, MessageFactory.Header_Warning, JOptionPane.WARNING_MESSAGE);				
			}
			break;
		case "Read File":
			if(MyFileManager.file.exists() || MyFileManager.file != null) {
				Main.textArea.setText(MyFileManager.readFile(Main.frame));
			}else {
				JOptionPane.showMessageDialog(Main.frame, MessageFactory.File_Error_NotFound, MessageFactory.Header_Error, JOptionPane.ERROR_MESSAGE);
			}
			break;
		case "Exit":
			System.exit(0);
			break;
		}
	}
}
