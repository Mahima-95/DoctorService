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

		String query = " SELECT * FROM mahima.doctor WHERE registeredDate >=  ? ";
		String date = dateChange();
		System.out.println(date);
		Object[] args = { date };
		List<Doctor> response = jdbcTemplate.query(query, args,
				new DoctorExtractor());
		if (response.size() > 0) {
			return response;
		} else {
			System.out.println("No Data");
			return null;
		}
	}

	public String dateChange() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -10);
		Date date = cal.getTime();
		String dateToString = sdf.format(date);
		return dateToString;
	}
}
