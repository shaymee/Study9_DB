package com.shaymee.s1.employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {

	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	private Scanner sc;
	
	public EmployeeController() {
		
		employeeDAO = new EmployeeDAO();
		employeeView = new EmployeeView();
		sc = new Scanner(System.in);
		
	}
	
	
	public void start() {

		boolean flag = true;
		while(flag) {
			
			System.out.println("1. 전체사원 출력");
			System.out.println("2. 검색사원 출력");
			System.out.println("3. Last_Name 검색 출력");
			System.out.println("4. First_Name 검색 출력");
			System.out.println("5. 전체 평균급여 출력");
			System.out.println("6. 부서별 평균급여 출력");
			System.out.println("7. 프로그램 종료");
			System.out.println("== 번호 선택 ==");
			int select = sc.nextInt();
			
			if(select == 1) {
				
				ArrayList<EmployeeDTO> ar = employeeDAO.getList();
				employeeView.view(ar);
				
			} else if(select == 2) {
				
				System.out.println("== 사원번호 입력 ==");
				int employee_id = sc.nextInt();
				
				EmployeeDTO employee = employeeDAO.getOne(employee_id);
				employeeView.view(employee);
				
			} else if(select == 3) {
				
				System.out.println("== Last_Name 입력 ==");
				String last = sc.next();
				
				ArrayList<EmployeeDTO> ar = employeeDAO.firstSelect(last);
				employeeView.view(ar);

			} else if(select == 4) {
				
				System.out.println("== First_Name 입력 ==");
				String first = sc.next();
				
				ArrayList<EmployeeDTO> ar = employeeDAO.lastSelect(first);
				employeeView.view(ar);
				
			} else if(select ==5) {
				
				int totalAvg = employeeDAO.entireSal();
				employeeView.view(totalAvg);
				
			} else if(select ==6) {
				
				ArrayList<Double> ar = employeeDAO.partSal();
				employeeView.viewPart(ar);				
				
			} else {
	
				System.out.println("== 프로그램을 종료합니다 ==");
				break;
				
			}
			
			
			
		}
		
		
		
		
		
	}
	
	
	
	
}
