package com.demo.entities;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicle_entity")
public class VehicleEntity extends BaseEntity {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String name;
	private String parkingNo;
	private String arrivalTime;
	private String departureTime;
	private Date date;
	private String vehicleNo;
	private String vehicleType;
	 public VehicleEntity()
	    {}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParkingNo() {
		return parkingNo;
	}

	public void setParkingNo(String parkingNo) {
		this.parkingNo = parkingNo;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	

	

	@Override
	public String toString() {
		return "VehicleEntity [id=" + id + ", name=" + name + ", parkingNo=" + parkingNo + ", arrivalTime="
				+ arrivalTime + ", departureTime=" + departureTime + ", date=" + date + ", vehicleNo=" + vehicleNo
				+ ", vehicleType=" + vehicleType + "]";
	}


	


	public VehicleEntity(String name, String parkingNo, String arrivalTime, String departureTime, Date date,
			String vehicleNo, String vehicleType) {
		super();
		this.name = name;
		this.parkingNo = parkingNo;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.date = date;
		this.vehicleNo = vehicleNo;
		this.vehicleType = vehicleType;
	}
	
	

	
}
