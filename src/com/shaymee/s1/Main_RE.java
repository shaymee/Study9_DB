package com.shaymee.s1;

import java.util.ArrayList;

import com.shaymee.s1.department.Depart_EmpDTO_RE;
import com.shaymee.s1.department.DepartmentDAO_RE;
import com.shaymee.s1.department.DepartmentDTO;
import com.shaymee.s1.employee.EmployeeDTO;

public class Main_RE {

	public static void main(String[] args) {
		
		DepartmentDTO departmentDTO = new DepartmentDTO(); 
		departmentDTO.setDepartment_id(100);
		DepartmentDAO_RE departmentDAO = new DepartmentDAO_RE();
		Depart_EmpDTO_RE dto = departmentDAO.getJoin(departmentDTO);

		
		
//		Depart_EmpDTO_RE ddto = departmentDAO.getJoin();
		
		for(int i=0;i<dto.getAr().size();i++) {			
		
		System.out.println(dto.getAr().get(i).getLast_name());
		System.out.println(dto.getAr().get(i).getSalary());
		System.out.println(dto.getAr().get(i).getHire_date());
		System.out.println(dto.getDepartment_name());
			
		System.out.println("================================");
		}

	}

}
