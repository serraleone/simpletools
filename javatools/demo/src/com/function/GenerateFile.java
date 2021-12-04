package com.function;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/*
 * @author WEN PENGFEI
 * @date 2021/11/23
 * ファイル作り
 */
public class GenerateFile {
	
	//デスクトップでファイルを生成する
	public String createFile() {
		String path = "";
		
		try {
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			String ldt = now.format(dtf);
			
			path = "C:\\Users\\Wen\\Desktop\\" + ldt + "_message.txt";
			
			File file = new File(path);
			
			file.createNewFile();
			
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "fileの生成が失敗しました");
		}
		
		return path;
	}
	
	public boolean writeOut(String path, ArrayList<com.entity.Object> list) {
		boolean flag = false;
		
		try {
			File file = new File(path);
			FileWriter fw = new FileWriter(file);
			for(com.entity.Object obj : list) {
				fw.write(obj.getMessage() + "\r");
			}
			
			fw.close();
			
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "fileへの書き込みが失敗しました");
		}
		
		flag = true;
		return flag;
	}
}
