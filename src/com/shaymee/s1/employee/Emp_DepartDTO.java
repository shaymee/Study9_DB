package com.shaymee.s1.employee;

import com.shaymee.s1.department.DepartmentDTO;

public class Emp_DepartDTO extends EmployeeDTO { // 1:1 관계

	//사원 한명은 부서 하나를 가지고 있다 'has a'-->멤버변수로 사용
	private DepartmentDTO departmentDTO;  // 요것이 '1대 1'

//	public Emp_DepartDTO() {
//		departmentDTO = new DepartmentDTO();
//	} 이것도 됨
	
	
	public DepartmentDTO getDepartmentDTO() {
		return departmentDTO;
	}

	public void setDepartmentDTO(DepartmentDTO departmentDTO) {
		this.departmentDTO = departmentDTO;
	}

	
	
	
}
