package com.shaymee.s1.department;

import java.util.ArrayList;

import com.shaymee.s1.employee.EmployeeDTO;

public class Depart_EmpDTO extends DepartmentDTO { // 1:N의 관계

	private ArrayList<EmployeeDTO> ar;  // 1:N의 관계는 이런 식으로 표현. 배열은 숫자를 알아야해서 무리

	
	public ArrayList<EmployeeDTO> getAr() {
		return ar;
	}

	public void setAr(ArrayList<EmployeeDTO> ar) {
		this.ar = ar;
	}
	
	
	
	
	
	
}
