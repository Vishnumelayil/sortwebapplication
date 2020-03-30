/**
 * Service class to sort,find the sort time & no of position changed for sorting 
 * 
 */
package com.sort.sortapplication.service.impl;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sort.sortapplication.dao.SortDao;
import com.sort.sortapplication.model.SortBean;
import com.sort.sortapplication.service.SortService;

@Service
public class SortServiceImpl implements SortService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SortDao sortdao;

	// method to perfom sort and save
	@Override
	public SortBean perFormSortMetrics(String beforeSortData) {

		String timeTakenToSort;

		int[] array_for_sort = Arrays.stream(beforeSortData.split(",")).mapToInt(Integer::parseInt).toArray();

		int[] tempArray = array_for_sort.clone();

		Instant start = Instant.now();
		System.out.println(start + " start" + System.currentTimeMillis());
		perFormSort(array_for_sort, 0, array_for_sort.length - 1);

		Instant finish = Instant.now();
		System.out.println(finish + " finish" + System.currentTimeMillis());
		timeTakenToSort = String.valueOf(Duration.between(start, finish).toNanos());
		int steps = noOfPosChangeForSort(tempArray, array_for_sort);

		logger.info("Calling persistance service");

		SortBean bean = new SortBean();
		bean.setListOfnumbers(Arrays.toString(tempArray));
		bean.setAfterSort(Arrays.toString(array_for_sort));
		bean.setNoSteps(steps);
		bean.setTimeTakenToSort(timeTakenToSort);
		return saveSortedData(bean);
	}

	public SortBean saveSortedData(SortBean bean) {
		// TODO Auto-generated method stub
		return sortdao.saveSortedData(bean);
	}

	// method to fetch the data
	@Override
	public List<SortBean> fethcAllTheHistoryData() {
		return sortdao.fetchDataFromDb();
	}

	// method to check the change in position after the sort perfomed
	public int noOfPosChangeForSort(int[] tempArray, int[] array_for_sort) {
		int posChange = array_for_sort.length;
		for (int i = 0; i < array_for_sort.length; i++) {
			if (tempArray[i] == array_for_sort[i]) {
				posChange--;
			}
		}
		return posChange;
	}

	// Main method for sort

	public void perFormSort(int[] array_for_sort, int low, int high) {
		if (low < high) {
			int partitionvalue = partition(array_for_sort, low, high);
			perFormSort(array_for_sort, low, partitionvalue - 1);
			perFormSort(array_for_sort, partitionvalue + 1, high);
		}

	}

	// Dividing and checking
	public int partition(int[] array_for_sort, int low, int high) {

		int pivot = array_for_sort[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (array_for_sort[j] <= pivot) {
				i++;
				int temp = array_for_sort[i];
				array_for_sort[i] = array_for_sort[j];
				array_for_sort[j] = temp;
			}
		}
		int temp = array_for_sort[i + 1];
		array_for_sort[i + 1] = array_for_sort[high];
		array_for_sort[high] = temp;
		return i + 1;

	}

}
