package com.java.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.java.service.iservice.IPriceService;
import com.opensymphony.xwork2.ModelDriven;

import hibernate.Price;

@Controller("priceAction")
@Scope("prototype")
public class PriceAction implements ModelDriven<Price>, RequestAware {
	@Autowired
	@Qualifier("priceService")
	private IPriceService priceService;

	private Price price = new Price();
	private Map<String, Object> requestMap;
	private String type;// 访问类型:是查询还是更新
	private String propName;// 查询条件:属性名
	private String propVal;// 属性值

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
	public void setRequest(Map<String, Object> request) {
		this.requestMap = request;
	}

	@Override
	public Price getModel() {
		return price;
	}

	public String save() {
		return priceService.save(price);
	}

	public String delete() {
		return priceService.delete(price);
	}

	public String update() {
		return priceService.update(price);
	}

	public String findAll() {
		String msg = "error";
		List<Price> priceList = priceService.findAll();
		if (priceList != null && priceList.size() > 0) {
			requestMap.put("priceListFromServer", priceList);
			msg = "success";
		}
		return msg;
	}

	public String findById() {
		String msg = "error";
		Price e = priceService.findById(price.getId());
		if (e != null) {
			if("update".equals(type)){
				requestMap.put("c", e);
				msg = "updatesuccess";
			}else{
				List<Price> priceList = new ArrayList<Price>();
				priceList.add(e);
				requestMap.put("priceListFromServer", priceList);
				msg = "success";
			}
		}
		return msg;
	}

	// 根据属性查询
	public String findByProperty() {
		String msg = "error";
		Object val = propVal;
		if("priceno".equals(propName)){
			val = Integer.parseInt(propVal);
		}
		List<Price> priceList = priceService.findByProperty(propName,val);//val是类型转换后的值
		if (priceList != null && priceList.size() > 0) {
			if ("update".equals(type)) {
				requestMap.put("price", priceList.get(0));
				msg = "updatesuccess";
			} else {
				requestMap.put("priceListFromServer", priceList);
				msg = "success";
			}
		}
		return msg;
	}

}
