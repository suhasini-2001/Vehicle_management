package com.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.demo.entities.VehicleEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;

@Service
public interface VehicleService {
	List<VehicleEntity> showVehicleEntity();

	public VehicleEntity add(VehicleEntity bean) throws DuplicateRecordException ;

	public VehicleEntity update(VehicleEntity bean)throws RecordNotFoundException;
	
	public boolean deleteVehicleById(long VehicleId);
	
	 public VehicleEntity findById(long Id);

	
}