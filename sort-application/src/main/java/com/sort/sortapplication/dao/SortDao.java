package com.sort.sortapplication.dao;

import java.util.ArrayList;
import java.util.List;

import com.sort.sortapplication.model.SortBean;

public interface SortDao {

	public SortBean saveSortedData(SortBean sortBean);

	public List<SortBean> fetchDataFromDb();

}
