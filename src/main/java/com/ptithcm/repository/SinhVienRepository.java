package com.ptithcm.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ptithcm.dto.TTSinhVienDto;
import com.ptithcm.entity.SinhVienEntity;

public interface SinhVienRepository extends JpaRepository<SinhVienEntity, String>{
	Optional<SinhVienEntity> findOneByMssv(String mssv);
	public Optional<Page<SinhVienEntity>> findAllByMaLop(String maLop, Pageable pageable);
	
	@Query(value = "SELECT  sinhvien.mssv, bangdiemchitiet.ma_ltc, ho_lot, ten,gioi_tinh,ngay_sinh,ma_lop,diem_he_1, diem_he_2,diem_he_3,lan " + 
			"FROM bangdiemchitiet INNER JOIN sinhvien " + 
			"ON bangdiemchitiet.mssv=sinhvien.mssv " + 
			"WHERE ma_ltc = :maLTC order by rand() /*#pageable*/",
			countQuery="SELECT COUNT(*) "+
					"FROM bangdiemchitiet INNER JOIN sinhvien " + 
					"ON bangdiemchitiet.mssv=sinhvien.mssv " + 
					"WHERE ma_ltc = :maLTC ",
			nativeQuery = true)
	Optional<Page<TTSinhVienDto>> findAllByMaLTC(@Param("maLTC") String maLTC, Pageable pageable);
	
}
