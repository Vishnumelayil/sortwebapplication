/**
 * Data base implementation
 * 
 */

package com.sort.sortapplication.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sort.sortapplication.dao.SortDao;
import com.sort.sortapplication.model.SortBean;

@Repository
@Transactional
public class SortDaoImpl implements SortDao{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	
	/* 
	  method to persist the data after sort,to Sort bean.
	 */
	@Override
	public SortBean saveSortedData(String beforeSort, String afterSort, String timtTakenToSort,
			int noSteps) {
		
		SortBean bean=new SortBean();
		bean.setListOfnumbers(beforeSort);
		bean.setAfterSort(afterSort);
		bean.setNoSteps(noSteps);
		bean.setTimeTakenToSort(timtTakenToSort);
		em.persist(bean);
		logger.info("persistance completed without any error");
		return bean;
	}
	

	/* 
	  method to fetch all the data present in the sort table
	 */
	@Override
	public List<SortBean> fetchDataFromDb() {
		TypedQuery<SortBean> query = 
				em.createQuery("Select  c  From SortBean c", SortBean.class);
		List<SortBean> resultList = query.getResultList();
		logger.info("Select  s  From SortBean s -> {}", resultList);		
		return resultList;
	}
	
	public SortBean findOne(long id) {
		return em.find(SortBean.class, id);
	}
	
	

}
