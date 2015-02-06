package com.ibatisDemo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class CallProcedureDemo
{
	// 存储过程如下
	// DELIMITER $$
	// create procedure countRecord()
	// begin
	// select max(cityCode) from cities;
	// end $$ DELIMITER ;

	public static void main(String[] args) throws IOException, SQLException
	{
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader( resource );
		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient( reader );
		int recordCount = (int) sqlMap.queryForObject( "selectWithProcedure", null );
		System.out.println( recordCount );
	}

}
