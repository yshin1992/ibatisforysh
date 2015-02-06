package com.ibatisDemo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatisBean.City;

public class XMLParameterDemo
{

	/*
	 * 使用类似xml的字符串作为参数。例如:<parameter><cityCode>12</cityCode></parameter>
	 */
	public static void main(String[] args) throws IOException, SQLException, ParserConfigurationException
	{
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader( resource );
		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient( reader );
		City city = new City();
		String xml = "<parameter><cityCode>12</cityCode><cityName>徐州</cityName></parameter>";
		sqlMap.queryForObject( "selectWithXML", xml, city );
		System.out.println( city );
	}

}
