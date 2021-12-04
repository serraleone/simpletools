package com.example.function.stepCount;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import com.example.exception.SystemException;

/**
 * @author WEN_PENGFEI
 * @version 1.0 2021/10/16
 */

public class PhysicalCountFunction implements CountFunction {
	
	/*
	 * フィールド：
	 * ステップ数
	 */
	int count;
	
	/**
	 * 物理的ステップ数カウント機能の実装
	 * パラメータ：ファイル
	 * 戻り値：ステップ数
	 * 例外：システムエラーにスロー
	 */
	@SuppressWarnings("finally")
	@Override
	public int stepCount(File file) throws SystemException{
		
		/*
		 * LineNumberReaderクラスのインスタンスを生成
		 * ステップ数（count）を生成
		 */
		LineNumberReader lineNumberReader = null;
		count = 0;
		
		try {
			lineNumberReader = new LineNumberReader(new FileReader(file));
			while(lineNumberReader.readLine() != null) {
				
			}
			//getLineNumberメゾッドで物理的ステップ数を獲得
			count = lineNumberReader.getLineNumber();
		}finally {
			if(lineNumberReader != null) {
				try {
					lineNumberReader.close();
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
