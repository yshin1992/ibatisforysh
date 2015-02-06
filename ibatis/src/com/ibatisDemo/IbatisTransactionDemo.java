package com.ibatisDemo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatisBean.City;

public class IbatisTransactionDemo
{

	/*
	 * batis开启事务
	 */
	public static void main(String[] args) throws IOException, SQLException
	{
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader( resource );
		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient( reader );
		sqlMap.startTransaction();
		try
		{
			List<?> list = sqlMap.queryForList( "selectForTransation", "马鞍山" );
			sqlMap.startBatch();
			for ( Iterator<?> it = list.iterator(); it.hasNext(); )
			{
				sqlMap.delete( "deleteForTransaction", (int) it.next() );
			}
			sqlMap.executeBatch();
			City city = new City();
			city.setCityName( "马鞍山" );
			city.setParentCode( 1 );
			sqlMap.insert( "insertWithExtMap", 1 );

			List<City> resList = sqlMap.queryForList( "getZone", null );
			for ( Iterator<City> it = resList.iterator(); it.hasNext(); )
			{
				System.out.println( it.next() );
			}
			sqlMap.commitTransaction();
		}
		finally
		{
			sqlMap.endTransaction();
		}
	}
}
