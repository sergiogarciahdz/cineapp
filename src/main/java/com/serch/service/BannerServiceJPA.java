package com.serch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serch.model.Banner;
import com.serch.repository.BannersRepository;

@Service
public class BannerServiceJPA implements BannerService{
	
	@Autowired
	private BannersRepository bannersRepository;

	@Override
	public List<Banner> all() {
		return bannersRepository.findAll();
	}

	@Override
	public void insert(Banner banner) {
		bannersRepository.save(banner);
	}

	@Override
	public Banner findById(int id) {
		Optional<Banner> banner = bannersRepository.findById(id);
		if (banner.isPresent()) {
			return banner.get();
		}else{
			return null;
		}
	}

	@Override
	public void delete(int id) {
		bannersRepository.deleteById(id);
	}

}
