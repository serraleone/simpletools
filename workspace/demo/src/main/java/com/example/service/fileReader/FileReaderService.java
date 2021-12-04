package com.example.service.fileReader;

import java.io.File;
import java.util.ArrayList;

import com.example.entity.FileInfo;
import com.example.exception.SystemException;


/**
 * @author WEN_PENGFEI
 * @version 1.0 2021/10/24
 */
public interface FileReaderService {

	/**
	 * ファイルの読込機能のインターフェース
	 * パラメータ：フォルダ
	 * 戻り値：ファイル情報エンティティの配列
	 * 例外：システムエラーにスロー
	 */
	public ArrayList<FileInfo> findAllFilesInFolder(File folder) throws SystemException;
	
	public ArrayList<Integer> cal(ArrayList<FileInfo> list) throws SystemException;
	
	public void fileListClean() throws SystemException;
	
	public boolean fileListOutput(String url, ArrayList<FileInfo> fileList, ArrayList<Integer> calList) throws SystemException;
}
