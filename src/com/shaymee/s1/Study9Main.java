package com.shaymee.s1;

import java.sql.Connection;

import com.shaymee.s1.department.Depart_EmpDTO;
import com.shaymee.s1.department.DepartmentDAO;
import com.shaymee.s1.department.DepartmentDTO;
import com.shaymee.s1.employee.EmployeeController;
import com.shaymee.s1.location.LocationController;
import com.shaymee.s1.location.LocationDAO;
import com.shaymee.s1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {		
		
//		LocationController locationController = new	LocationController();
//		locationController.start();
		
//		EmployeeController controller = new EmployeeController();
//		controller.start();
		
		DepartmentDAO dao = new DepartmentDAO();
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(100);
		
		Depart_EmpDTO dto = dao.getJoin(departmentDTO);
		
//		System.out.println(dto.getDepartment_name()+" 부서");
		
		for(int i=0;i<dto.getAr().size();i++) {
			
			System.out.println("================================");
			System.out.println("<"+dto.getDepartment_name()+" 부서>");
			System.out.println(dto.getAr().get(i).getLast_name());
			System.out.println(dto.getAr().get(i).getSalary());
			System.out.println(dto.getAr().get(i).getHire_date());
			System.out.println("================================");
			
		}
		
		
	}

}
