package com.shaymee.s1.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shaymee.s1.util.DBConnect;

public class LocationDAO2 {

	private DBConnect dbConnect;
	
	public LocationDAO2() {		
		dbConnect = new DBConnect();
	}
	
	
	public int setDelete(LocationDTO locationDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;		
		
		try {
			con = dbConnect.getConnect();
			String sql = "DELETE LOCATIONS WHERE LOCATION_ID = ?";
			
			st = con.prepareStatement(sql);
			st.setInt(1, locationDTO.getLocation_id());
			System.out.println(locationDTO.getLocation_id());
			
			result = st.executeUpdate();
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return result;
		
	}
	
	public int setInsert(LocationDTO locationDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
				
		try {
			con = dbConnect.getConnect();
			String sql = "INSERT INTO LOCATIONS "
					+ " values (?, ?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			
			st.setInt(1, locationDTO.getLocation_id());
			st.setString(2, locationDTO.getStreet_address());
			st.setString(3, locationDTO.getPostal_code());
			st.setString(4, locationDTO.getCity());
			st.setString(5, locationDTO.getState_province());
			st.setString(6, locationDTO.getCountry_id());
			
			result = st.executeUpdate();

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	
	
	public ArrayList<LocationDTO> getList() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO locationDTO = null;
		ArrayList<LocationDTO> ar = null;
		
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT * FROM LOCATIONS ORDER BY LOCATION_ID ASC";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			ar = new ArrayList<LocationDTO>();
			
			while(rs.next()) {
				locationDTO = new LocationDTO();
				
				locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
				locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
				locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
				locationDTO.setCity(rs.getString("CITY"));
				locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
				locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));				
				
				ar.add(locationDTO);	
			}
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disConnect(con, st, rs);		
		}
		
		return ar;
		
		
	}
	
	public LocationDTO getOne(LocationDTO locationDTO) { // **웬만하면 DTO의 멤버변수가 매개변수라면 해당 DTO를 매개변수로 설정해라!
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO result = null; 
		
		try {
			con = dbConnect.getConnect();
			System.out.println(con+"\r\n연결 성공");
			String sql = "SELECT * "
					+ " FROM LOCATIONS "
					+ " WHERE LOCATION_ID = ?";
			
			st = con.prepareStatement(sql);
			st.setInt(1, locationDTO.getLocation_id());
			
			rs = st.executeQuery(); // 최종전송 후 처리한 결과값을 ResultSet rs쿤이 받음
			
			if(rs.next()) {
				result = new LocationDTO(); //   ----> **매개변수에 있는 locationDTO 재활용 가능!
				result.setLocation_id(rs.getInt("LOCATION_ID")); // 이제는 넣어줘야 함(재활용이 아니니까)
				result.setStreet_address(rs.getString("STREET_ADDRESS"));
				result.setPostal_code(rs.getString("POSTAL_CODE"));
				result.setCity(rs.getString("CITY"));
				result.setState_province(rs.getString("STATE_PROVINCE"));
				result.setCountry_id(rs.getString("COUNTRY_ID"));				
				
				// 출력 결과 : NULL이면 DB 조회한 것이고 NULL이 아니면 DB 조회한 것!
			} else {
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disConnect(con, st, rs);			
		}
		
		return result;		

	}
	
	
	
	
}
