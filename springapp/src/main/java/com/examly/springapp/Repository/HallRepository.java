package com.examly.springapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Hall;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
	@Query("Select hall FROM Hall hall WHERE hall.admin_id=:ad_id")
	List<Hall> getByAdminId(@Param("ad_id")String ad_id);
}
