package com.kakaopaysec.sjc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kakaopaysec.sjc.model.Branch;
import com.kakaopaysec.sjc.model.BranchName;
import com.kakaopaysec.sjc.model.Customer;
import com.kakaopaysec.sjc.model.NotTradeCustomer;

@Repository
public class TradeDao {
	@Autowired
	private SqlSession sqlSession; 
	
	public List<Customer> selectSumAmtOfCustomer() {
		// TODO Auto-generated method stub
		List<Customer> listOfCustomer =sqlSession.selectList("com.kakaopaysec.sjc.dao.TradeDao.selectsumOfYearCustomer");
		return listOfCustomer;
	}

	public List<NotTradeCustomer> selectNotTradeCustomer() {
		// TODO Auto-generated method stub
		List<NotTradeCustomer> listOfCustomer =sqlSession.selectList("com.kakaopaysec.sjc.dao.TradeDao.selectNotTradeCustomer");
		return listOfCustomer;
	}
	
	public List<Branch> selectRankOfBranch() {
		// TODO Auto-generated method stub
		List<Branch> listOfBranch =sqlSession.selectList("com.kakaopaysec.sjc.dao.TradeDao.selectRankOfBranch");
		return listOfBranch;
	}
	
	public BranchName selectBranchBybranchName(String BranchName) {
		// TODO Auto-generated method stub
		BranchName branch =sqlSession.selectOne("com.kakaopaysec.sjc.dao.TradeDao.selectBranchBybranchName",BranchName);
		return branch;
	}
}
