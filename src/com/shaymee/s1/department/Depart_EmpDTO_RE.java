package com.shaymee.s1.department;

import java.util.ArrayList;

import com.shaymee.s1.employee.EmployeeDTO;

public class Depart_EmpDTO_RE extends DepartmentDTO {  // DTO : Data Transfer Object : Data를 담고 있는 객체, data덩어리

	private ArrayList<EmployeeDTO> ar;

	public ArrayList<EmployeeDTO> getAr() {
		return ar;
	}

	public void setAr(ArrayList<EmployeeDTO> ar) {
		this.ar = ar;
	}
	
	
	
	
	
}
