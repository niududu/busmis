package com.neusoft.busManager.repairinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.neusoft.busManager.repairinfo.model.BusRepairInfoModel;

public interface IBusRepairInfoMapper {
	//增加车辆维修信息表
	public void insert(BusRepairInfoModel model) throws Exception;
	//修改车辆维修信息表
	public void update(BusRepairInfoModel model) throws Exception;
	//删除车辆维修信息表
	public void delete(BusRepairInfoModel model) throws Exception;
	//取得对应修序号的车辆维修信息表
	public BusRepairInfoModel select(int reapirNo) throws Exception;
	//取得所有的车辆维修信息表的列表
	public List<BusRepairInfoModel> selectListByAll() throws Exception;
	//以分页的方式取得所有的车辆维修信息表的列表
	public List<BusRepairInfoModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	//取得所有的车辆维修信息表的个数
	public int selectCountByAll() throws Exception;
	//通过维修类型编号来查询维修车辆信息表
	public List<BusRepairInfoModel> selectByTypeNo(int typeNo) throws Exception;
	//通过维修单位编号来查询维修车辆信息表
	public List<BusRepairInfoModel> selectByProviderNo(int providerNo) throws Exception;
	//通过车辆编号来查询维修车辆信息表
	public List<BusRepairInfoModel> selectByBusId(int busId) throws Exception;
	//通过司机编号来查询维修车辆信息表
	public List<BusRepairInfoModel> selectByDriveId(int driveId) throws Exception;
	//通过检索条件查找（维修类型编号、维修单位编号、车辆编号、司机编号）
	public List<BusRepairInfoModel> selectListByCondition(@Param("typeNo") int typeNo,@Param("providerNo") int providerNo,@Param("busId") int busId,@Param("driveId") int driveId) throws Exception;
	//以分页的形式检索条件查找（维修类型编号、维修单位编号、车辆编号、司机编号）车辆维修信息表
	public List<BusRepairInfoModel> selectListByConditionWithPage(@Param("typeNo") int typeNo,@Param("providerNo") int providerNo,@Param("busId") int busId,@Param("driveId") int driveId,RowBounds rb) throws Exception;
	//按检索条件取得车辆维修信息表的个数
	public int selectCountByCondition(@Param("typeNo") int typeNo,@Param("providerNo") int providerNo,@Param("busId") int busId,@Param("driveId") int driveId) throws Exception;
}
