package com.shaymee.s1.location;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	
	private LocationDAO2 locationDAO2;
	private LocationView locationView;
	private LocationInput locationInput;
	private Scanner sc;
	
	public LocationController() { // 생성자를 통해 객체부터 만들어 줌
		locationDAO2 = new LocationDAO2();
		this.locationView = new LocationView();
		locationInput = new LocationInput();
		this.sc = new Scanner(System.in);
	} // DAO와 VIEW의 객체를 만드는 방식 - 결합도가 높은 방식

	
	public void start() {
		
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 전체정보 출력");
			System.out.println("2. 검색정보 출력");
			System.out.println("3. 프로그램 종료");
			
			System.out.println("== 골라보세요 ==");
			int select = sc.nextInt();

			if(select == 1) {
				ArrayList<LocationDTO> ar = locationDAO2.getList();
				if(ar.size()>0) {
					locationView.view(ar);
				} else {
					locationView.view("== 데이터가 없음 ==");
				}
			} else if(select == 2) {				
				LocationDTO locationDTO = locationInput.inputId(sc);
				LocationDTO dto = locationDAO2.getOne(locationDTO);
				
				if(dto != null) {
					locationView.view(dto);
				} else {
					locationView.view("== 존재하지 않는 LOCATION_ID ==");
				}
			} else {	
				System.out.println("=== 프로그램 종료 ===");
				break;
				
			}

			
		}
		

		
	}
	
	
}
