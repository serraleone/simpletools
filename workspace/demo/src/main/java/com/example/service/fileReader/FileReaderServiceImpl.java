package com.example.service.fileReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.entity.FileInfo;
import com.example.exception.BusinessException;
import com.example.exception.SystemException;
import com.example.function.stepCount.CountFunction;
import com.example.function.stepCount.DetectFileEncoding;
import com.example.function.stepCount.FileListOutput;
import com.example.function.stepCount.JavaLogicalCountFunction;
import com.example.function.stepCount.PhysicalCountFunction;

/**
 * @author WEN_PENGFEI
 * @version 1.0 2021/10/24
 */
@Service
public class FileReaderServiceImpl implements FileReaderService {


	/*
	 *フィールド：
	 *ステップ数合計値を生成（calPhystep；calLogstep）
	 *物理的ステップカウントserviceのインスタンスを生成
	 *ファイル情報（fileInfo）をフィールド変数に
	 *ファイル情報の配列を生成(fileList）
	 */
	
	FileInfo fileInfo = null;
	ArrayList<FileInfo> fileList = new ArrayList<FileInfo>();
	CountFunction physicalCountfunction = new PhysicalCountFunction();
	CountFunction javaLogicCountfunction = new JavaLogicalCountFunction();
	
	/**
	 * ファイルの読込機能の実装
	 * パラメータ：フォルダ
	 * 戻り値：ファイル情報エンティティの配列
	 * 例外：システムエラーにスロー
	 */
	@Override
	public ArrayList<FileInfo> findAllFilesInFolder(File folder) throws SystemException{
	
		//listFilesメソッドを使用して一覧を取得する、存在しない場合はビジネス例外にスロー
		    File[] list = folder.listFiles();
		    if(list == null) {
		    	throw new BusinessException();
		    }
		    DetectFileEncoding dfe = new DetectFileEncoding();

			//フォルダー内のJAVAファイルに対し、物理的ステップ数・論理的ステップ数をカウント
			//ファイル情報エンティティを生成し、ファイルリストに追加
			for (File file : list) {
				if (!file.isDirectory()) {		
					
					if(file.getName().length()> 4 && (file.getName().substring(file.getName().length()-4)).equals("java")){
						
						dfe.detectCode(file.getPath());
						
						int phycialCount = physicalCountfunction.stepCount(file);
						int logicalCount = javaLogicCountfunction.stepCount(file);
						fileInfo = new FileInfo(file.getName(), file.getPath(), phycialCount, logicalCount);
						fileList.add(fileInfo);
				
					}
						
				} else {
					findAllFilesInFolder(file);
				}	
			}
			
		return fileList;
	}



	@Override
	public ArrayList<Integer> cal(ArrayList<FileInfo> list) throws SystemException{
		int phyStep = 0;
		int logStep = 0;
		ArrayList<Integer> calList = new ArrayList<Integer>();
		for(FileInfo fileInfo : list) {
			phyStep += fileInfo.getPhyStep();
			logStep += fileInfo.getLogStep();
		}
		calList.add(0, phyStep);
		calList.add(1, logStep);
		return calList;
	}
	
	@Override
	public void fileListClean() throws SystemException{
		fileList.clear();
	}



	@Override
	public boolean fileListOutput(String url, ArrayList<FileInfo> fileList, ArrayList<Integer> calList) throws SystemException {
		boolean status = false;
		try {
			status = new FileListOutput().fileListOutput(url, fileList, calList);
		}catch(IOException e) {
			throw new SystemException();
		}
		return status;
	}
	
	
	

}
