package com.example.function.stepCount;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import com.example.exception.SystemException;

/**
 * @author WEN_PENGFEI
 * @version 1.0 2021/10/23
 */

public class JavaLogicalCountFunction extends LogicalCountFunction {
	
	/*
	 * フィールド：
	 * ステップ数
	 */
	int count;

	/**
	 * 論理的ステップ数カウント機能の実装
	 * パラメータ：ファイル
	 * 戻り値：ステップ数
	 * 例外：システムエラーにスロー
	 */
	@SuppressWarnings("finally")
	@Override
	public int stepCount(File file) throws SystemException{
		
		/*
		 * LineNumberReaderクラスのインスタンスを生成
		 * ステップ数（count）、計算しないステップ数（notCounted）、行の内容（line）を生成
		 * コメント行を読んでいるかを判断するのフラグ（commentflag）
		 */
		LineNumberReader lnr = null;
		count = 0;
		int notCounted = 0;
		String line = null;
		int commentflag = 0;
		
		try {
			 lnr = new LineNumberReader(new FileReader(file));
			
			 //while内は、空行、コメント行のステップ数を排除するための処理
			 while((line = lnr.readLine()) != null) {
					count++;
					
					if(commentflag == 0) { 
						if(line.trim().equals("")) {
	     					notCounted ++;
							continue;
						}
						
						//IndexOutOfBoundsException回避のため
						if (line.trim().length() < 2){
							continue;
						}else { 						
							if(line.trim().substring(0,2).equals("//")) {
								notCounted ++;
								continue;
							}else if(line.trim().substring(0,2).equals("/*")) {
								notCounted ++;
								commentflag = 1;
								continue;
							}
						}
						
					}else if(commentflag == 1){	 
						
						//IndexOutOfBoundsException回避のため
						if(line.trim().length() < 2) {
							notCounted ++;
							continue;
						}else if(line.trim().substring(line.trim().length()-2).equals("*/")) {
							notCounted ++;
							commentflag = 0;
							continue;
						}else {
							notCounted ++;
							continue;
						}
					}
			 }

			
			count -= notCounted;
			
		}finally {
			if(lnr != null) {
				try {
					lnr.close();
				} catch (IOException e) {
					throw new SystemException();
				}
			}else {
				throw new SystemException();
			}
			
			return count;
			
		}
		
	}
	
}
