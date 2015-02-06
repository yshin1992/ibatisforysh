package com.ibatisDemo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatisBean.City;

public class QueryForList2
{

	/*
	 * queryForList(String is,Object parameter,int skip,int max) throws SQLException
	 */
	public static void main(String[] args) throws IOException, SQLException
	{
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader( resource );
		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient( reader );
		@SuppressWarnings("unchecked")
		List<City> list = sqlMap.queryForList( "getZone", null, 10, 6 );
		for ( int i = 0; i < list.size(); i++ )
		{
			System.out.println( list.get( i ) );
		}
	}
}
