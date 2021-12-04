package com.example.exception;

/**
 * @author WEN_PENGFEI
 * @version 1.0 2021/10/16
 */

public class BusinessException extends RuntimeException {
	
	/*
	 * コントラクター
	 * RUNTIME例外を継承する
	 * ファイルが存在しない時のエラー
	 */
	public BusinessException() {
		super("フォルダもしくはJavaファイルは見つかません");
	}
}
