package com.shaymee.s1.location;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.shaymee.s1.util.DBConnect;

public class LocationDAO { //DataAccessObject 데이터객체에 접근하는 놈
	
	private DBConnect dbConnect;
	
	public LocationDAO() { //생성자를 통해 DBConnect 객체 생성

		dbConnect = new DBConnect();

	}
	
	//getCount()
	//location의 주소 갯수를 리턴 및 출력(23개면 됨)
	
	public int getCount() {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int num = 0;
		
		try {
			
		con = dbConnect.getConnect();
		String sql = "SELECT COUNT(LOCATION_ID) as 주소갯수 FROM LOCATIONS";
		st = con.prepareStatement(sql);
		rs = st.executeQuery();
		
		
		if(rs.next()) {
			
			num = rs.getInt("주소갯수");
						
		}
	
		} catch(Exception e) {
			
			e.printStackTrace();
		
		} finally {
			
			dbConnect.disConnect(con, st, rs);
			
		}
		
		
		return num;

	}
	

	//getSearch()
	//STREET_ADDRESS의 일부를 받아서 검색, 찾은것들을 출력
	
	public ArrayList<LocationDTO> getSearch(String name) {
		
		System.out.println("getSearch메소드 작동");
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO locationDTO = null;
		ArrayList<LocationDTO> ar = new ArrayList<>();
		
		try {
			
			con = dbConnect.getConnect();
			String sql = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE ?";
			st = con.prepareStatement(sql);
			
			st.setString(1, "%"+name+"%");
	
			rs = st.executeQuery();			
			
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
	
	
	
	
	public LocationDTO getOne(int location_id) {		
		
		//ADD-DTO Branch
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO locationDTO = null;
		
		try {
			con = dbConnect.getConnect();
			
			System.out.println("DB 접속 성공");
			
			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, location_id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {//한줄을 읽었을때 데이터가 있을때 true
				locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
				locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
				locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
				locationDTO.setCity(rs.getString("CITY"));
				locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
				locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
				
				// Oracle에서 실제 출력되서 보이는 그대로의 이름이어야 함 Ex) DEPARTMENT_ID as DI 면 rs.getString("DI")로 입력해야됨
				// Java는 ResultSet에서 Data를 가져오는 것. 
			
			} else {
				System.out.println("그런 CITY 없음");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return locationDTO;
	}
	
//	public void getCount() {
//		
//		Connection con = null;
//		PreparedStatement st = null;
//		ResultSet rs = null;
//		
//		try {
//
//			con = dbConnect.getConnect();
//			
//			String sql = "SELECT COUNT(DEPARTMENT_ID) as 부서숫자 FROM DEPARTMENTS";
//			
//			st = con.prepareStatement(sql);
//			rs = st.executeQuery();
//			
//			if(rs.next()) { // rs.next() --> 한줄은 무조건 읽어야함
//				System.out.println(rs.getString("부서숫자"));
//			}
//			
//		
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		} finally {
//			
//			try {
//				rs.close();
//				st.close();
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
		
//	}
	
	
	
	public ArrayList<LocationDTO> getList() {
	
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO locationDTO;
		ArrayList<LocationDTO> ar = new ArrayList<>();
		
		try {
			
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM LOCATIONS";
			
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			
			while(rs.next()) { // rs.next() --> 한줄 읽고 다음 줄로 내려감. 내려가서 한줄이 또 있으면 true. 어쨌든 ResultSet에 있는걸 읽는 메서드임
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
		} finally { //연결된 자원을 해제할 때 finally를 많이 씀. finally는 exception이 있든 없든 무조건 실행됨.
			
			try {	//끊어주는 것은 실행된 것들의 역순으로
				
				rs.close();
				st.close();
				con.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return ar;
	}
	
	
	
}
