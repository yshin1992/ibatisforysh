package com.ibatisDemo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class DynamicTag2SQLDemo
{
	/*
	 * 使用二元标签动态查询
	 */
	public static void main(String[] args) throws IOException, SQLException
	{
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader( resource );
		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient( reader );
		List<?> list = sqlMap.queryForList( "ch8.selctWithTag2", 13 );
		for ( Iterator<?> it = list.iterator(); it.hasNext(); )
			System.out.println( it.next() );
	}
}
