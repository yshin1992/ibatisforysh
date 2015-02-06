package com.ibatisDemo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatisBean.City;

public class InsertWithKeyDemo
{

	/*
	 * 插入数据的同时，返回插入的自增的主键
	 */
	public static void main(String[] args) throws IOException, SQLException
	{
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader( resource );
		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient( reader );
		City city = new City();
		city.setCityName( "马鞍山" );
		city.setParentCode( 1 );
		int key = (Integer) sqlMap.insert( "insertWithKey", city );
		System.out.println( key );

	}

}
