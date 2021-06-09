package com.khan.zoo.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khan.zoo.exception.ResourceNotFoundException;
import com.khan.zoo.model.Animal;
import com.khan.zoo.repository.AnimalRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ZooController {
	@Autowired
	private AnimalRepository ar;

	@GetMapping("/animals")
	public List<Animal> getAllEmployees() {
		return ar.findAll();
	}

	@GetMapping("/animals/{id}")
	public ResponseEntity<Animal> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Animal employee = ar.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Animal not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/animals")
	public Animal createEmployee(@Valid @RequestBody Animal employee) {
		return ar.save(employee);
	}

	@PutMapping("/animals/{id}")
	public ResponseEntity<Animal> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Animal employeeDetails) throws ResourceNotFoundException {
		Animal employee = ar.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setqty(employeeDetails.getqty());
		employee.setType(employeeDetails.getType());
		employee.setAnimalName(employeeDetails.getAnimalName());
		final Animal updatedEmployee = ar.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/animals/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long aid)
			throws ResourceNotFoundException {
		Animal employee = ar.findById(aid)
				.orElseThrow(() -> new ResourceNotFoundException("Animal not found for this id :: " + aid));

		ar.delete(aid);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
