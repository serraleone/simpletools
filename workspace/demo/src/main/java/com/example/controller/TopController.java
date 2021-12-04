package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author WEN_PENGFEI
 * @version 1.0 2021/10/24
 */

@Controller
public class TopController {

/*
 * 
 */
	@RequestMapping(value = "/")
	public String toSelect(Model model) {
		return "redirect:/select";
	}

}
