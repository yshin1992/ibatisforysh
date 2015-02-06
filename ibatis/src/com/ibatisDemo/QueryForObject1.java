package com.ibatisDemo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatisBean.City;

public class QueryForObject1
{

	/*
	 * queryForObject(String id,Object parameter) throws SQLException
	 */
	public static void main(String[] args) throws IOException, SQLException
	{
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader( resource );
		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient( reader );
		City city = (City) sqlMap.queryForObject( "getZoneOneRecord", null );
		System.out.println( city );

	}

}
