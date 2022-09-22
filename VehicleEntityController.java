package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.entities.VehicleEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.service.VehicleService;

@RestController   //restcontroller is used to handle the request.
@RequestMapping(value = "/vehicleentity") //requestmapping map specific request path.
public class VehicleEntityController {

	@Autowired  //enable to get object dependecy.
	VehicleService vehicleService;

//http://localhost:8080/UserApp/vehicleentity/show
	@GetMapping(value = "/show", produces = "application/json")
	List<VehicleEntity> showVehicleEntity() {
		System.out.println("Vehicle entity controller");
		List<VehicleEntity> vehicleList = vehicleService.showVehicleEntity();
		return vehicleList;
	}

	// http://localhost:8080/UserApp/vehicleentity
	@GetMapping(value = "/show3", produces = "application/json")
	public ResponseEntity<VehicleEntity> findById(@PathVariable("Id") long Id) {
		VehicleEntity vehicle = vehicleService.findById(Id);
		return new ResponseEntity<VehicleEntity>(vehicle, HttpStatus.OK);//http status indicates that the request has succeeded
	}

	// http://localhost:8080/UserApp/vehicleentity
	@PostMapping(consumes = "application/json", produces = "application/json")
	ResponseEntity<VehicleEntity> add(@RequestBody VehicleEntity vehicle) throws DuplicateRecordException {

		VehicleEntity id = vehicleService.add(vehicle);

		if (id.getId() == 0) {
			System.out.println("Before exception");
			throw new DuplicateRecordException("VehicleEntity with this id already Exist");

		}
		System.out.println("VehicleEntity name in controller is " + id);
		return ResponseEntity.ok(id);
	}

	// http://localhost:8080/UserApp/vehicleentity
	@PutMapping(consumes = "application/json", produces = "application/json")
	ResponseEntity<VehicleEntity> update(@RequestBody VehicleEntity vehicle) throws RecordNotFoundException {
		VehicleEntity id = vehicleService.update(vehicle);//request body responsible for binding the http request body of the web request
		{

		if (id == null) {
			throw new RecordNotFoundException("VehicleEntity with this id " + vehicle.getId() + "doesnot Exist");

		}
		System.out.println("VehicleEntity name in controller is " + id);
		return ResponseEntity.ok(id);
	}

//http://localhost:8080/UserApp/vehicleentity/show2/Id
	@DeleteMapping(value = "/show2/{VehicleId}", produces = "application/json")
	public ResponseEntity<VehicleEntity> deleteVehicleById(@PathVariable("VehicleId") long VehicleId) {
		vehicleService.deleteVehicleById(VehicleId);
		return new ResponseEntity<VehicleEntity>(HttpStatus.OK);
	}
}