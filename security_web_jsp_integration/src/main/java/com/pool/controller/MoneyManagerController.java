package com.pool.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pool.model.Expenditure;
import com.pool.service.ExpenditureService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Controller
@RequestMapping("/mymoney")
public class MoneyManagerController {
	
	private static final Logger logger=LogManager.getLogger(MoneyManagerController.class);
	
	@Autowired
	private ExpenditureService expenditureService;
	
	@GetMapping("/")
	public String moneyManagerHomePage() {
		Object principasal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 System.out.println("asd");
		if(principasal instanceof UserDetails) {
			 System.out.println("asd");
			 System.out.println(((UserDetails) principasal).getUsername());
			 System.out.println(((UserDetails) principasal).getPassword());
		}
	
		return "MyMoney";
	}
	
	@PostMapping("/saveexpenditure")
	@ResponseBody
	public ResponseEntity<List<Expenditure>> saveExpenduture(@RequestBody Expenditure expenditure,HttpServletRequest request) {
		// THIS IS USED TO ADD ITEMS TO SESSION
		HttpSession session=request.getSession();
		List<String> itemNamesList=new ArrayList<>();
		String name=request.getParameter("name");
		
		//GET THE Already saved list from session ADDING TO list
		List<String> savedItemNames=(List<String>) request.getSession().getAttribute("namesList");
		itemNamesList.add(name);
		if(savedItemNames.size()>0) {
			itemNamesList.addAll(savedItemNames);	
		}
		
		session.setAttribute("namesList", itemNamesList);
		
		// THIS USED TO GET ITEMS FROM SESSION
		
		List<String> vartItemNames=(List<String>) request.getSession().getAttribute("namesList");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		logger.trace("Application trace is started");
		logger.info("Save Expenditure Fn has started  ");
		logger.debug("expenditure object->{}", expenditure);
		Expenditure SavedExpenditure =expenditureService.saveExpenditure(expenditure);
		logger.info("Expenditure Record is saved");
		logger.warn("Your Expenditure is too high--->{}",SavedExpenditure.getTypeOfExpence());
		if(SavedExpenditure.getUserId()==508) {
			logger.error("Error on saving Expenditure--->{}",SavedExpenditure);
		}
		List<Expenditure> exslist=expenditureService.getAllExpenditure();
		return new ResponseEntity<List<Expenditure>>(exslist,HttpStatus.OK);
	}
	@GetMapping("/allexpenditures")
	@ResponseBody
	public List<Expenditure> allExpenditures(){
		return expenditureService.getAllExpenditure();
	}
	@GetMapping("/expenditure/{userId}")
	@ResponseBody
	public List<Expenditure> findByUserId(@PathVariable("userId")Integer userId){
		return expenditureService.findByUserId(userId);
	}
	@DeleteMapping("/deleteExpediturebyid/{expenditureId}/{userId}")
	@ResponseBody
	public List<Expenditure> deleteExpenditure(@PathVariable("expenditureId") Integer expenditureId,@PathVariable("userId") Integer userId){
		expenditureService.deleteByExpenditureId(expenditureId);
		return expenditureService.findByUserId(userId);
	}
}
