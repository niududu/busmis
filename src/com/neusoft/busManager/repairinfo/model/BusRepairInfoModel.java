package com.neusoft.busManager.repairinfo.model;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.neusoft.busManager.baseinfo.model.BusDriverModel;
import com.neusoft.busManager.baseinfo.model.BusModel;

/**
 * 车辆维修表
 * @author niududu
 *
 */
@Alias("BusRepair")
public class BusRepairInfoModel {
	//维修序号
	private int repairNo;
	//维修日期
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  
	private Date repairDate;
	//维修说明
	private String repairDesc;
	/*外键*/
	//维修类型编号(一个车辆维修表只对应一个维修类型：一对一)
	private RepairTypeModel repairtype;
	//维修单位编号（一个车辆维修表只对应一个维修单位：一对一）
	private RepairProviderModel provider;
	//车辆编号（一对一）
	private BusModel bus;
	//司机编号（一对一）
	private  BusDriverModel drive;
	
	public int getRepairNo() {
		return repairNo;
	}
	public void setRepairNo(int repairNo) {
		this.repairNo = repairNo;
	}
	public Date getRepairDate() {
		return repairDate;
	}
	public void setRepairDate(Date repairDate) {
		this.repairDate = repairDate;
	}
	public String getRepairDesc() {
		return repairDesc;
	}
	public void setRepairDesc(String repairDesc) {
		this.repairDesc = repairDesc;
	}
	public RepairTypeModel getRepairtype() {
		return repairtype;
	}
	public void setRepairtype(RepairTypeModel repairtype) {
		this.repairtype = repairtype;
	}
	public RepairProviderModel getProvider() {
		return provider;
	}
	public void setProvider(RepairProviderModel provider) {
		this.provider = provider;
	}
	public BusModel getBus() {
		return bus;
	}
	public void setBus(BusModel bus) {
		this.bus = bus;
	}
	public BusDriverModel getDrive() {
		return drive;
	}
	public void setDrive(BusDriverModel drive) {
		this.drive = drive;
	}
	
	
	
}
