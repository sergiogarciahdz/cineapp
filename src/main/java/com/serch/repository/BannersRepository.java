package com.serch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serch.model.Banner;

@Repository
public interface BannersRepository extends JpaRepository<Banner, Integer>{

}
