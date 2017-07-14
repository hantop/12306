package com.java.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.java.dao.pojo.RouteInfo;
import com.java.service.iservice.IComputeSeatService;
import com.java.service.iservice.IRouteService;
import com.java.service.iservice.ITrainService;
import com.opensymphony.xwork2.ModelDriven;

import hibernate.Route;

@Controller("routeAction")
@Scope("prototype")
public class RouteAction implements ModelDriven<Route>, RequestAware,SessionAware {
	//取参数
	private Route route = new Route();
	private Map<String, Object> requestMap;
	private String type;// 访问类型:是查询还是更新
	private String propName;// 查询条件:属性名
	private String propVal;// 属性值
	private String fromStation;  //出发站
	private String toStation;  //终点站
	private String findtime;  
	private String tid;
	private Map<String, Object> sessionMap;
	
	//导入service层
	@Autowired
	@Qualifier("routeService")
	private IRouteService routeService;
	
	@Autowired
	@Qualifier("serviceComputeSeat")
	IComputeSeatService serviceComputeSeat;
	
	@Autowired
	@Qualifier("trainService")
	private ITrainService trainService;
	
	public String getPropVal() {
		return propVal;
	}

	public void setPropVal(String propVal) {
		this.propVal = propVal;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		
	}
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.requestMap = request;
	}

	@Override
	public Route getModel() {
		return route;
	}
	
	//用户查询区间车站信息
	public String findByStationInfo(){
		String msg = "error";
		List<RouteInfo> routeInfos = routeService.findByStationInfo(fromStation,toStation);
		if(routeInfos != null){
			requestMap.put("routeInfos", routeInfos);
			msg = "success";
		}
		return msg;
	}
	
	//筛选用户选择的车次
	public String getTrain(){
		String msg = "error";
		//System.out.println(tid+fromStation+toStation+"===========");
		RouteInfo routeInfo = routeService.findByStationInfo(fromStation,toStation,tid);   //获取到用户选择类车的最新信息
		if(routeInfo != null){
			int gnumber = routeInfo.getCarriages().get(0).getCnumber();  //车厢
			int seatnumber = routeInfo.getSeatnumber();       //座位号
			routeInfo.setSeatnumber(seatnumber);
			routeInfo.setGnumber(gnumber);
			requestMap.put("routeInfo", routeInfo);
			msg = "success";
		}
		return msg;
	}
	
	public String save() {
		return routeService.save(route);
	}

	public String delete() {
		return routeService.delete(route);
	}
	public String update() {
		return routeService.update(route);
	}

	public String findAll() {
		String msg = "error";
		List<Route> routeList = routeService.findAll();
		if (routeList != null && routeList.size() > 0) {
			requestMap.put("routeListFromServer", routeList);
			msg = "success";
		}
		return msg;
	}

	public String findById() {
		String msg = "error";
		Route e = routeService.findById(route.getId());
		if (e != null) {
			List<Route> routeList = new ArrayList<Route>();
			routeList.add(e);
			requestMap.put("routeListFromServer", routeList);
			msg = "success";
		}
		return msg;
	}

	// 根据属性查询
	public String findByProperty() {
		String msg = "error";
		Object val = propVal;
		if("routeno".equals(propName)){
			val = Integer.parseInt(propVal);
		}
		List<Route> routeList = routeService.findByProperty(propName,val);//val是类型转换后的值
		if (routeList != null && routeList.size() > 0) {
			if ("update".equals(type)) {
				requestMap.put("route", routeList.get(0));
				msg = "updatesuccess";
			} else {
				requestMap.put("routeListFromServer", routeList);
				msg = "success";
			}
		}
		return msg;
	}
	
	
	public String getFromStation() {
		return fromStation;
	}
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	public String getToStation() {
		return toStation;
	}
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}

	public String getFindtime() {
		return findtime;
	}

	public void setFindtime(String findtime) {
		this.findtime = findtime;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}
	
	
	
	
}
