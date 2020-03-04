package com.kakaopaysec.sjc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakaopaysec.sjc.dao.TradeDao;
import com.kakaopaysec.sjc.model.Branch;
import com.kakaopaysec.sjc.model.BranchName;
import com.kakaopaysec.sjc.model.Customer;
import com.kakaopaysec.sjc.model.NotTradeCustomer;
import com.kakaopaysec.sjc.service.TradeService;

@Service
public class TradeServiceImpl implements TradeService{
	@Autowired
	private TradeDao tradeDao;

	@Override
	public List<Customer> searchSumAmtOfCustomer() {
		// TODO Auto-generated method stub
		return tradeDao.selectSumAmtOfCustomer();
	}

	@Override
	public List<NotTradeCustomer> searchNotTradeCustomer() {
		// TODO Auto-generated method stub
		return tradeDao.selectNotTradeCustomer();
	}
	
	@Override
	public List<HashMap<String, Object>> searchRankOfBranch() {
		// TODO Auto-generated method stub
		List<Branch> branchList = tradeDao.selectRankOfBranch();
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>(); 
		List<HashMap<String, Object>> data_list = new ArrayList<HashMap<String, Object>>();
		Map<String, Object> resultPutData = new HashMap<String, Object>();
		Map<String, Object> data_listPutData = new HashMap<String, Object>();
		int year1 = 0;
		int year2 =0;
		
		for(int i=0;i<branchList.size();i++) {
			Branch branchInfo = branchList.get(i);
			if(i>0) {
				year1 = branchList.get(i-1).getYear();
				year2 =branchList.get(i).getYear();
				if(year1!=year2) {
					resultPutData.put("year", branchList.get(i-1).getYear());
					resultPutData.put("dataList", data_list);
					data_list = new ArrayList<HashMap<String, Object>>();
					result.add((HashMap<String, Object>) resultPutData);
					resultPutData = new HashMap<String, Object>();
				}
			}
			data_listPutData.put("brName",branchInfo.getBrName());
			data_listPutData.put("brCode",branchInfo.getBrCode());
			data_listPutData.put("sumAmt",branchInfo.getSumAmt());
			data_list.add((HashMap<String, Object>) data_listPutData);
			data_listPutData = new HashMap<String, Object>();
			
			if(i==branchList.size()-1) {	//결국 마지막일때 위에서 넣지 못했던 것 그냥 넣고
				if(year1!=year2) {
					resultPutData.put("year", branchList.get(i).getYear());
				}else { //같을 경우에는 위에걸 안탔을거니까 
					resultPutData.put("year", branchList.get(i-1).getYear());
				}
				resultPutData.put("dataList", data_list);
				data_list = new ArrayList<HashMap<String, Object>>();
				result.add((HashMap<String, Object>) resultPutData);
				resultPutData = new HashMap<String, Object>();
			}
		}
		return result;
	}

	@Override
	public BranchName searchBranchByBranchname(String branchName) {
		// TODO Auto-generated method stub
		BranchName result = tradeDao.selectBranchBybranchName(branchName);
		if("판교점".equals(branchName)) {
			int pankyo = result.getSumAmt();
			result.setSumAmt(pankyo+ tradeDao.selectBranchBybranchName("분당점").getSumAmt());
		}
		return result;
	}
}