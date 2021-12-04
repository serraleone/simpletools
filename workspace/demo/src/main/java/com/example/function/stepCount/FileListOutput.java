package com.example.function.stepCount;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.example.entity.FileInfo;
import com.example.exception.SystemException;

public class FileListOutput{
	
	public boolean fileListOutput(String url, ArrayList<FileInfo> fileList, ArrayList<Integer> calList) throws IOException{
		boolean status = false;
		try {
			  LocalDateTime ldt = LocalDateTime.now();
			  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			  String currentTime = ldt.format(dtf);
			  String folderName = new File(url).getName();
			  
		      File file = new File("C:\\Users\\Wen\\Desktop\\" + currentTime + folderName + "のステップ数.txt");
		      file.createNewFile();
		      FileWriter filewriter = new FileWriter(file, Charset.forName("UTF-8"));
              
		      filewriter.write("ファイル名 | ファイルパス | 物理的ステップ数 | 論理的ステップ数\r");
		      filewriter.write("ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー" + "\r");
		      for(FileInfo fileInfo : fileList) {
		    	  filewriter.write(fileInfo.getFileName() + " | " 
		    			  + fileInfo.getUrl() + " | "
		    			  + fileInfo.getPhyStep() + " | "
		    			  + fileInfo.getLogStep() + "\r");
		      }
		      filewriter.write("合計 | " + "物理的ステップ数");
		      filewriter.write(calList.get(0) + "行 | 論理的ステップ数");
		      filewriter.write(calList.get(1)+ "\r");
		      status = true;
		      
		      filewriter.close();
		    } catch(IOException e) {
		      throw new SystemException();
		    }
		
		return status;
	}

}
