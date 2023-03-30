package com.ems.TaskService.entities;

import java.sql.Date;

import javax.json.bind.annotation.JsonbDateFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Tasks")
public class Tasks {

	@Id
	@Column(name = "TaskID")
	private String taskId;
	
	@Column(name = "Description")
	private String taskDesc;
	
	@JsonbDateFormat("dd/MM/yyyy")	
	@Column(name = "Deadline")
	private Date target;
	
	@Column(name = "EmpID")
	private String empId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "ManagerID")
	private String mgrId;
	
	@Column(name = "Status")
	private String status;
	
}
