package com.example.myapp.jdbc;

import java.util.List;
import java.util.Map;

public interface IEmpRepository {
	public int getEmpCount();
	public int getEmpCount(int deptid);
	public List<EmpVO> getEmpList();
	public EmpVO getEmpInfo(int empid);
	public void updateEmp(EmpVO emp);
	public void insertEmp(EmpVO emp);
	public void deleteJobHistory(int empid);
	public int deleteEmp(int empid, String email);
	public List<Map<String, Object>> getAllJobId();
	public List<Map<String, Object>> getAllManagerId();
	public List<Map<String, Object>> getAllDeptId();
}
