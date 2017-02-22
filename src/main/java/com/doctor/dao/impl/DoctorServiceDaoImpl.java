package com.doctor.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.doctor.dao.DoctorServiceDao;
import com.doctor.dao.impl.extractor.DoctorExtractor;
import com.doctor.pojo.Doctor;

@Repository
public class DoctorServiceDaoImpl implements DoctorServiceDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Doctor> getDoctorByDate(Doctor doctor) {

		
		List<Doctor> response = jdbcTemplate.query(
				"SELECT * FROM mahima.doctor WHERE registeredDate = NOW()-5", new DoctorExtractor());
		if (response.size() > 0) {
			return response;
		} else {
			System.out.println("No Data");
			return null;
		}
	}
	
	public static void main(String[] args) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String resp = sdf.format(date);
		System.out.println(resp);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -5);
		
	}

}
