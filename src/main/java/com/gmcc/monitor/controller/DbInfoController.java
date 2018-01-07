package com.gmcc.monitor.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gmcc.monitor.dao.TbDbInfoDao;
import com.gmcc.monitor.dao.TbDictionaryDao;
import com.gmcc.monitor.dao.TbSystemDao;
import com.gmcc.monitor.entity.TbDbInfo;
import com.gmcc.monitor.entity.TbDictionary;
import com.gmcc.monitor.entity.TbSystem;

@Controller
public class DbInfoController {

	@Autowired
	private TbDbInfoDao dbInfoDao;
	
	@Autowired
	private TbSystemDao tbSystemDao;
	
	@Autowired
	private TbDictionaryDao  tbDictionaryDao;
	
	/**
	 * 保存数据库链接和系统信息
	 * @param dbInfo
	 * @param name
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/saveDbInfo")
	@Transactional
	public String saveDbInfo(TbDbInfo dbInfo, String systemName, 
			Map<String, Object> map, HttpServletResponse response) throws IOException {
		TbSystem system = tbSystemDao.findByName(systemName);
		if(null != system) {
			map.put("errorMsg", "系统已存在");
			return "/newDbInfo";
		}
		String uuid = UUID.randomUUID().toString().substring(0, 36);
		dbInfo.setId(uuid);
		dbInfo.setCreate_time(new Date());
		dbInfoDao.save(dbInfo);
		TbSystem tbSystem = new TbSystem();
		tbSystem.setDbId(uuid);
		tbSystem.setName(systemName);
		tbSystemDao.save(tbSystem);
		response.sendRedirect("/getDbInfo");
		return null;
	}
	
	/**
	 * 获取数据库链接信息
	 * @param map
	 * @return
	 */
	@RequestMapping("/getDbInfo")
	@Transactional(readOnly=true)
	public String getDbInfoList(Map<String, Object> map) {
		List<TbDbInfo> dbinfoList = (List<TbDbInfo>) dbInfoDao.findAll();
		List<TbSystem> systemList = (List<TbSystem>) tbSystemDao.findAll();
		map.put("dbinfoList", dbinfoList);
		map.put("systemList", systemList);
		return "ftl/systemList";
	}
	
	/**
	 * 更新数据库链接信息
	 * @param map
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/updateDbInfo")
	public String updateDbInfo(TbDbInfo tbDbinfo, HttpServletResponse response) throws IOException {
		tbDbinfo.setCreate_time(new Date());
		dbInfoDao.save(tbDbinfo);
		response.sendRedirect("/getDbInfo");
		return null;
	}
	
	
	
	/**
	 * 编辑数据库链接信息
	 * @param map
	 * @return
	 */
	@RequestMapping("/editDbInfo")
	@Transactional(readOnly=true)
	public String editDbInfo(Map<String, Object> map, String id) {
		TbDbInfo dbinfo = (TbDbInfo) dbInfoDao.findOne(id);
		TbSystem system = (TbSystem) tbSystemDao.findByDbId(id);
		List<TbDictionary> tbDictionaryList =  (List<TbDictionary>) tbDictionaryDao.findAll();
		map.put("dbinfo", dbinfo);
		map.put("system", system.getName());
		map.put("tbDictionaryList", tbDictionaryList);
		return "ftl/editDbInfo";
	}
	
	/**
	 * 新增连接信息
	 * @return
	 */
	@RequestMapping("/newDbInfo")
	public String newDbInfo(Map<String, Object> map) {
		List<TbDictionary> tbDictionaryList =  (List<TbDictionary>) tbDictionaryDao.findAll();
		map.put("tbDictionaryList", tbDictionaryList);
		return "ftl/addDbInfo";
	}
	
	/**
	 * 删除连接信息
	 * @return
	 * @throws IOException 
	 */
	@Transactional
	@RequestMapping("/deleteDbInfo")
	public String deleteDbinfo(String id, HttpServletResponse response) throws IOException {
		dbInfoDao.delete(id);
		tbSystemDao.deleteByDbId(id);
		response.sendRedirect("/getDbInfo");
		return null;
	}
	
	
}
