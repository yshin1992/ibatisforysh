package com.ibatisDemo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatisBean.City;

public class QueryForMap1
{

	/*
	 * queryForMap(String id,Object parameter,String key) throws SQLException 其中key为Bean的一个属性
	 */
	public static void main(String[] args) throws IOException, SQLException
	{
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader( resource );
		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient( reader );
		Map<Integer, City> map = sqlMap.queryForMap( "getZone", null, "cityCode" );
		Set set = map.entrySet();
		for ( Iterator<City> it = set.iterator(); it.hasNext(); )
		{
			Entry entry = (Entry) it.next();
			System.out.println( entry.getKey() + " : " + entry.getValue() );
		}
	}
}
