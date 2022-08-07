package com.example.hospital.hw;

import com.example.hospital.hw.HosService.PatientService;
import com.example.hospital.hw.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
public class HospitalHwApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalHwApplication.class, args);
	}

	@RestController
	@RequestMapping("/api/patient")
	public static class HosContoller {


		@Autowired
		PatientService patientService;

		@GetMapping()
		public List<Patient> getAllPatient() {
			return this.patientService.getALLLPatient();

		}

		@GetMapping("/{id}")
		public Patient getPatient(@PathVariable int id) {
			//url:localhost:8080/api/v1/user/1
			Patient patient = this.patientService.getPatient(id);
			return patient;
		}

		@PostMapping()
		public Patient createPatient(@RequestBody Patient patient) {
			Patient createPatient = this.patientService.creatPatient(patient);
			return createPatient;
		}

		@PutMapping("/{id}")
		public Patient updatePatient(@PathVariable int id, @RequestBody Patient patient) {
			Patient updatedPatient = this.patientService.updatePatient(id, patient);
			return updatedPatient;
		}

		@DeleteMapping("/{id}")
		public Patient deletePatient(@PathVariable int id) {
			Patient deletePatient = this.patientService.deletePatient(id);
			return deletePatient;
		}
	}
}
