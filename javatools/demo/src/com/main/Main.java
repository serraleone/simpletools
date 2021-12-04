package com.main;

import javax.swing.JOptionPane;

import com.function.GenerateFile;
import com.function.Text;

/*
 * @author WEN PENGFEI
 * @date 2021/11/23
 * メインメゾッド
 */
public class Main {
	
	public static void main(String[] args) {
		
		GenerateFile gf = new GenerateFile();
		Text t = new Text();
	    
	    boolean flag = gf.writeOut(gf.createFile(), t.createText());
		
	    if(flag) {
	    	JOptionPane.showMessageDialog(null, "完了しました");
	    }
	}
}
