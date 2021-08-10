package com.shaymee.s1.location;

import java.util.ArrayList;

public class LocationController {
	
	private LocationDAO locationDAO;
	private LocationView locationView;
	
	public LocationController() { // 생성자를 통해 객체부터 만들어 줌
		locationDAO = new LocationDAO();
		locationView = new LocationView();
	}

	public void start() {
		
//		locationDAO.getList();
//		locationView.view();
		
// 		LocationDTO locationDTO = locationDAO.getOne(1000);
//		locationView.view(locationDTO);
		
//		ArrayList<LocationDTO> ar = locationDAO.getList();
//		locationView.view(ar);		
		
//		ArrayList<LocationDTO> ar = locationDAO.getSearch("Vi");
//		locationView.view(ar);
		
		int num = locationDAO.getCount();
		locationView.view(num);
		
	}
	
	
	
}
