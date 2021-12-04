package com.example.function.stepCount;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import com.example.exception.SystemException;
import com.glaforge.i18n.io.CharsetToolkit;

public class DetectFileEncoding {

	public Charset detectFileEncoding(String url) throws IOException {
		File file = new File(url);
		return CharsetToolkit.guessEncoding(file, 4096, Charset.forName("GBK"));
		
	}
	
	public void detectCode(String url) throws SystemException{
		DetectFileEncoding dfe = new DetectFileEncoding();
		try {
			
			String fileCode = dfe.detectFileEncoding(url).name();
			System.out.println(fileCode);
			if(fileCode.equals("UTF-8")) {
				return;
			}else if(fileCode.equals("Shift-JIS")) {
				return;
			}else if(fileCode.equals("US-ASCII")) {
				return;
			}else {
				throw new SystemException();
			}
			
		}catch(IOException e) {
			throw new SystemException();
		}
		
	}
}
