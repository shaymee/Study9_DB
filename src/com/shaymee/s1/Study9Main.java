package com.shaymee.s1;

import java.sql.Connection;
import java.util.ArrayList;

import com.shaymee.s1.department.Depart_EmpDTO;
import com.shaymee.s1.department.DepartmentDAO;
import com.shaymee.s1.department.DepartmentDTO;
import com.shaymee.s1.employee.EmployeeController;
import com.shaymee.s1.location.LocationController;
import com.shaymee.s1.location.LocationDAO;
import com.shaymee.s1.location.LocationDAO2;
import com.shaymee.s1.location.LocationDTO;
import com.shaymee.s1.location.LocationView;
import com.shaymee.s1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {		
		
		LocationController controller = new LocationController();
		controller.start();
		System.out.println("=== fin. ===");
		
//		LocationView locationView = new LocationView();
		
//		LocationDAO2 locationDAO = new LocationDAO2();
//		LocationDTO locationDTO = new LocationDTO();
//		locationDTO.setLocation_id(1000);
//		locationDTO = locationDAO.getOne(locationDTO);
//		
//		if(locationDTO != null) {
//		System.out.println(locationDTO.getLocation_id());
//		System.out.println(locationDTO.getStreet_address());
//		System.out.println(locationDTO.getPostal_code());
//		System.out.println(locationDTO.getState_province());
//		System.out.println(locationDTO.getCity());
//		System.out.println(locationDTO.getCountry_id());
//		} else {
//		System.out.println("== 조회 실패 ==");
//		}
		
		
//		ArrayList<LocationDTO> ar = locationDAO.getList();
		
//		locationView.view(ar);
		
//		for(int i=0;i<ar.size();i++) {
//			System.out.println(ar.get(i).getLocation_id());
//			System.out.println(ar.get(i).getStreet_address());
//			System.out.println(ar.get(i).getPostal_code());
//			System.out.println(ar.get(i).getState_province());
//			System.out.println(ar.get(i).getCity());
//			System.out.println(ar.get(i).getCountry_id());
//			
//			System.out.println("====================================");
//		}
		

//		LocationController locationController = new	LocationController();
//		locationController.start();
		
//		EmployeeController controller = new EmployeeController();
//		controller.start();
		
//		DepartmentDAO dao = new DepartmentDAO();
//		DepartmentDTO departmentDTO = new DepartmentDTO();
//		departmentDTO.setDepartment_id(100);
//		
//		Depart_EmpDTO dto = dao.getJoin(departmentDTO);
//		
//		System.out.println(dto.getDepartment_name()+" 부서");
//		
//		for(int i=0;i<dto.getAr().size();i++) {
//			
//			System.out.println("================================");
//			System.out.println("<"+dto.getDepartment_name()+" 부서>");
//			System.out.println(dto.getAr().get(i).getLast_name());
//			System.out.println(dto.getAr().get(i).getSalary());
//			System.out.println(dto.getAr().get(i).getHire_date());
//			System.out.println("================================");
//			
//		}
		
		
	}

}
