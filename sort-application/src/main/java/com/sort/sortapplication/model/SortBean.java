/**
 * Representing Sort details 
 * 
 */

package com.sort.sortapplication.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class SortBean {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "BEFORE_SORT")
	private String listOfnumbers;

	public SortBean(long id, String listOfnumbers, String afterSort, String timeTakenToSort, int noSteps,
			LocalDateTime createdDate) {
		super();
		this.id = id;
		this.listOfnumbers = listOfnumbers;
		this.afterSort = afterSort;
		this.timeTakenToSort = timeTakenToSort;
		this.noSteps = noSteps;
		this.createdDate = createdDate;
	}

	public SortBean() {
	}

	@Column(name = "AFTER_SORT")
	private String afterSort;

	@Column(name = "TIME_TAKEN_TO_SORT")
	private String timeTakenToSort;

	@Column(name = "NO_OF_STEPS")
	private int noSteps;

	@CreationTimestamp
	private LocalDateTime createdDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAfterSort() {
		return afterSort;
	}

	public void setAfterSort(String afterSort) {
		this.afterSort = afterSort;
	}

	public String getTimeTakenToSort() {
		return timeTakenToSort;
	}

	public void setTimeTakenToSort(String timeTakenToSort) {
		this.timeTakenToSort = timeTakenToSort;
	}

	public int getNoSteps() {
		return noSteps;
	}

	public void setNoSteps(int noSteps) {
		this.noSteps = noSteps;
	}

	public String getListOfnumbers() {
		return listOfnumbers;
	}

	public void setListOfnumbers(String listOfnumbers) {
		this.listOfnumbers = listOfnumbers;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

}
