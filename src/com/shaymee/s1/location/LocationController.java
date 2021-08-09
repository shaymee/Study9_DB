package com.shaymee.s1.location;

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
// 		locationDAO.getOne();
		
		
		
	}
	
	
	
}
