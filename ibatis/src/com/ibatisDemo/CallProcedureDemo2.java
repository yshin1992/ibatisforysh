package com.ibatisDemo;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class CallProcedureDemo2
{
	// 存储过程如下
	// DELIMITER //
	// create procedure insertStu(IN name varchar(20))
	// begin
	// declare count int default 0;
	// select max(id) into count from student;
	// if count is null then
	// set count=0;
	// end if;
	// set count:=count+1;
	// insert into student values(count,name);
	// end; //
	// DELIMITER ;

	public static void main(String[] args) throws IOException, SQLException
	{
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader( resource );
		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient( reader );
		try
		{
			sqlMap.startTransaction();
			sqlMap.startBatch();
			for ( int i = 1; i < 10; i++ )
			{
				sqlMap.insert( "insertWithProcedure", "student" + i );
			}
			sqlMap.executeBatch();
			sqlMap.commitTransaction();
		}
		finally
		{
			sqlMap.endTransaction();
		}
	}

}
