package com.kakaopaysec.sjc.jdbccon;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class JdbcTests {
	@Autowired
	private SqlSession sqlSession; 
	@Test
	public void testJdbcTemplate() {
		try(Connection con = sqlSession.getConnection()){
            System.out.println("★★★★★★★★★★★");
			System.out.println(con);
			System.out.println("★★★★★★★★★★★");
        }catch(Exception e){
            e.printStackTrace();
        }
	}
}