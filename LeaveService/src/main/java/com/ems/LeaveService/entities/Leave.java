package com.ems.LeaveService.entities;

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
@Table(name = "Leaves")
public class Leave {

	@Id
	@Column(name = "LeaveID")
	private String leaveId;
	
	@Column(name = "Reason")
	private String reason;
	
	@JsonbDateFormat("dd/MM/yyyy")	
	@Column(name = "Applied for")
	private Date aDate;
	
	@Column(name = "EmpID")
	private String empId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "ManagerID")
	private String mgrId;
	
	@Column(name = "Status")
	private String status;
	
}