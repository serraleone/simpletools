package com.example.function.stepCount;

import java.io.File;

import com.example.exception.SystemException;

/**
 * @author WEN_PENGFEI
 * @version 1.0 2021/10/16
 */

public abstract class LogicalCountFunction implements CountFunction {
	
	int count;
	
	/**
	 * 論理的ステップ数カウント機能の抽象クラス
	 * パラメータ：ファイル
	 * 戻り値：ステップ数
	 * 例外：システムエラーにスロー
	 */
	@Override
	public abstract int stepCount(File file) throws SystemException;

}
