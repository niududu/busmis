package com.neusoft.busManager.repairinfo.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.busManager.repairinfo.mapper.IBusRepairInfoMapper;
import com.neusoft.busManager.repairinfo.model.BusRepairInfoModel;
import com.neusoft.busManager.repairinfo.service.IBusRepairInfoService;

@Service("BusRepairInfoService")
@Transactional
public class BusRepairInfoImpl implements IBusRepairInfoService {
	@Autowired
	private IBusRepairInfoMapper ibrim;
	@Override
	public void add(BusRepairInfoModel model) throws Exception {
		// TODO Auto-generated method stub
		ibrim.insert(model);
	}

	@Override
	public void modify(BusRepairInfoModel model) throws Exception {
		// TODO Auto-generated method stub
		ibrim.update(model);
	}

	@Override
	public void delete(BusRepairInfoModel model) throws Exception {
		// TODO Auto-generated method stub
		ibrim.delete(model);
	}

	@Override
	public BusRepairInfoModel get(int reapirNo) throws Exception {
		// TODO Auto-generated method stub
		return ibrim.select(reapirNo);
	}

	@Override
	public List<BusRepairInfoModel> getListByTypeNo(int typeNo) throws Exception {
		// TODO Auto-generated method stub
		return ibrim.selectByTypeNo(typeNo);
	}

	@Override
	public List<BusRepairInfoModel> getListByProviderNo(int providerNo) throws Exception {
		// TODO Auto-generated method stub
		return ibrim.selectByProviderNo(providerNo);
	}

	@Override
	public List<BusRepairInfoModel> getListByBusId(int busId) throws Exception {
		// TODO Auto-generated method stub
		return ibrim.selectByBusId(busId);
	}

	@Override
	public List<BusRepairInfoModel> getListByDriveId(int driveId) throws Exception {
		// TODO Auto-generated method stub
		return ibrim.selectByDriveId(driveId);
	}

	@Override
	public List<BusRepairInfoModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return ibrim.selectListByAll();
	}

	@Override
	public List<BusRepairInfoModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		RowBounds rb=new RowBounds(rows*(page-1),rows);
		return ibrim.selectListByAllWithPage(rb);
	}

	@Override
	public List<BusRepairInfoModel> getListByCondition(int typeNo, int providerNo, int busId, int driveId)
			throws Exception {
		// TODO Auto-generated method stub
		return ibrim.selectListByCondition(typeNo,providerNo,busId, driveId);
	}

	@Override
	public List<BusRepairInfoModel> getListByConditionWithPage(int typeNo, int providerNo, int busId, int driveId,
			int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		RowBounds rb=new RowBounds(rows*(page-1),rows);
		return ibrim.selectListByConditionWithPage(typeNo, providerNo, busId, driveId, rb);
	}
	
	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return ibrim.selectCountByAll();
	}

	@Override
	public int getCountByCondition(int typeNo, int providerNo, int busId, int driveId) throws Exception {
		// TODO Auto-generated method stub
		return ibrim.selectCountByCondition(typeNo, providerNo, busId, driveId);
	}

	@Override
	public int getPageCountByCondition(int typeNo, int providerNo, int busId, int driveId, int rows) throws Exception {
		// TODO Auto-generated method stub
		int pageCount=0;
		int count=this.getCountByCondition(typeNo, providerNo, busId, driveId);
		if(count%rows==0){
			pageCount=count/rows;
		}
		else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		// TODO Auto-generated method stub
		int pageCount=0;
		int count=this.getCountByAll();
		if(count%rows==0){
			pageCount=count/rows;
		}
		else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}


}
