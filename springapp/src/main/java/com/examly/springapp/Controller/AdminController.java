package com.examly.springapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.Exception.ResourceNotFoundException;
import com.examly.springapp.Repository.CompanyRepository;
import com.examly.springapp.Repository.HallRepository;
import com.examly.springapp.Services.HallService;
import com.examly.springapp.model.Company;
import com.examly.springapp.model.Hall;

@RestController
@RequestMapping("admin")
@ResponseBody
public class AdminController {

    @Autowired
    HallRepository hallRepo;

    @Autowired
    CompanyRepository companyRepo;

    @Autowired
    HallService hallService;

    @RequestMapping("dashboard")
    public List<Hall> getHallByCompany(@RequestBody HashMap<String, String> request) {
        String admin_id = request.get("ad_id");
        return hallService.getHallByCompany(admin_id);
    }

    @PostMapping("addHall")
    public Hall createhall(@RequestBody Hall hall) {
        return hallRepo.save(hall);
    }

    @PutMapping("editHall")
    public ResponseEntity<Hall> updateHall(@RequestParam long id, @RequestBody Hall hall) {
        Hall updateHall = hallRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hall doesnt exixts with id" + id));

        updateHall.setEventdate(hall.getEventdate());
        updateHall.setDescription(hall.getDescription());
        updateHall.setHalltype(hall.getHalltype());
        updateHall.setHallprice(hall.getHallprice());
        hallRepo.save(updateHall);

        return ResponseEntity.ok(updateHall);

    }

    @DeleteMapping("deleteHall")
    public ResponseEntity<HttpStatus> deleteHall(@RequestParam long id) {

        Hall hall = hallRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hall doesnt exists with id" + id));

        hallRepo.delete(hall);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @RequestMapping("profile")
    public Optional<Company> getProfileById(@RequestParam long id) {
        return companyRepo.findById(id);
    }

    @PutMapping("editProfile")
    public ResponseEntity<Company> editProfile(@RequestParam long id, @RequestBody Company company) {
        Company editProfile = companyRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profile doesnt exists with id" + id));

        editProfile.setCompanyname(company.getCompanyname());
        editProfile.setCompanyaddress(company.getCompanyaddress());
        editProfile.setMobilenumber(company.getMobilenumber());

        companyRepo.save(editProfile);

        return ResponseEntity.ok(editProfile);

    }

}

