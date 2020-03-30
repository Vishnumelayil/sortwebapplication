package com.sort.sortapplication;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.net.URISyntaxException;

import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;

import com.sort.sortapplication.controller.SortController;
import com.sort.sortapplication.dao.SortDao;
import com.sort.sortapplication.dao.impl.SortDaoImpl;
import com.sort.sortapplication.model.SortBean;
import com.sort.sortapplication.service.SortService;

@RunWith(SpringRunner.class)
@SpringBootTest
abstract class SortApplicationTests {

//	@Autowired
//	private SortService sortservice;
//
//	@Test
//	void sortData() throws URISyntaxException {
//		String beforeSort = "4,1,9,18,19,87";
//		String expected = "[1, 4, 9, 18, 19, 87]";
//		SortBean bean = sortservice.perFormSortAndSave(beforeSort);
//		assertEquals(bean.getAfterSort(), expected);
//	}

}
