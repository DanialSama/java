package GUI_FileManager;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class MyFileManager{
	public static JFileChooser fileChooser;
	public static FileNameExtensionFilter filter;
	public static File file = null;
	public static FileWriter fileWriter;
	public static FileReader fileReader;
		
	public static boolean openFile(JFrame parent) {
		fileChooser = new JFileChooser();
		filter = new FileNameExtensionFilter("TEXT Files", "txt", "text");
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		int result = fileChooser.showOpenDialog(parent);
		
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			if(checkTextFile(selectedFile)) {
				file = new File(selectedFile.getAbsolutePath());
				JOptionPane.showMessageDialog(parent, MessageFactory.File_Success_Open, MessageFactory.Header_Success, JOptionPane.INFORMATION_MESSAGE);
				return true;
			}else {
				JOptionPane.showMessageDialog(parent, MessageFactory.File_Warning_Choose, MessageFactory.Header_Warning, JOptionPane.WARNING_MESSAGE);				
				return false;
			}
		}else {
			JOptionPane.showMessageDialog(parent, MessageFactory.File_Info_Cancel, MessageFactory.Header_Info, JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}
	
	public static boolean checkTextFile(File selectedFile) {
		if(selectedFile.isFile()) {
			char[] pathList = selectedFile.getAbsolutePath().toCharArray();
			String fileSuffix = ""+pathList[pathList.length-4]+ pathList[pathList.length-3] + pathList[pathList.length-2] + pathList[pathList.length-1];
			if(fileSuffix.equals(".txt")) {
				return true;				
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	public static boolean deleteFile(JFrame parent) {
		if(file != null) {
			if(file.delete()) {
				JOptionPane.showMessageDialog(parent, MessageFactory.File_Success_Delete, MessageFactory.Header_Success, JOptionPane.INFORMATION_MESSAGE);				
				return true;
			}else {
				JOptionPane.showMessageDialog(parent, MessageFactory.File_Error_Delete, MessageFactory.Header_Error, JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}else {
			JOptionPane.showMessageDialog(parent, MessageFactory.File_Error_NotFound, MessageFactory.Header_Error, JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public static boolean writeFile(String pen , JFrame parent) {
		File file = new File ("C:\\Users\\Danial Sama\\Desktop\\Test.txt");
		try {
			if(!file.exists()) {
				file.createNewFile();	
			}
			fileWriter = new FileWriter(file.getAbsolutePath());	
			fileWriter.write(pen);
			fileWriter.close();
			return true;
		}
		catch(Exception error){
			JOptionPane.showMessageDialog(parent, error,MessageFactory.Header_Error,JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public static String readFile(JFrame parent) {
		if(file != null) {
			try {
				fileReader = new FileReader(file.getAbsolutePath());	
				String fileData = "";
				int temp = fileReader.read();
				while(temp > -1) {
					fileData += (char)temp;
					temp = fileReader.read();
				}
				fileReader.close();
				return fileData;
			}catch(Exception error) {
				JOptionPane.showMessageDialog(parent, error,"Error",JOptionPane.ERROR_MESSAGE);			
			}
		}else {
			JOptionPane.showMessageDialog(parent, MessageFactory.File_Error_NotFound,MessageFactory.Header_Error,JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	public static File getFile(JFrame parent) {
		if(file != null) {
			return file;
		}else {
			JOptionPane.showMessageDialog(parent, MessageFactory.File_Info_Choose,MessageFactory.Header_Info,JOptionPane.INFORMATION_MESSAGE);
			return null;
		}
	}
	
}
