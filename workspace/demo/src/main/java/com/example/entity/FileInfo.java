package com.example.entity;


/**
 * @author WEN_PENGFEI
 * @version 1.0 2021/10/16
 */

public class FileInfo {

	/**
	 * ファイルの情報を管理するエンティティ
	 * パラメータ；fileName（ファイル名前）、
	 * 			   url(パス)、
	 * 			   phyStep（物理的ステップ数）、
	 * 			   logStep（論理的ステップ数）
	 */
	
	private String fileName; 
	private String url;
	private int phyStep;
	private int logStep;
	
	
	
	public FileInfo(String fileName, String url, int phyStep, int logStep) {
		super();
		this.fileName = fileName;
		this.url = url;
		this.phyStep = phyStep;
		this.logStep = logStep;
	}

	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public int getPhyStep() {
		return phyStep;
	}
	
	public void setPhyStep(int phyStep) {
		this.phyStep = phyStep;
	}
	
	public int getLogStep() {
		return logStep;
	}
	
	public void setLogStep(int logStep) {
		this.logStep = logStep;
	}

    	
}
