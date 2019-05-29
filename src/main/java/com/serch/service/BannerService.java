package com.serch.service;

import java.util.List;

import com.serch.model.Banner;

public interface BannerService {
	
	public List<Banner> all();

	public void insert(Banner banner);
	
	public Banner findById(int id);
	
	public void delete(int id);
	
}
