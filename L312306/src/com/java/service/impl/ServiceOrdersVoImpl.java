package com.java.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.idao.IOrdersDao;
import com.java.dao.idao.IRouteDao;
import com.java.dao.idao.ITicketDao;
import com.java.dao.idao.ITrainDao;
import com.java.dao.pojo.OrdersVo;
import com.java.service.iservice.IOrdersVoService;

import hibernate.Orders;
import hibernate.Route;
import hibernate.Ticket;
import hibernate.Train;

@Service("ordersVoService")
public class ServiceOrdersVoImpl implements IOrdersVoService {
	
	
	@Autowired
	@Qualifier("ordersDao")
	private IOrdersDao ordersDao;
	
	@Autowired
	@Qualifier("ticketDao")
	private ITicketDao ticketDao;
	
	@Autowired
	@Qualifier("trainDao")
	private ITrainDao trainDao;
	
	@Autowired
	@Qualifier("routeDao")
	private IRouteDao routeDao;
	
	@Transactional
	@Override
	public OrdersVo findByInfo(int id) {
		try {
			OrdersVo ordersVo = new OrdersVo();
			Orders orders = ordersDao.findById(id);
			Ticket ticket = ticketDao.findById(orders.getTicket().getId());			
			Train train = trainDao.findById(ticket.getTrain().getId());
			List<Route> sartRoutes = routeDao.findByProperty("site  =  '"+ticket.getStartstation()+"' "
			+" and  d.train.id", train.getId());
			
			List<Route> endRoutes = routeDao.findByProperty("site  =  '"+ticket.getEndstation()+"' "
					+" and  d.train.id", train.getId());
			
			//计算起始时间和结束时间
			Date startTime = sartRoutes.get(0).getStarttim();  //发车时间
			Date endTime = endRoutes.get(0).getEndtime();       //到站时间
			SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			ordersVo.setStartTime(format.format(startTime));
			ordersVo.setEndTime(format.format(endTime));
			
			ordersVo.setStartRoute(sartRoutes.get(0));
			ordersVo.setEndRoute(endRoutes.get(0));
			ordersVo.setTrain(train);
			ordersVo.setOrders(orders);
			ordersVo.setTicket(ticket);
			return ordersVo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
