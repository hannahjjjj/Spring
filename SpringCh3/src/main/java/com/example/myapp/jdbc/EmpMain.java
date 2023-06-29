package com.example.myapp.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config.xml");
		IEmpService empService = context.getBean(IEmpService.class);
		
		System.out.println("사원의 수 조회");
		System.out.println(empService.getEmpCount());
		System.out.println(empService.getEmpCount(50));
		
		System.out.println("103번의 사원의 정보를 조회합니다.");
		System.out.println(empService.getEmpInfo(103));
		
		System.out.println("사원 전체 정보를 조회합니다.");
		System.out.println(empService.getEmpList());
		
		System.out.println("새로운 사원의 정보를 입력합니다");
		EmpVO emp = new EmpVO();
		try {
			emp.setEmployeeId(210);
			emp.setFirstName("hannah");
			emp.setLastName("jo");
			emp.setEmail("wh467925");
			emp.setPhoneNumber("010-9528-3398");
			emp.setJobId("IT_PROG");
			emp.setSalary(8000);
			emp.setCommissionPct(0.2);
			emp.setManagerId(100);
			emp.setDepartmentId(10);
			empService.insertEmp(emp);
			System.out.println("insert OK");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("신규 사원의 정보를 조회/출력합니다");
		EmpVO emp210 = empService.getEmpInfo(210);
		System.out.println(emp210);
		
		System.out.println("210번 사원의 급여를 10% 인상");
		emp210.setSalary(emp210.getSalary()*1.1);
		System.out.println(emp210);
		
		System.out.println("수정된 사원의 정보를 조회/출력");
		emp210 = empService.getEmpInfo(210);
		System.out.println(emp210);
		
		System.out.println("210번 사원의 정보를 삭제");
		empService.deleteEmp(210, "wh467925");
		
		System.out.println("모든 부서번호와 부서이름 정보를 출력합니다.");
		System.out.println(empService.getAllDeptId());
		
		System.out.println("모든 직무아이디와 직무타이틀을 출력합니다.");
		System.out.println(empService.getAllJobId());
		
		System.out.println("모든 매니저번호와 매니저이름을 출력합니다.");
		System.out.println(empService.getAllManagerId());
		
		List<Map<String,Object>> deptInfo = empService.getAllDeptId();
		for(Map<String, Object> deptId : deptInfo) {
			System.out.println(deptId.get("DEPARTMENTID"));
			System.out.println(deptId.get("DEPARTMENTNAME"));
		}
	}
}
