package com.sort.sortapplication.dao;

import java.util.ArrayList;
import java.util.List;

import com.sort.sortapplication.model.SortBean;

public interface SortDao {
	
	public SortBean saveSortedData(String beforeSortData,String string,
			String timtTakenToSort,int noSteps);

	public List<SortBean> fetchDataFromDb();

}
