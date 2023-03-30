package com.ems.ManagerService.external.entities;

import java.sql.Date;

import javax.json.bind.annotation.JsonbDateFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tasks {

	private String taskId;
	private String taskDesc;
	
	@JsonbDateFormat("dd/MM/yyyy")	
	private Date target;
	
	private String empId;
	private String name;
	private String mgrId;
	private String status;
}
