package com.doctor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.dao.DoctorServiceDao;
import com.doctor.pojo.Doctor;
import com.doctor.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorServiceDao doctorServiceDao;

	@Override
	public List<Doctor> getDoctorByDate(Doctor doctor) {

		return doctorServiceDao.getDoctorByDate(doctor);
	}

}
