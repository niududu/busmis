/**
 * 维修车辆信息管理主控制JS
 */
$(function(){
	var busrepairinfoid=0;
	var typeNo=0;
	var providerNo=0;
	var busId=0;
	var driveId=0;
	
	//取得维修类型列表，填充维修类型选择下拉框
	$.getJSON("repairtype/list/all.mvc",function(data){
		if(data!=null){
			for(var i=0;i<data.length;i++){
				$("select#repairtypeSelect").append("<option value='"+data[i].typeNo+"'>"+data[i].typeName+"</option>");
			}
		}
	});
	
	//取得维修单位列表，填充维修单位选择下拉框
	$.getJSON("repairprovider/list/all.mvc",function(data){
		if(data!=null){
			for(var i=0;i<data.length;i++){
				$("select#providerSelect").append("<option value='"+data[i].providerNo+"'>"+data[i].providerName+"</option>");
			}
		}
	});
	//取得车辆编号列表，填充车辆编号选择下拉框
	$.getJSON("bus/list/all.mvc",function(data){
		if(data!=null){
			for(var i=0;i<data.length;i++){
				$("select#busSelect").append("<option value='"+data[i].busid+"'>"+data[i].busid+"</option>");
			}
		}
	});
	
	//取得司机编号列表，填充司机编号选择下拉框
	$.getJSON("busdriver/list/all.mvc",function(data){
		if(data!=null){
			for(var i=0;i<data.length;i++){
				$("select#busdriverSelect").append("<option value='"+data[i].driverid+"'>"+data[i].driverid+"</option>");
			}
		}
	});
	
	//显示维修车辆信息表格
	$("#busrepairinfoGrid").jqGrid({
		url: 'busrepairinfo/list/condition/page.mvc',
		datatype: "json",
		mtype:"POST",		
		colModel: [
			{ label: '维修序号', name: 'repairNo', width: 80 },
			{ label: '维修日期', name: 'repairDate', width: 100 },
			{ label: '维修说明', name: 'repairDesc', width: 200 },
			{ label: '维修类型编号', name: 'repairtype.typeNo', width: 80 },
			{ label: '维修单位编号', name: 'provider.providerNo', width: 80 },
			{ label: '车辆编号', name: 'bus.busid', width: 80 },
			{ label: '司机编号', name: 'drive.driverid', width: 80 },
	
		],
		viewrecords: true, // show the current page, data rang and total records on the toolbar
		autowidth:true,
		height: 370,
		rowNum: 10,
		rowList:[10,15,20],
		jsonReader:{
			root:"list",
			page:"page",
			total:"pageCount",
			records:"count",
			id:"repairNo"//主键typeNo的值传递给id  然后id赋值给busrepairinfoid 所以这个busrepairinfoid就会随着typeNo的变化而变化
		},
		pager: "#busrepairinfoGridPager",
		multiselect:false,
		onSelectRow:function(id){
			busrepairinfoid=id;
		}
		/*
		,
		loadComplete:function(data){
			if(data.message){
				BootstrapDialog.alert({title:"提示",message:data.message});
			}
			
		},
		loadError:function(xhr,status,error){
			BootstrapDialog.alert({title:"提示",message:error});
			
		}
		*/
	});
	//点击增加处理
	$("a#busrepairinfoAddLink").on("click",function(){
		$("#ModalLabel").html("增加维修车辆信息");
		$("#modelbody").load("busrepairinfo/add.html",function(){
			 $("button[type='reset']").on("click",function(){
				 $('#busrepairinfoModal').modal("hide");
			 });
			 /*
			//验证数据
			$("#busrepairinfoAddForm").validate({
				rules:{
					typeNo:{
						required:true,
						remote:"busrepairinfo/checkNameExist.mvc"
					},
					typeName:{
						required:true
					},
					typeDesc:{
						required:true
					}
				},
				message:{
					typeNo:{
						required:"维修类型编号不能为空",
						remote:"此维修类型编号已存在！"
					},
					typeName:{
						required:"维修类型名称不能为空"
					},
					typeDesc:{
						required:"维修类型描述不能为空"
					}
				}
			});
			*/
			//拦截用户增加
			$("#busrepairinfoAddForm").ajaxForm(function(data){
				if(data.result=="Y"){
					$("#busrepairinfoGrid").trigger("reloadGrid");
				}
				BootstrapDialog.alert({title:"提示",message:data.message});
				$('#busrepairinfoModal').modal("hide");
			});
		});
		$("div.modal-dialog").css("width","900px");
		$('#busrepairinfoModal').modal("show");
	});
	//点击修改处理
	$("a#busrepairinfoModifyLink").on("click",function(){
		if(busrepairinfoid==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要修改的维修类型"});
		}
		else{
			$("#ModalLabel").html("修改维修类型");
			$("#modelbody").load("busrepairinfo/modify.html",function(){
				//取得小区信息，回填小区修改表单
				$.getJSON("busrepairinfo/get.mvc",{typeNo:busrepairinfoid},function(data){
					$("input[name='typeNo']").val(data.typeNo);
					$("input[name='typeName']").val(data.typeName);
					$("input[name='typeDesc']").val(data.typeDesc);
				});
				$("input[type='button'][value='取消']").on("click",function(){
					 $('#busrepairinfoModal').modal("hide");
				});
				 $('#busrepairinfoModifyForm').ajaxForm(function(data) {
					 BootstrapDialog.alert({title:"提示",message:data.message});
					 if(data.result=="Y"){
						 $("#busrepairinfoGrid").trigger("reloadGrid");
					 }
					 $('#busrepairinfoModal').modal("hide");
		         });
			});
			$("div.modal-dialog").css("width","900px");
			$('#busrepairinfoModal').modal("show");
		}
		
		
	});
	//点击删除处理
	$("a#busrepairinfoDeleteLink").on("click",function(){
		if(busrepairinfoid==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要删除的维修类型"});
		}else{
		//检查对象是否可以被删除
		$.get("busrepairinfo/checkCanDelete.mvc",{typeNo:busrepairinfoid},function(data){
			if(data.result=="N"){
				BootstrapDialog.alert({title:"提示",message:"此维修类型有相关联的维修单位，不能被删除"});
			}
			else{
				//用户确认删除操作
				BootstrapDialog.confirm({title:"提示",message:"您确定要删除此维修类型吗？",callback(result){
					if(result){
						$.post("busrepairinfo/delete.mvc",{typeNo:busrepairinfoid},function(data){
							if(data.result=="Y"){
								busrepairinfoid=0;
							    $("#busrepairinfoGrid").trigger("reloadGrid");
							}
						});
					}
				}});
			}
		});
		}
    });
	//点击查看处理
	$("#busrepairinfoViewLink").on("click",function(){
		if(busrepairinfoid==0){
			BootstrapDialog.alert({title:"提示",message:"请选择要查看的维修类型"});
		}else{
			$("#ModalLabel").html("查看维修类型");
			$("#modelbody").load("busrepairinfo/view.html",function(){
				$.getJSON("busrepairinfo/get.mvc",{typeNo:busrepairinfoid},function(data){
					$("#typeNo").html(data.typeNo);
					$("#typeName").html(data.typeName);
					$("#typeDesc").html(data.typeDesc);
				});
				$("button[type='reset']").on("click",function(){
					$('#busrepairinfoModal').modal("hide");
				});
			});
			$("div.modal-dialog").css("width","900px");
			$('#busrepairinfoModal').modal("show");
		}
	});
	
	
	
	
	
	
});