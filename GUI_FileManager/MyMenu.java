package GUI_FileManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyMenu extends JMenuBar implements ActionListener {
	JMenu fileMenu = new JMenu("File");
	JMenuItem openItem = new JMenuItem("Open File");
	JMenuItem delItem = new JMenuItem("Delete File");
	static JFileChooser fileChooser = new JFileChooser();

	MyMenu(){		
		this.setBorder( new MatteBorder(0, 0, 2, 0, Color.black));
				
		openItem.setFont(new Font("b Biger Over",Font.PLAIN,10));
		openItem.setBorder(new EmptyBorder(10,10,10,10));
		openItem.addActionListener(this);
		
		delItem.setFont(new Font("b Biger Over",Font.PLAIN,10));
		delItem.setBorder(new EmptyBorder(10,10,10,10));
		delItem.addActionListener(this);
		delItem.setForeground(Color.RED);
		
		fileMenu.setFont(new Font("b Biger Over",Font.PLAIN,12));
		fileMenu.setBorder( new EmptyBorder(10, 10, 5, 10));
		fileMenu.add(openItem);
		fileMenu.add(delItem);
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		this.add(fileMenu);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Open File":
			if(MyFileManager.openFile(Main.frame)) {
				Main.textArea.setText(MyFileManager.readFile(Main.frame));	
				Main.unFreeze();
			}
			break;
		case "Delete File":
			if (MyFileManager.deleteFile(Main.frame)) {
				Main.freeze();
				Main.textArea.setText("Write Here :");
				Main.textArea.setEnabled(false);
			}
			break;
		}
	}
}
