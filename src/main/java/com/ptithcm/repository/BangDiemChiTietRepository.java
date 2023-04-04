package com.ptithcm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ptithcm.dto.TTBangDiemDto;
import com.ptithcm.entity.BangDiemChiTietEntity;
import com.ptithcm.entity.BangDiemChiTietKey;

public interface BangDiemChiTietRepository extends JpaRepository<BangDiemChiTietEntity, BangDiemChiTietKey> {
//	public Optional<Page<SinhVienEntity>> findAllByMaLTC(String maLop, Pageable pageable);
	public Optional<BangDiemChiTietEntity> findOneById(BangDiemChiTietKey key);
	
	@Query(value = "SELECT * FROM view_bang_diem_tb WHERE mssv =:mssv ORDER BY nam, hoc_ki",		
			nativeQuery = true)
	Optional<List<TTBangDiemDto>> findAllByMSSV(@Param("mssv") String mssv);
	
	@Query(value = "SELECT * FROM view_bang_diem_tb WHERE mssv =:mssv AND hoc_ki=:hocKi AND nam=:nam",		
			nativeQuery = true)
	Optional<List<TTBangDiemDto>> findAllByMSSVAndHocKiAndNam(@Param("mssv") String mssv,@Param("hocKi") int hocKi, @Param("nam")int Nam);
}
