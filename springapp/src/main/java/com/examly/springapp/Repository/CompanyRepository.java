package com.examly.springapp.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Company;



@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    

}
