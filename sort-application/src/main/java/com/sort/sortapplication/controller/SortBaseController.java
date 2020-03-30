package com.sort.sortapplication.controller;
/**
 * Controller take care of 2 API history and sort and save
 * 
 */


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sort.sortapplication.model.SortBean;
import com.sort.sortapplication.service.SortService;

@RestController
public class SortBaseController {

	@Autowired
	private SortService sortservice;
	
	@PostMapping("/sortDataApi")
	public SortBean sortData(@RequestBody SortBean bean) {
		return sortservice.perFormSortMetrics(bean.getListOfnumbers()) ;
	}
	
	@GetMapping("/historyDataApi")
	public List<SortBean> sortData(ModelMap model) {
		return sortservice.fethcAllTheHistoryData();
	}
}
