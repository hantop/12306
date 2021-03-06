package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.idao.IStationDao;
import com.java.service.iservice.IStationService;

import hibernate.Station;

@Service("stationService")
public class ServiceStationImpl implements IStationService {
	@Autowired
	@Qualifier("stationDao")
	private IStationDao stationDao;

	@Transactional
	@Override
	public String save(Station t) {
		String msg = "error";
		try {
			Station stations =  stationDao.findById(t.getId());
			if (stations==null ) {
				stationDao.save(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(Station t) {
		String msg = "error";
		try {
			Station e = stationDao.findById(t.getId());
			if (e != null) {
				stationDao.delete(e);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(Station newT) {
		String msg = "error";
		try {
			Station e = stationDao.findById(newT.getId());
			if (e != null) {
				stationDao.update(newT);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Station> findAll() {
		List<Station> stations = null;
		try {
			stations = stationDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stations;
	}

	@Transactional(readOnly = true)
	@Override
	public Station findById(String k) {
		Station station = null;
		try {
			station = stationDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return station;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Station> findByProperty(String propName, Object propVal) {
		List<Station> stations = null;
		try {
			stations = stationDao.findByProperty(propName, propVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stations;
	}



}
