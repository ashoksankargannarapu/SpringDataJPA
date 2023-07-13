package com.nt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public String registerDoctor(Doctor doctor) {
		System.out.println("doc id(before save::" + doctor.getDocId());
		Doctor doc = doctorRepo.save(doctor);
		return "Doctor obj is saved with id value:" + doc.getDocId();
	}

	@Override
	public String registerGroupOfObjects(Iterable<Doctor> doctors) {

		if (doctors != null) {
			Iterable<Doctor> savedDoctors = doctorRepo.saveAll(doctors);
			int size = ((Collection) savedDoctors).size();
			List<Integer> ids = new ArrayList();
			savedDoctors.forEach(d -> {
				ids.add(d.getDocId());

			});
			return size + "no.of doctors are saved with id values:" + ids.toString();
		} else {
			throw new IllegalArgumentException("invalid doctors info");
		}
	}

	@Override
	public long fetchDoctorsCount() {
		return doctorRepo.count();
	}

	@Override
	public boolean checkDoctorAvailability(Integer id) {
		return doctorRepo.existsById(id);
	}

	@Override
	public Iterable<Doctor> showAllDoctors() {
		return doctorRepo.findAll();
	}

	@Override
	public Iterable<Doctor> showAllRecordsByIds(Iterable<Integer> ids) {
		return doctorRepo.findAllById(ids);
	}

	/*@Override
	public Doctor showDoctorById(Integer id) {
		Optional<Doctor> opt=doctorRepo.findById(id);
		if(opt.isPresent())
			return opt.get();
		else 
			throw new IllegalArgumentException("invalid doctor id");
	
	}*/
	@Override
	public Doctor showDoctorById(Integer id) {
		Doctor doctor = doctorRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid doctor id"));
		return doctor;
	}

	@Override
	public String updateDoctorIncomeById(Integer id, float hikePercentage) {
		// load object
		Optional<Doctor> opt = doctorRepo.findById(id);
		if (opt.isPresent()) {
			Doctor doctor = opt.get();
			double newIncome = doctor.getIncome() + (doctor.getIncome() * (hikePercentage / 100.0f));
			// set new income to entity object
			doctor.setIncome(newIncome);
			// partially update the object
			return doctorRepo.save(doctor).getDocId() + "is updated with" + newIncome;
		} else {
			return id + " doctor not found";
		}

	}

	@Override
	public String registerOrUpdateDoctor(Doctor doctor) {
		// load Doctor object
		Optional<Doctor> opt = doctorRepo.findById(doctor.getDocId());
		if (opt.isPresent()) {
			doctorRepo.save(doctor);
			return doctor.getDocId() + "Doctor Details are found and updated";
		} else {
			return "Doctor is saved with id value:" + doctorRepo.save(doctor).getDocId();
		}
	}

	@Override
	public String deleteDoctorById(Integer id) {
		// Load object
		Optional<Doctor> opt = doctorRepo.findById(id);
		if (opt.isPresent()) {
			doctorRepo.deleteById(id);
			return id + "doctor is deleted";
		} else {
			return id + " doctor not found for deletion";
		}
	}

	@Override
	public String deleteDoctor(Doctor doctor) {
		// load object
		Optional<Doctor> opt = doctorRepo.findById(doctor.getDocId());
		if (opt.isEmpty()) {
			return doctor.getDocId() + " doctor is not found";
		} else {
			doctorRepo.delete(opt.get());
			return doctor.getDocId() + " doctor found and deleted";
		}
	}

	@Override
	public String removeAllDoctors() {
		long count = doctorRepo.count();
		if (count > 0) {
			doctorRepo.deleteAll();
			return count + " no.of records are deleted";
		}
		return "No records found to delete";
	}

	@Override
	public String removeDoctorsByIds(List<Integer> ids) {
		List<Doctor> docList = (List<Doctor>) doctorRepo.findAllById(ids);
		if (docList.size() == ids.size()) {
			doctorRepo.deleteAllById(ids);
			return docList.size() + "no.of records are deleted";
		} else {
			return "some of given id value records are not found in the db table";
		}
	}

}
