package com.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.demo.entities.VehicleEntity;

@Repository
public interface VehicleDAO<U> extends CrudRepository<VehicleEntity, Long> {
}

