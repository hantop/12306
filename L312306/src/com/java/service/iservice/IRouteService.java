package com.java.service.iservice;

import java.util.List;

import com.java.dao.pojo.RouteInfo;

import hibernate.Route;

public interface IRouteService extends IBaseService<Route, Integer> {
	List<Route> findByProperty(String propName, Object propVal);

	List<RouteInfo> findByStationInfo(String fromStation, String toStation);

	RouteInfo findByStationInfo(String fromStation, String toStation, String tid);
}
