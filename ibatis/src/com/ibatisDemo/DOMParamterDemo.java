package com.ibatisDemo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatisBean.City;

public class DOMParamterDemo
{

	// 使用DOM作为参数
	public static void main(String[] args) throws ParserConfigurationException, IOException, SQLException
	{
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader( resource );
		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient( reader );
		// 创建DOM
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element elem = doc.createElement( "parameter" );
		Element cityElem = doc.createElement( "cityCode" );
		cityElem.setTextContent( "12" );
		Element nameElem = doc.createElement( "cityName" );
		nameElem.setTextContent( "徐州" );
		cityElem.appendChild( nameElem );
		elem.appendChild( cityElem );
		doc.appendChild( elem );
		City city = new City();
		sqlMap.queryForObject( "selectWithDOM", doc, city );
		System.out.println( city );

	}

}
