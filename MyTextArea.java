package GUI_FileManager;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class MyTextArea extends JTextArea implements CaretListener {
	JScrollPane scroll;
	private boolean firstErase = false;
	MyTextArea(String placeHolder,int row , int column){
		this.setText(placeHolder);
		this.setRows(row);
		this.setColumns(column);
	}
	public void set_DefaultTextArea() {
		this.setMargin(new Insets(10, 20, 10, 20));
		this.setWrapStyleWord(true);
		this.setFont(new Font("Arial",Font.BOLD,14));
		scroll = new JScrollPane(this,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.addCaretListener(this);
	}
	public JScrollPane textAreaReturn() {
		return scroll;
	}
	@Override
	public void caretUpdate(CaretEvent e) {
		if(!firstErase) {
			try {
				this.setText(null);
				firstErase = true;				
			}catch(Exception error) {
				System.out.println(error);
			}
		}			
	}
}
