package com.neusoft.busManager.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.busManager.baseinfo.model.BusDriverModel;
import com.neusoft.busManager.baseinfo.model.BusModel;
import com.neusoft.busManager.repairinfo.model.BusRepairInfoModel;
import com.neusoft.busManager.repairinfo.model.RepairProviderModel;
import com.neusoft.busManager.repairinfo.model.RepairTypeModel;
import com.neusoft.busManager.repairinfo.service.IBusRepairInfoService;

public class TestBusRepairInfo {
	public static void main(String[] args) throws Exception {
		ApplicationContext ac=new ClassPathXmlApplicationContext("context.xml");
		IBusRepairInfoService bean = ac.getBean("BusRepairInfoService",IBusRepairInfoService.class);
		BusRepairInfoModel model=new BusRepairInfoModel();
		BusModel bus=new BusModel();
		BusDriverModel drive=new BusDriverModel();
		RepairProviderModel provider=new RepairProviderModel();
		provider.setProviderNo(1);
		RepairTypeModel repairtype=new RepairTypeModel();
		repairtype.setTypeNo(1);
		
		model.setRepairNo(3);
		model.setRepairDate(new Date());
		model.setRepairDesc("这是第3个维修车辆信息表");
		model.setBus(bus);
		model.setDrive(drive);
		model.setProvider(provider);
		model.setRepairtype(repairtype);
		//bean.add(model);
		//bean.modify(model);
//		System.out.println(bean.get(1).getRepairDate());
//		List<BusRepairInfoModel> list = bean.getListByBusId(1);
//		for (BusRepairInfoModel busRepairInfoModel : list) {
//			System.out.println(busRepairInfoModel.getRepairDesc());
//		}
//		System.out.println(list.size());
//		System.out.println(bean.get(5).getBus().getBusid());
		//System.out.println(bean.getListByAll().size());
//		System.out.println(bean.getListByProviderNo(1).size());
		
		List<BusRepairInfoModel> list = bean.getListByProviderNo(1);
		for (BusRepairInfoModel busRepairInfoModel : list) {
//			System.out.println(busRepairInfoModel.getBus());
			System.out.println(busRepairInfoModel.getProvider().getProviderName());
		}
		
//		List<BusRepairInfoModel> list = bean.getListByTypeNo(1);
//		for (BusRepairInfoModel bm : list) {
//			System.out.println(bm.getRepairDesc());
//		}
//		List<BusRepairInfoModel> list= bean.getListByCondition(1, 1, 1, 2);
//		for (BusRepairInfoModel busRepairInfoModel : list) {
//			System.out.println(busRepairInfoModel.getRepairDesc());
//		}
		
	}
	@Test
	public void testGetPageCondition() throws Exception{
		ApplicationContext ac=new ClassPathXmlApplicationContext("context.xml");
		IBusRepairInfoService bean = ac.getBean("BusRepairInfoService",IBusRepairInfoService.class);
		List<BusRepairInfoModel> list = bean.getListByConditionWithPage(0, 0, 0, 0, 10, 1);
		for (BusRepairInfoModel brim : list) {
			System.out.println(brim.getRepairNo());
		}
	}
	@Test
	public void testGetPage() throws Exception{
		ApplicationContext ac=new ClassPathXmlApplicationContext("context.xml");
		IBusRepairInfoService bean = ac.getBean("BusRepairInfoService",IBusRepairInfoService.class);
		List<BusRepairInfoModel> list = bean.getListByCondition(0, 0, 0, 0);
		for (BusRepairInfoModel brim : list) {
			System.out.println(brim.getRepairNo());
		}
	}
}
