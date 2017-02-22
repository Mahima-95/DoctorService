package com.doctor.dao.impl.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.doctor.pojo.Doctor;

public class DoctorExtractor implements ResultSetExtractor<List<Doctor>>{

	@Override
	public List<Doctor> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		 List<Doctor> doctors = new ArrayList<Doctor>();
		 Doctor doctor= null;
		
		while(rs.next()){
			doctor = new Doctor();
			doctor.setId(rs.getInt("id"));
			doctor.setDoctorName(rs.getString("doctorName"));
			doctor.setClinicName(rs.getString("clinicName"));
			doctor.setClinicAddress(rs.getString("clinicAddress"));
			doctor.setRegisteredDate(rs.getDate("registeredDate"));
			doctors.add(doctor);
		}
		
		return doctors;
	}

}
