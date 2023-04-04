package com.ptithcm.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ptithcm.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, String>{
//	
	@Query(value = "CALL sp_get_all_account()", nativeQuery = true)
    List<AccountEntity> getAll();
	
	@Query(value = "CALL `SP_SAVE_ACCOUNT` (:username, :password,:status, :maQuyen, :maNV, :ho, :ten, :diaChi, :ngaySinh, :gioiTinh, :laQL)", nativeQuery = true)
    AccountEntity saveAccount(@Param("username") String username, @Param("password") String password,
    		@Param("status") Boolean status, @Param("maQuyen") String maQuyen,
    		@Param("maNV") String maNV, @Param("ho") String ho,
    		@Param("ten") String ten, @Param("diaChi") String diaChi,
    		@Param("ngaySinh") Date ngaySinh, @Param("gioiTinh") Boolean gioiTinh,@Param("laQL") Boolean laQL);
	
	Optional<AccountEntity> findOneByUsername(String username);
}
