package com.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.pojo.Doctor;
import com.doctor.service.DoctorService;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@RequestMapping("/test")
	public List<Doctor> test() {
		Doctor doctor = new Doctor();
		doctor.setId(1);
		doctor.setDoctorName("Mahima");
		doctor.setClinicName("ABC");
		doctor.setClinicAddress("Delhi");
		List<Doctor> response = doctorService.getDoctorByDate(doctor);
		return response;

	}
}
