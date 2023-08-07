package com.examly.springapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "task")
public class Springapp {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int taskId;
	
	
	@Column(name = "taskHolderName")
	private String taskHolderName;
	
	@Column(name = "taskDate")
	private Date taskDate;
	
	@Column(name = "taskName")
	private String taskName;

    @Column(name = "taskStatus")
	private String taskStatus;
	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int id) {
		this.taskId = id;
	}
	public String getTaskHolderName() {
		return taskHolderName;
	}
	public void setTaskHolderName(String tname) {
		this.taskHolderName = tname;
	}
	public Date getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(Date tdate) {
		this.taskDate = tdate;
	}
	public String getTaskName() {
		return taskName;


	}
	public void setTaskName(String taskname) {
		this.taskName=taskname;
	}
    public String getTaskStatus() {
		return taskStatus;


	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus=taskStatus;
	}
}


