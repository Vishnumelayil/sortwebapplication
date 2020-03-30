package com.sort.sortapplication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sort.sortapplication.dao.SortDao;
import com.sort.sortapplication.model.SortBean;
import com.sort.sortapplication.service.impl.SortServiceImpl;

class SortServiceTests extends SortApplicationTests {

	@MockBean
	private SortDao sortdao;

	@Autowired
	private SortServiceImpl sortserviceimpl;

	@Test
	void perFormSaveTest() {
		SortBean bean = new SortBean(1000L, "[18,19,87,81]", "[18,19,87,81]", "20", 2, LocalDateTime.now());
		when(sortdao.saveSortedData(bean)).thenReturn(bean);
		assertEquals(bean, sortserviceimpl.saveSortedData(bean));
	}

	@Test
	void fethcAllTheHistoryDataTest() {
		when(sortdao.fetchDataFromDb()).thenReturn(Stream
				.of(new SortBean(1000L, "[1,4,98,65,19,87]", "[1,4,19,65,87,98]", "2", 3, LocalDateTime.now()),
						new SortBean(1001L, "[18,19,87,81]", "[18,19,87,81]", "1", 2, LocalDateTime.now()))
				.collect(Collectors.toList()));
		assertEquals(2, sortserviceimpl.fethcAllTheHistoryData().size());
	}

	@Test
	void perFormSortTest() {
		int[] array_for_Sort = { 1, 4, 98, 65, 19, 87 };
		int[] expected = { 1, 4, 19, 65, 87, 98 };
		sortserviceimpl.perFormSort(array_for_Sort, 0, array_for_Sort.length - 1);
		assertArrayEquals(expected, array_for_Sort);
	}

	@Test
	void noOfPosChangeForSortTest() {
		int[] before_sort = { 1, 4, 98, 65, 19, 87 };
		int[] after_sort = { 1, 4, 19, 65, 87, 98 };
		assertEquals(3, sortserviceimpl.noOfPosChangeForSort(after_sort, before_sort));
	}

}
