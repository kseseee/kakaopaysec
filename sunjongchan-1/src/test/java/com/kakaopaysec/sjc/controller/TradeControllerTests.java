package com.kakaopaysec.sjc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kakaopaysec.sjc.service.TradeService;

@SpringBootTest
public class TradeControllerTests {
	@Autowired
	TradeService tradeService;
	@Test
	public void testGetrankOfBranch(){
		List<HashMap<String, Object>> result = tradeService.searchRankOfBranch();
		assertEquals(3, result.size());
		assertEquals(4, ((List<HashMap<String, Object>>)result.get(0).get("dataList")).size());
		assertEquals(4, ((List<HashMap<String, Object>>)result.get(1).get("dataList")).size());
		assertEquals(1, ((List<HashMap<String, Object>>)result.get(2).get("dataList")).size());
		assertEquals(2019, result.get(1).get("year"));
		assertEquals("분당점", ((List<HashMap<String, Object>>)result.get(1).get("dataList")).get(1).get("brName"));
		
	}
}
