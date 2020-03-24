/**
 * Controller take care of Sort elements and history
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
	
	@Autowired
	private SortService sortservice;
	
	@GetMapping("/")
	public String sortApplicationPage(ModelMap model) {
		model.addAttribute("sortData",new SortBean());
		return "index";
	}
	
	@PostMapping("/sortData")
	public String sortData(@ModelAttribute("sortData") SortBean sortBean,ModelMap modelMap) {
		modelMap.put("sortedDetails", sortservice.perFormSortAndSave(sortBean.getListOfnumbers()));
		return "index";
	}
	
	@GetMapping("/historyData")
	public String sortData(ModelMap model) {
		model.put("sorthistory",sortservice.fethcAllTheHistoryData());
		return "history";
	}

	public SortService getSortservice() {
		return sortservice;
	}

	public void setSortservice(SortService sortservice) {
		this.sortservice = sortservice;
	}
	
	
	
	
}
