package com.sort.sortapplication;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sort.sortapplication.dao.SortDao;
import com.sort.sortapplication.model.SortBean;


class SortDaoTests extends SortApplicationTests{

	@Autowired
	private SortDao sortdao;
	
	@Test
	public void savefetchAllTests() {
		SortBean bean = new SortBean();
		bean.setListOfnumbers("[18,19,87,81]");
		bean.setAfterSort("[18,19,87,81]");
		bean.setNoSteps(2);
		bean.setTimeTakenToSort("2");
		sortdao.saveSortedData(bean);
		List<SortBean> results=sortdao.fetchDataFromDb();
		assertNotNull(results);
	}
	
	@Test
	public void saveData() {
		SortBean bean = new SortBean();
		bean.setListOfnumbers("[18,19,87,81]");
		bean.setAfterSort("[18,19,87,81]");
		bean.setNoSteps(2);
		bean.setTimeTakenToSort("2");
		sortdao.saveSortedData(bean);
		Long id=bean.getId();
		List<SortBean> results=sortdao.fetchDataFromDb();	
		assertTrue(results.stream().anyMatch(res -> res.getId() == id));
	}

}
