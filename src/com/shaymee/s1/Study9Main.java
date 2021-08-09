package com.shaymee.s1;

import java.sql.Connection;

import com.shaymee.s1.location.LocationDAO;
import com.shaymee.s1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {
		
		DBConnect dbConnect = new DBConnect();

		LocationDAO locationDAO = new LocationDAO();
		
		locationDAO.getList();

	}

}
