package com.zty.service.provider;

import com.zty.pojo.Provider;

import java.util.List;

public interface ProviderService {

	public boolean add(Provider provider);


	public List<Provider> getProviderList(String proName, String proCode, int currentPageNo, int pageSize);

	public int deleteProviderById(String delId);
	

	public Provider getProviderById(String id);
	

	public boolean modify(Provider provider);
	
}
