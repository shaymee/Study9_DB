package com.shaymee.s1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.shaymee.s1.employee.EmployeeDTO;
import com.shaymee.s1.util.DBConnect;

public class DepartmentDAO {
	
	private DBConnect dbConnect; // DBConnect 선언
	
	public DepartmentDAO() { // 생성자
		dbConnect = new DBConnect();
	}
	
	//getJoin
	
	public Depart_EmpDTO getJoin(DepartmentDTO departmentDTO) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Depart_EmpDTO dto = null;
		EmployeeDTO eDTO = null;
//		ArrayList<EmployeeDTO> arr = null;
		
		try {
			
			con = dbConnect.getConnect();
			String sql = "SELECT E.LAST_NAME, E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME, D.DEPARTMENT_ID "
					+ " FROM EMPLOYEES E inner join DEPARTMENTS D"
					+ " ON (E.DEPARTMENT_ID = D.DEPARTMENT_ID)"
					+ " WHERE E.DEPARTMENT_ID= 90";
			
			st = con.prepareStatement(sql);
//			st.setInt(1, );
			
			rs = st.executeQuery();
			
			dto = new Depart_EmpDTO();
			dto.setAr(new ArrayList<EmployeeDTO>());
			
			while(rs.next()) {
				
				eDTO =new EmployeeDTO();
				
				eDTO.setLast_name(rs.getString("LAST_NAME"));
				eDTO.setSalary(rs.getInt("SALARY"));
				eDTO.setHire_date(rs.getDate("HIRE_DATE"));				
				dto.getAr().add(eDTO);
				dto.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
				dto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				
//				dto.setAr.setLast_name(rs.nextString("LAST_NAME"));
	
			}
			
//			if(rs.next()) {
//				
//				dto.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
//				dto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
//			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return dto;
	}
	

	

}
