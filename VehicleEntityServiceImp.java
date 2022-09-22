package com.demo.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.entities.VehicleEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.repository.VehicleDAO;

@Service("vehicleservice")               //It provides business functionalities.
public class VehicleEntityServiceImp implements VehicleService {

	@SuppressWarnings("rawtypes")
	@Autowired
	VehicleDAO vehicleDao;

	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleEntity> showVehicleEntity() {      //vehicle list is created which acts like an in memory database for vehicle object.
		System.out.println("Service layer entity called");
		return (List<VehicleEntity>) vehicleDao.findAll();

	}

	@SuppressWarnings("unchecked")
	public VehicleEntity add(VehicleEntity request) throws DuplicateRecordException {
	
		Optional<VehicleEntity> vehicle = vehicleDao.findById(request.getId());
		if (vehicle.isPresent()) { 

			throw new DuplicateRecordException("Delivery Entity with this name " + request.getId() + "already Exist");
		} else {
			return (VehicleEntity) vehicleDao.save(request);

		}

	}

	@SuppressWarnings("unchecked")
	@Transactional   //applies as a default to all methods.
	@Override
	public VehicleEntity update(VehicleEntity bean) throws RecordNotFoundException {

	
		Optional<VehicleEntity> vehicle = vehicleDao.findById(bean.getId());
		if (vehicle.isPresent()) {   /*value is present ,is present() save method will return save entity*/
			return (VehicleEntity) vehicleDao.save(bean);
		} else {
			throw new RecordNotFoundException("Vehicle Entity  id " + bean.getId() + "Doesn't Exist");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteVehicleById(long VehicleId) {
		vehicleDao.deleteById(VehicleId);
		return false;

	}
	@Override
    public VehicleEntity findById(long vehicleEntityTestId) {
        @SuppressWarnings("unchecked")
        Optional <VehicleEntity> vehicle=vehicleDao.findById(vehicleEntityTestId);
        return vehicle.get();
    }

public void save(VehicleEntity testVehicleEntity) {

		
}
}