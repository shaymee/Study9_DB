package com.shaymee.s1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.shaymee.s1.employee.EmployeeDTO;
import com.shaymee.s1.util.DBConnect;

public class DepartmentDAO_RE { //DAO ==> Database Access Object : 데이터베이스에 접근하는 객체
	
	private DBConnect dbConnect;
	
	public DepartmentDAO_RE() {
		
		dbConnect = new DBConnect();
						
	}
	
	
	public Depart_EmpDTO_RE getJoin(DepartmentDTO departDTO) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO employeeDTO = null;
		DepartmentDTO departmentDTO = new DepartmentDTO();
		Depart_EmpDTO_RE dto = null;
		
		try {
			
			con = dbConnect.getConnect();
			String sql = "SELECT E.LAST_NAME, E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME "
					+ " FROM EMPLOYEES E inner join DEPARTMENTS D"
					+ " ON (E.DEPARTMENT_ID = D.DEPARTMENT_ID)"
					+ " WHERE E.DEPARTMENT_ID = ?";
			
			st = con.prepareStatement(sql);
			st.setInt(1, departDTO.getDepartment_id());
			rs = st.executeQuery();
			
			dto = new Depart_EmpDTO_RE();
			dto.setAr(new ArrayList<>());
			ArrayList<EmployeeDTO> eDTO = new ArrayList<EmployeeDTO>();
			
			while(rs.next()) {
				
				employeeDTO = new EmployeeDTO();
				
				employeeDTO.setLast_name(rs.getString("LAST_NAME"));
				employeeDTO.setSalary(rs.getInt("SALARY"));
				employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
				eDTO.add(employeeDTO);
				dto.setAr(eDTO);
					
				dto.setDepartment_name(rs.getString("DEPARTMENT_NAME"));							
				
			}
			

	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disConnect(con, st, rs);
		}
		
		return dto;
		
		
	}
	

}
