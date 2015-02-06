package com.ibatisDemo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SelectWithIterateDemo
{

	public static void main(String[] args) throws IOException, SQLException
	{
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader( resource );
		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient( reader );
		List<Integer> sqllist = Arrays.asList( 12, 13, 15 );
		List<?> list = sqlMap.queryForList( "ch8.selectWithIterate", sqllist );
		for ( int i = 0; i < list.size(); i++ )
		{
			System.out.println( list.get( i ) );
		}
		// sqlMap.queryForPaginatedList( arg0, arg1, arg2 )
	}
}
