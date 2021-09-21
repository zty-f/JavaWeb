package com.zty.dao.provider;


import com.zty.pojo.Provider;

import java.sql.Connection;
import java.util.List;

public interface ProviderDao {
	

	public int add(Connection connection, Provider provider)throws Exception;



	public List<Provider> getProviderList(Connection connection, String proName, String proCode , int currentPageNo, int pageSize)throws Exception;
	

	public int deleteProviderById(Connection connection, String delId)throws Exception;
	

	public Provider getProviderById(Connection connection, String id)throws Exception;
	

	public int modify(Connection connection, Provider provider)throws Exception;
	
	
}
