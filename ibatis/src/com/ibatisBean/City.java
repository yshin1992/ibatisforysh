package com.ibatisBean;

public class City
{
	private String cityName;

	private int cityCode;

	private int parentCode;


	public String getCityName()
	{
		return cityName;
	}


	public int getCityCode()
	{
		return cityCode;
	}


	public int getParentCode()
	{
		return parentCode;
	}


	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}


	public void setCityCode(int cityCode)
	{
		this.cityCode = cityCode;
	}


	public void setParentCode(int parentCode)
	{
		this.parentCode = parentCode;
	}


	@Override
	public String toString()
	{
		return "CityName=" + cityName + "/CityCode=" + cityCode + "/parentCode=" + parentCode;
	}
}
