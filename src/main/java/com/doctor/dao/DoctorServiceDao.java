package com.doctor.dao;

import java.util.List;

import com.doctor.pojo.Doctor;

public interface DoctorServiceDao {

	public List<Doctor> getDoctorByDate(Doctor doctor);
}
