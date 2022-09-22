package com.demo.ControllerTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.ActiveProfiles;
import com.demo.controller.VehicleEntityController;
import com.demo.entities.VehicleEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.service.VehicleService;

@ActiveProfiles("test")
@SpringBootTest
class VehicleEntityControllerTest {

	@Autowired
	private VehicleService vehicleService;

	@MockBean

	private VehicleEntityController vehicleCon;

	@Test
	void deleteVehicleTest() throws ParseException, DuplicateRecordException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = formatter.parse("06-06-2022");
		VehicleEntity testVehicleEntity = new VehicleEntity("Smita", "7","09:00:00","10:00:00", date , "OD56747","Car");
		VehicleEntity testVehicleEntitySaved = vehicleService.add(testVehicleEntity);
		long vehicleEntityTestId = testVehicleEntitySaved.getId();
		vehicleService.deleteVehicleById(vehicleEntityTestId);
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			vehicleService.findById(vehicleEntityTestId);
		});

	}

	@Test
	void saveVehicleTest() throws ParseException, DuplicateRecordException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = formatter.parse("06-06-2022");

		VehicleEntity testVehicleEntity = new VehicleEntity("Smita", "7","09:00:00","10:00:00", date , "OD56747","Car");
		VehicleEntity testVehicleEntitySaved = vehicleService.add(testVehicleEntity);
		long vehicleEntityTestId = testVehicleEntitySaved.getId();

		VehicleEntity testVehicleEntityDB = vehicleService.findById(vehicleEntityTestId);
		Assertions.assertNotNull(testVehicleEntityDB);

		vehicleService.deleteVehicleById(vehicleEntityTestId);
	}

	@Test
	void TestRecordVehicleByIdShouldThrowDelIdException() throws RecordNotFoundException {
		assertThrows(RecordNotFoundException.class, () -> {
			VehicleEntity v = new VehicleEntity();
			vehicleService.update(v);
		});
	}

	
	
}