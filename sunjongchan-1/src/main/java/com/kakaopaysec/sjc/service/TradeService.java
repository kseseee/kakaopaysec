
package com.kakaopaysec.sjc.service;

import java.util.HashMap;
import java.util.List;

import com.kakaopaysec.sjc.model.BranchName;
import com.kakaopaysec.sjc.model.Customer;
import com.kakaopaysec.sjc.model.NotTradeCustomer;

public interface TradeService {
	List<Customer> searchSumAmtOfCustomer();
	List<NotTradeCustomer> searchNotTradeCustomer();
	List<HashMap<String, Object>> searchRankOfBranch();
	BranchName searchBranchByBranchname(String branchName);
}