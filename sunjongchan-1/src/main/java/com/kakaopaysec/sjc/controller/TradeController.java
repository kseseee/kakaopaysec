package com.kakaopaysec.sjc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kakaopaysec.sjc.exception.BizException;
import com.kakaopaysec.sjc.model.BranchName;
import com.kakaopaysec.sjc.model.Customer;
import com.kakaopaysec.sjc.model.NotTradeCustomer;
import com.kakaopaysec.sjc.service.TradeService;

@Controller
public class TradeController {
	@Autowired
	TradeService tradeService;
	
	@GetMapping("/customer-amt")
	@ResponseBody
	public List<Customer> getCustomerOfYear(){
		return tradeService.searchSumAmtOfCustomer();
	}
	
	@GetMapping("/customer-nottrade")
	@ResponseBody
	public List<NotTradeCustomer> getNotTradeCustomer(){
		return tradeService.searchNotTradeCustomer();
	}
	
	@GetMapping("/branch-rank")
	@ResponseBody
	public List<HashMap<String, Object>> getrankOfBranch(){
		return tradeService.searchRankOfBranch();
	}
	
	@PostMapping("/branchbyname")
	@ResponseBody
	public BranchName getBranchByName(@RequestBody Map<String,String> branchName) {
		BranchName result = tradeService.searchBranchByBranchname(branchName.get("branchName"));
		if(result==null || "분당점".equals(branchName.get("branchName"))) {
			throw new BizException("br code not found error");
		}else {
			return result;
		} 
	}
}