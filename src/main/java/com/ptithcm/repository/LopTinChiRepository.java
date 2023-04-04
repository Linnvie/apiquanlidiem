package com.ptithcm.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ptithcm.entity.LopTinChiEntity;

public interface LopTinChiRepository extends JpaRepository<LopTinChiEntity, String>{
	public Optional<Page<LopTinChiEntity>> findAllByMaMon(String maMon, Pageable pageable);
	public Optional<Page<LopTinChiEntity>> findAllByMaMonAndHocKiAndNam(String maMon, int hocKi, int nam,Pageable pageable);
	public Optional<LopTinChiEntity> findOneByMaLopTinChi(String maLTC);
}
