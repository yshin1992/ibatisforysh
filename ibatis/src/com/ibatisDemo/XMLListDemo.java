package com.ibatisDemo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatis.sqlmap.client.event.RowHandler;
import com.ibatisBean.City;

class XMLListDemo
{

	public static void main(String[] args) throws IOException, SQLException
	{
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader( resource );
		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient( reader );
		CityXmlRowHandler roll = new CityXmlRowHandler();
		sqlMap.queryWithRowHandler( "getZone", null, roll );
		String str = roll.getCityList();
		System.out.println( str );
	}

}

class CityXmlRowHandler implements RowHandler
{
	private StringBuffer xmlDoc = new StringBuffer( "<CityList>" );


	@Override
	public void handleRow(Object o)
	{
		if (o instanceof City)
		{
			City city = (City) o;
			xmlDoc.append( "<City>" );
			xmlDoc.append( "<cityCode>" ).append( city.getCityCode() ).append( "</cityCode>" ).append( "<cityName>" ).append( city.getCityName() ).append( "</cityName>" ).append( "<parentCode>" ).append( city.getParentCode() ).append( "</parentCode>" );
			xmlDoc.append( "</City>" );
		}
	}


	public String getCityList()
	{
		xmlDoc.append( "</CityList>" );
		return xmlDoc.toString();
	}

}
