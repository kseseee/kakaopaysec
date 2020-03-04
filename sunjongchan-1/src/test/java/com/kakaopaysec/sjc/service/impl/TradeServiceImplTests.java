package com.kakaopaysec.sjc.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.kakaopaysec.sjc.dao.TradeDao;
import com.kakaopaysec.sjc.model.Branch;
import com.kakaopaysec.sjc.model.BranchName;
import com.kakaopaysec.sjc.model.Customer;
import com.kakaopaysec.sjc.model.NotTradeCustomer;

@SpringBootTest
public class TradeServiceImplTests {
	@Autowired
	private TradeDao tradeDao;
	
	@Test
	public void testSelectSumamtOfCustomer() {
		List<Customer> returned = tradeDao.selectSumAmtOfCustomer();
		assertEquals("테드",returned.get(0).getName());
		assertEquals("리노",returned.get(1).getName());
		assertEquals(28992000, returned.get(0).getSumAmt());
		assertEquals(84692000, returned.get(1).getSumAmt());
	}
	
	@Test
	public void testSelectNotTradeCustomer() {
		List<NotTradeCustomer> returned = tradeDao.selectNotTradeCustomer();
		assertEquals(6,returned.size());
		assertEquals(2018,returned.get(0).getYear());
		assertEquals("사라",returned.get(0).getName());
		assertEquals(11111115,returned.get(0).getAcctNo());
		assertEquals(2019,returned.get(5).getYear());
		assertEquals("에이스",returned.get(5).getName());
		assertEquals(11111121,returned.get(5).getAcctNo());
	}
	
	@Test
	public void testParsingSelectRankOfBranch() {
		List<Branch> branchList = new ArrayList<Branch>();
		branchList.add(new Branch(2018, "A", "A-1", 1));
		branchList.add(new Branch(2018, "B", "B-1", 1));
		branchList.add(new Branch(2018, "C", "C-1", 1));
		branchList.add(new Branch(2019, "E", "E-1", 1));
		branchList.add(new Branch(2019, "F", "F-1", 1));
		branchList.add(new Branch(2019, "G", "G-1", 1));
		branchList.add(new Branch(2019, "H", "H-1", 1));
		
		
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
					resultPutData.put("dataList", data_list);
					data_list = new ArrayList<HashMap<String, Object>>();
					result.add((HashMap<String, Object>) resultPutData);
					resultPutData = new HashMap<String, Object>();
				}else { //같을 경우에는 위에걸 안탔을거니까 
					resultPutData.put("year", branchList.get(i-1).getYear());
					resultPutData.put("dataList", data_list);
					data_list = new ArrayList<HashMap<String, Object>>();
					result.add((HashMap<String, Object>) resultPutData);
					resultPutData = new HashMap<String, Object>();
				}
			}
		}
		assertEquals(2, result.size());
		assertEquals(3, ((List<HashMap<String, Object>>)result.get(0).get("dataList")).size());
		assertEquals(4, ((List<HashMap<String, Object>>)result.get(1).get("dataList")).size());
	}
	
	@Test
	public void testSelectBranchBybranchName() {
		String brName="판교점";
		BranchName returned = tradeDao.selectBranchBybranchName(brName);
		assertEquals(brName, returned.getBrName());
		assertEquals("A", returned.getBrCode());
		assertEquals(221110000,returned.getSumAmt());
	}
}
