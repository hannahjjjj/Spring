package com.example.myapp.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.myapp.jdbc.EmpVO;
import com.example.myapp.jdbc.IEmpService;

@Controller
@RequestMapping("/hr")
public class EmpController {
	
	@Autowired
	IEmpService empService;
	
	@RequestMapping("/count")
	public String empCount(@RequestParam(value="deptid" , required = false, defaultValue="0") int deptid, Model model) {
		int result = 0;
		if(deptid==0) {
			result = empService.getEmpCount(); //biz()실행
		}else {
			result = empService.getEmpCount(deptid);
		}
		model.addAttribute("count",result); //결과를 model에 저장 
		return "/hr/count"; // view로 리턴 WEB-INF/views/hr/count.jsp파일
	}
	
	@RequestMapping("/list") 	
	public String getAllEmps(Model model) {
		List<EmpVO> empList = empService.getEmpList();
		model.addAttribute("empList", empList);
		return "/hr/list";
	}

	@RequestMapping("/{employeeId}")
	public String getEmpInfo(@PathVariable int employeeId, Model model) {
		EmpVO emp = empService.getEmpInfo(employeeId);
		model.addAttribute("emp",emp);
		return "/hr/view";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insertEmp(Model model) {
		model.addAttribute("deptList", empService.getAllDeptId());
		model.addAttribute("jobList", empService.getAllJobId());
		model.addAttribute("managerList", empService.getAllManagerId());
		return "/hr/insertform";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertEmp(EmpVO emp, RedirectAttributes redirectAttributes) {
		try {
			empService.insertEmp(emp);			
			redirectAttributes.addFlashAttribute("message",emp.getEmployeeId()+"번 사원정보가 입력되었습니다");
		}catch(RuntimeException e) {
			redirectAttributes.addFlashAttribute("message",e.getMessage());
		}
		return "redirect:/hr/list";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String updateEmp(int empid, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empid));
		model.addAttribute("deptList",empService.getAllDeptId());
		model.addAttribute("jobList", empService.getAllJobId());
		model.addAttribute("managerList", empService.getAllManagerId());
		return "/hr/updateform";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateEmp(EmpVO emp, RedirectAttributes redirectAttributes) {
		try {
			empService.updateEmp(emp);			
			redirectAttributes.addFlashAttribute("message",emp.getEmployeeId()+"번 사원정보가 수정되었습니다");
		}catch(RuntimeException e) {
			redirectAttributes.addFlashAttribute("message",e.getMessage());
		}
		return "redirect:/hr/"+emp.getEmployeeId();
	}
	
	   @RequestMapping(value="/delete", method=RequestMethod.GET)
	   public String deleteEmp(int empid, Model model) {
	      model.addAttribute("emp", empService.getEmpInfo(empid));
	      return "/hr/deleteform";
	   }
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteEmp(int empid,String email, Model model, RedirectAttributes redirectAttrs) {
		try {
			int deleteRow = empService.deleteEmp(empid, email);
			if(deleteRow > 0) {
				redirectAttrs.addFlashAttribute("message", "번 사원정보가 삭제되었습니다.");
				return "redirect:/hr/list";
			}else {
				model.addAttribute("message", "ID또는 Email이 다릅니다");
				model.addAttribute("emp", empService.getEmpInfo(empid));
				return "hr/deleteform";
			}
		}catch(RuntimeException e) {
			redirectAttrs.addFlashAttribute("message", e.getMessage());
			return "redirect:/hr/list";
		}
	}
	
	@ExceptionHandler({RuntimeException.class})
	public String runtimeException(HttpServletRequest request, Exception ex, Model model) {
		model.addAttribute("url", request.getRequestURI());
		model.addAttribute("exception", ex);
		return "/error/runtime";
	}

}
