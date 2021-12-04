package com.example.function.stepCount;

import java.io.File;

import com.example.exception.SystemException;

/**
 * @author WEN_PENGFEI
 * @version 1.0 2021/10/16
 */

public interface CountFunction {
	
	/**
	 * ステップ数カウント機能のインスタンス
	 * パラメータ：ファイル
	 * 戻り値：ステップ数
	 * 例外：システムエラーにスロー
	 */
	public int stepCount(File file) throws SystemException; 
	

		
}
