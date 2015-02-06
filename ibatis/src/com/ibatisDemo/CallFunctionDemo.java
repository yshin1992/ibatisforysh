package com.ibatisDemo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class CallFunctionDemo
{
	/*
	 * 函数如下：
	 */
	// DELIMITER $$
	// create function minSample(a int, b int) returns int
	// begin
	// if a>b then return a;
	// else return b;
	// end if;
	// end $$ DELIMITER ;

	public static void main(String[] args) throws IOException, SQLException
	{
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader( resource );
		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient( reader );
		Map map = new HashMap();
		map.put( "a", 1 );
		map.put( "b", 2 );
		int min = (int) sqlMap.queryForObject( "selectWithFunction", map );
		System.out.println( min );
	}

}
