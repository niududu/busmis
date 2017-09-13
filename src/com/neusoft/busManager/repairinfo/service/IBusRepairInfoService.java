package com.neusoft.busManager.repairinfo.service;

import java.util.List;

import com.neusoft.busManager.repairinfo.model.BusRepairInfoModel;


public interface IBusRepairInfoService {
	       //增加维修车辆信息表
			public void add(BusRepairInfoModel model) throws Exception;
			//修改维修车辆信息表
			public void modify(BusRepairInfoModel model) throws Exception;
			//删除维修车辆信息表
			public void delete(BusRepairInfoModel model) throws Exception;
			//取得指定的维修车辆信息表
			public BusRepairInfoModel get(int reapirNo) throws Exception;
			//按维修类型取得维修车辆信息表列表
			public List<BusRepairInfoModel> getListByTypeNo(int TypeNo) throws Exception;
			//按维修单位取得所有维修车辆信息表列表
			public List<BusRepairInfoModel> getListByProviderNo(int providerNo) throws Exception;
			//按车辆编号取得所有维修车辆信息表列表
			public List<BusRepairInfoModel> getListByBusId(int busId) throws Exception;
			//按司机编号取得所有维修车辆信息表列表
			public List<BusRepairInfoModel> getListByDriveId(int driveId) throws Exception;
			//取得所有维修车辆信息表列表
			public List<BusRepairInfoModel> getListByAll() throws Exception;
			//分页方式取得所有维修车辆信息表列表
			public List<BusRepairInfoModel> getListByAllWithPage(int rows,int page) throws Exception;
			//按检索条件取得维修车辆信息表列表，不分页
			public List<BusRepairInfoModel> getListByCondition(int TypeNo,int providerNo,int busId,int driveId) throws Exception;
			//按检索条件取得维修车辆信息表列表，分页
			public List<BusRepairInfoModel> getListByConditionWithPage(int TypeNo,int providerNo,int busId,int driveId,int rows,int page) throws Exception;
			//取得所有的维修车辆信息表列表的个数
			public int getCountByAll() throws Exception;
			//按检索条件取得维修车辆信息表个数
			public int getCountByCondition(int TypeNo,int providerNo,int busId,int driveId) throws Exception;
			//按检索条件取得维修车辆信息表的页数
			public int getPageCountByCondition(int TypeNo,int providerNo,int busId,int driveId,int rows) throws Exception;
			
			public int getPageCountByAll(int rows) throws Exception;
			
			
}
