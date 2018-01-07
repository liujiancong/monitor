package com.gmcc.monitor.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gmcc.monitor.dao.TbMonitorDao;
import com.gmcc.monitor.dao.TbSystemDao;
import com.gmcc.monitor.entity.TbMonitor;
import com.gmcc.monitor.entity.TbSystem;

@Controller
public class MonitorController {
	
	@Autowired
	private TbMonitorDao tbMonitorDao;
	
	@Autowired
	private TbSystemDao tbSystemDao;
	
	//获取监控列表
	@RequestMapping("/getMonitorList")
	private String getMonitorList(Map<String, Object> map) {
		List<TbMonitor> tbMonitorList= (List<TbMonitor>) tbMonitorDao.findAll();
		map.put("tbMonitorList", tbMonitorList);
		return "ftl/monitorList";	
	}
	
	//新建监控
	@RequestMapping("/newMonitor")
	private String addMonitor(Map<String, Object> map) {
		List<TbSystem> tbSystemList = (List<TbSystem>) tbSystemDao.findAll();
		map.put("tbSystemList", tbSystemList);
		return "ftl/addMonitor";
	}
	
	//保持监控
	@RequestMapping("/saveMonitor")
	private String saveMonitor(TbMonitor tbMonitor, HttpServletResponse response) throws IOException {
		tbMonitor.setStatus("0");
		tbMonitor.setCreate_time(new Date());
		tbMonitorDao.save(tbMonitor);
		response.sendRedirect("/getMonitorList");
		return null;
	}
	
	//查看监控
	@RequestMapping("/viewMonitor")
	private String viewMonitor(Integer id, Map<String, Object> map) {
		TbMonitor tbMonitor = tbMonitorDao.findOne(id);
		map.put("tbMonitor", tbMonitor);
		return "ftl/viewMonitor";
	}
	
	//删除监控
	@RequestMapping("/deleteMonitor")
	private String deleteMonitor(Integer id, HttpServletResponse response) throws IOException {
		tbMonitorDao.delete(id);
		response.sendRedirect("/getMonitorList");
		return null;
	}

}
