package com.example.controller;

import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.entity.FileInfo;
import com.example.exception.BusinessException;
import com.example.form.FolderPathForm;
import com.example.service.fileReader.FileReaderService;

/**
 * @author WEN_PENGFEI
 * @version 1.0 2021/10/24
 */
@SessionAttributes(value={"fileList","calList","url", "outputFlag"}) 
@Controller
public class StepCountController {

/**Service 
 * 
 */
@Autowired
private FileReaderService fileReaderServiceImpl;

/*
 * 
 */

	@RequestMapping(value = "/select")
	public String toSelectView(Model model, SessionStatus status) {
		status.setComplete();
		model.addAttribute("folderPathForm", new FolderPathForm());
		return "/Select";
	}
	
	@RequestMapping(value = "/selectResult")
	public String toSelectResultView(@Validated FolderPathForm form,
			BindingResult result, Model model){
		
		if(result.hasErrors()) {
			return "/Select";
		}
		
		
		String url = form.getUrl();
		
		//serviceのフィールドの配列をクリアする必要がある！
		//そうしないと結果表示の配列が累積する！
		fileReaderServiceImpl.fileListClean();

		ArrayList<FileInfo> fileList = fileReaderServiceImpl.findAllFilesInFolder(new File(url));
		if(fileList.isEmpty()) {
			throw new BusinessException();
		}
		
		ArrayList<Integer> calList = fileReaderServiceImpl.cal(fileList);
		model.addAttribute("fileList", fileList);
		model.addAttribute("calList", calList);		
		model.addAttribute("url", url);
		model.addAttribute("outputFlag","0");

		return "/SelectResult";
	}
	
	@RequestMapping(value = "/selectResultOutput")
	public String toSelectResultOutput(@ModelAttribute("fileList") ArrayList<FileInfo> fileList,
			@ModelAttribute("calList") ArrayList<Integer> calList, @ModelAttribute("url") String url,
			Model model){
		boolean status = fileReaderServiceImpl.fileListOutput(url, fileList, calList);
		if(status == true) {
			model.addAttribute("outputFlag", "1");
		}
		
		return "/SelectResult";
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(BusinessException.class)
	public String catchBizException(Model model, Exception e) {
		model.addAttribute("message", e.getMessage());
		model.addAttribute("folderPathForm", new FolderPathForm());
		return "/Select";
	}

}
