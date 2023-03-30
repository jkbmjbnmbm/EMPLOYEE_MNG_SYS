package com.ems.EmployeeService.external.entities;

import java.sql.Date;

import javax.json.bind.annotation.JsonbDateFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Leaves {

	private String leaveId;
	private String reason;
	
	@JsonbDateFormat("dd/MM/yyyy")	
	private Date aDate;
	
	private String empId;
	private String name;
	private String mgrId;
	private String status;
}
