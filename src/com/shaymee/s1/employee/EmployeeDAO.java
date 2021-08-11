package com.shaymee.s1.employee;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.shaymee.s1.department.DepartmentDTO;
import com.shaymee.s1.util.DBConnect;

public class EmployeeDAO {

	private DBConnect dbConnect;
//	private Emp_DepartDTO emp_departDTO;
	
	
	public EmployeeDAO() {
		dbConnect = new DBConnect();
//		emp_departDTO = new Emp_DepartDTO();
	}
	
	
	
	//getJoin() 이 메소드를 통해 조인함 // 조인한 결과물을 담아서 DTO에 리턴해주면 됨
	public Emp_DepartDTO getJoin(EmployeeDTO employeeDTO) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		DepartmentDTO departmentDTO = null;
		Emp_DepartDTO emp_departDTO = null;
		
		try {
			
			con = dbConnect.getConnect();
			
//			String sql = "SELECT E.LAST_NAME, E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME "
//					+ "FROM EMPLOYEES E inner join DEPARTMENTS D "
//					+ "ON (E.DEPARTMENT_ID = D.DEPARTMENT_ID) "
//					+ "WHERE E.EMPLOYEE_ID = 101";

			StringBuffer sb = new StringBuffer();
			sb.append("SELECT E.LAST_NAME, E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME ");
			sb.append("FROM EMPLOYEES E inner join DEPARTMENTS D ");
			sb.append("ON (E.DEPARTMENT_ID = D.DEPARTMENT_ID) ");
			sb.append("WHERE E.EMPLOYEE_ID = ?");
			
//			st = con.prepareStatement(sql);			
			st = con.prepareStatement(sb.toString());
			st.setInt(1, employeeDTO.getEmployee_id());
			rs = st.executeQuery();
			
			if(rs.next()) {
				emp_departDTO = new Emp_DepartDTO();	
				emp_departDTO.setDepartmentDTO(new DepartmentDTO()); // 이거 복습 필요하다
				
				emp_departDTO.setLast_name(rs.getString("LAST_NAME"));
				emp_departDTO.setSalary(rs.getInt("SALARY"));
				emp_departDTO.setHire_date(rs.getDate("HIRE_DATE"));
				emp_departDTO.getDepartmentDTO().setDepartment_name(rs.getString("DEPARTMENT_NAME")); // 얘도 같이 복습 ;;
				
				
				//select한 결과만 꺼낼 수 있음
				// dto.setEmployee_id(rs.getInt("employee_id")) --> ERROR 발생
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disConnect(con, st, rs);
			
		}

		return emp_departDTO;
		
	}
	
	
	
	private Object getString(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<EmployeeDTO> getList() { // 1.전체사원 출력
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO employeeDTO = null;
		ArrayList<EmployeeDTO> ar = new ArrayList<>();			
	
		try {
			
			con = dbConnect.getConnect();
			String sql = "SELECT * FROM EMPLOYEES";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				
				employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
				employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				employeeDTO.setEmail(rs.getString("EMAIL"));
				employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
				employeeDTO.setLast_name(rs.getString("LAST_NAME"));
				employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
				employeeDTO.setJob_id(rs.getString("JOB_ID"));
				employeeDTO.setSalary(rs.getDouble("SALARY"));		
				employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
				employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
				employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
				
				ar.add(employeeDTO);

			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		} finally {
			
			dbConnect.disConnect(con, st, rs);
			
		}
		
		return ar;
		
	} // getList() 메소드 끝
	
	
	public EmployeeDTO getOne(int employee_id) { //2. 검색사원 출력
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO employeeDTO = null;
		
		try {
			
			con = dbConnect.getConnect();
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, employee_id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				
				employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
				employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				employeeDTO.setEmail(rs.getString("EMAIL"));
				employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
				employeeDTO.setLast_name(rs.getString("LAST_NAME"));
				employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
				employeeDTO.setJob_id(rs.getString("JOB_ID"));
				employeeDTO.setSalary(rs.getDouble("SALARY"));		
				employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
				employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
				employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			
			} else {
				
				System.out.println("== 해당 번호 없음 ==");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} finally {
			
			dbConnect.disConnect(con, st, rs);
		}
		
		
		return employeeDTO;
	
	} // getOne() 메소드 끝
	

	public ArrayList<EmployeeDTO> lastSelect(String last_name) { // 3. Last_Name으로 사원 검색,출력
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO employeeDTO = null;
		ArrayList<EmployeeDTO> ar = new ArrayList<>();
		
		try {
			
			con = dbConnect.getConnect();
			String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE ?";
			st = con.prepareStatement(sql);
			st.setString(1, "%"+last_name+"%");
			rs = st.executeQuery();
			
			while(rs.next()) {
				
				employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
				employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				employeeDTO.setEmail(rs.getString("EMAIL"));
				employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
				employeeDTO.setLast_name(rs.getString("LAST_NAME"));
				employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
				employeeDTO.setJob_id(rs.getString("JOB_ID"));
				employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
				employeeDTO.setSalary(rs.getDouble("SALARY"));				
				employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
				employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
				
				ar.add(employeeDTO);
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			dbConnect.disConnect(con, st, rs);
		}
		
		return ar;
		
		
	} // lastSelect() 메소드 끝
	
	
	public ArrayList<EmployeeDTO> firstSelect(String first_name) { // 4.First_name으로 사원 검색,출력
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO employeeDTO = null;
		ArrayList<EmployeeDTO> ar = new ArrayList<>();
		
		try {
			
			con = dbConnect.getConnect();
			String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE ?";
			st = con.prepareStatement(sql);
			st.setString(1, "%"+first_name+"%");
			rs = st.executeQuery();
			
			while(rs.next()) {
				
				employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
				employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				employeeDTO.setEmail(rs.getString("EMAIL"));
				employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
				employeeDTO.setLast_name(rs.getString("LAST_NAME"));
				employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
				employeeDTO.setJob_id(rs.getString("JOB_ID"));
				employeeDTO.setSalary(rs.getDouble("SALARY"));				
				employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
				employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
				employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
				
				ar.add(employeeDTO);
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			dbConnect.disConnect(con, st, rs);
		}
		
		return ar;
		
	} // firstSelect() 메소드 끝
	
	
	public int entireSal() { // 5. 전체부서 평균급여 출력
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int sa1 = 0;
		
		try {
			
			con = dbConnect.getConnect();
			String sql = "SELECT AVG(SALARY) FROM EMPLOYEES";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			rs.next();
			
			sa1 = rs.getInt("AVG(SALARY)");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sa1;
		
	} // entireSal() 메소드 끝
	
	
	public ArrayList<Double> partSal() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<Double> ar = new ArrayList<>();
		
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT AVG(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT_ID";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				double part = 0;				
				part = rs.getDouble("AVG(SALARY)");

				ar.add(part);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disConnect(con, st, rs);
		}
		
		return ar;
		
	}

	public void getAvg2() { // 선생님이 가르쳐주신거
		//Map도 Collection임. 활용가능
		HashMap<String, Object> obj = new HashMap<>();
		obj.put("id", 20);
		obj.put("avg", 1000.12);
	}
}
