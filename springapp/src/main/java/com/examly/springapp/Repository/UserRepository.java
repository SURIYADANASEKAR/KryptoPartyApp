package com.examly.springapp.Repository;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Users;


import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	Optional<Users> findByMobile(String mobile);

	
    @Query("SELECT u FROM Users u join u.roles r WHERE u.username = :username and r.roleName='USER'")
    public List<Users> findUser(@Param("username") String username);

    @Query("SELECT u FROM Users u join u.roles r WHERE u.username = :username and r.roleName='ADMIN'")
    public List<Users> findAdmin(@Param("username") String username);
    
	@Query("SELECT u from Users u Where u.username = :username")
	public Users getUserByUsername(@Param("username") String username);

	
}