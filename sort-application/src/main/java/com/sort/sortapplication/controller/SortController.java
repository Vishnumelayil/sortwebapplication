/**
 * Controller take care of View
 * 
 */
package com.sort.sortapplication.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sort.sortapplication.model.SortBean;
import com.sort.sortapplication.service.SortService;

@Controller
public class SortController {

	@GetMapping("/")
	public String sortApplicationPage() {
		return "welcome";
	}

}
