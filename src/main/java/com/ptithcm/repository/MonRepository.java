package com.ptithcm.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ptithcm.entity.MonEntity;

public interface MonRepository  extends JpaRepository<MonEntity, String>{
	public Optional<MonEntity> findOneByMaMon(String maMon);
//	public MonEntity update(MonEntity mon);
	public Page<MonEntity> findByMaMonContaining(String maMon, Pageable pageable);
}
