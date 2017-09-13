package com.neusoft.busManager.repairinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.busManager.baseinfo.model.BusModel;
import com.neusoft.busManager.repairinfo.model.BusRepairInfoModel;
import com.neusoft.busManager.repairinfo.service.IBusRepairInfoService;
import com.neusoft.busManager.util.ResultInfo;
import com.neusoft.busManager.util.ResultMessage;

@RestController
@RequestMapping("/busrepairinfo")
public class BusRepairInfoController {
	@Autowired
	private IBusRepairInfoService ibris;
	
	@RequestMapping(value="/add",method={RequestMethod.POST})
	public ResultMessage add(BusRepairInfoModel model) throws Exception{
		ResultMessage result=new ResultMessage();
		result.setMessage("增加维修车辆信息表失败");
		ibris.add(model);
		result.setResult("Y");
		result.setMessage("增加维修车辆信息表成功");
		return result;
	}

	@RequestMapping(value="/modify",method={RequestMethod.POST})
	public ResultMessage modify(BusRepairInfoModel model) throws Exception{
		ResultMessage result=new ResultMessage();
		result.setMessage("修改维修车辆信息表失败");
		ibris.modify(model);
		result.setResult("Y");
		result.setMessage("修改维修车辆信息表成功");
		return result;
	}
	
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	public ResultMessage delete(BusRepairInfoModel model) throws Exception{
		ResultMessage result=new ResultMessage();
		result.setMessage("删除维修车辆信息表失败");
		ibris.delete(model);
		result.setResult("Y");
		result.setMessage("删除维修车辆信息表成功");
		return result;
	}
	//取得指定的维修车辆信息表
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public BusRepairInfoModel get(@RequestParam int reapirNo) throws Exception{
		return ibris.get(reapirNo);
	}
	//取得指定的维修车辆信息表
	@RequestMapping(value="/getlistbytypeNo",method=RequestMethod.GET,produces="application/json")
	public BusRepairInfoModel getListByTypeNo(@RequestParam int typeNo) throws Exception{
		return ibris.get(typeNo);
	}
	//取得指定的维修车辆信息表
	@RequestMapping(value="/getlistbyproviderNo",method=RequestMethod.GET,produces="application/json")
	public BusRepairInfoModel getListByProviderNo(@RequestParam int providerNo) throws Exception{
		return ibris.get(providerNo);
	}
	//取得指定的维修车辆信息表
	@RequestMapping(value="/getlistbybusId",method=RequestMethod.GET,produces="application/json")
	public BusRepairInfoModel getListByBusId(@RequestParam int busId) throws Exception{
		return ibris.get(busId);
	}
	//取得指定的维修车辆信息表
	@RequestMapping(value="/getlistbydriveId",method=RequestMethod.GET,produces="application/json")
	public BusRepairInfoModel getListByDriveId(@RequestParam int driveId) throws Exception{
		return ibris.get(driveId);
	}
	//取得所有的维修车辆信息表列表
	@RequestMapping(value="/list/all",method=RequestMethod.GET,produces="application/json")
	public List<BusRepairInfoModel> getListByAll() throws Exception{
		return ibris.getListByAll();
	}
	//以分页的方式取得所有的维修车辆信息表列表
	@RequestMapping(value="/list/page",method=RequestMethod.GET,produces="application/json")
	public ResultInfo<BusRepairInfoModel> getListByAllWithPage(@RequestParam(required=false,defaultValue="5")int rows,@RequestParam(required=false,defaultValue="1")int page) throws Exception{
		int count=ibris.getCountByAll();
		int pageCount=ibris.getPageCountByAll(rows);
		List<BusRepairInfoModel> list=ibris.getListByAllWithPage(rows, page);
		ResultInfo<BusRepairInfoModel> result=new ResultInfo<BusRepairInfoModel>();
		result.setCount(count);
		result.setPage(page);
		result.setPageCount(pageCount);
		result.setRows(rows);
		result.setList(list);
		return result;
	} 
	//按检索条件取得维修车辆信息表列表，无分页
	   @RequestMapping(value="/list/condition",method=RequestMethod.POST)
	   public List<BusRepairInfoModel> getListByCondition(@RequestParam(required=false,defaultValue="0") int typeNo,
			   @RequestParam(required=false,defaultValue="0") int providerNo,@RequestParam(required=false,defaultValue="0") int busId,
			   @RequestParam(required=false,defaultValue="0") int driveId) throws Exception
	   {
		   return ibris.getListByCondition(typeNo, providerNo, busId, driveId);
	   }
	 //按检索条件取得车辆列表，有分页,一次性返回分页的所有信息
	   @RequestMapping(value="/list/condition/page",method=RequestMethod.POST)
	   public ResultInfo<BusRepairInfoModel> getListByConditionWithPage(
			   @RequestParam(required=false,defaultValue="0") int typeNo,
			   @RequestParam(required=false,defaultValue="0") int providerNo,
			   @RequestParam(required=false,defaultValue="0") int busId,
			   @RequestParam(required=false,defaultValue="0") int driveId,
			   @RequestParam(required=false,defaultValue="10") int rows,
			   @RequestParam(required=false,defaultValue="1") int page) throws Exception
	   {
		   ResultInfo<BusRepairInfoModel> result=new ResultInfo<BusRepairInfoModel>();
		   result.setCount(ibris.getCountByCondition(typeNo,providerNo,busId,driveId));
		   result.setPageCount(ibris.getPageCountByCondition(typeNo,providerNo,busId,driveId,rows));
		   result.setRows(rows);
		   result.setPage(page);
		   result.setList(ibris.getListByConditionWithPage(typeNo,providerNo,busId,driveId,rows, page));
		   return result;
	   }
	//重名
	@RequestMapping(value="/checkNameExist",method=RequestMethod.GET,produces="application/json")
	public boolean checkNameExist(@RequestParam int reapirNo) throws Exception{
		if(ibris.get(reapirNo)!=null){
			return false;
		}
		return true;
	}
	//是否可以被删除
	@RequestMapping(value="/checkCanDelete",method=RequestMethod.GET,produces="application/json")
	public boolean checkCanDelete() throws Exception{
		return true;
	}
}
