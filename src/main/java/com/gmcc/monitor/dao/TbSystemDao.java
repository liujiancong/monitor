package com.gmcc.monitor.dao;

import org.springframework.data.repository.CrudRepository;

import com.gmcc.monitor.entity.TbSystem;


public interface TbSystemDao extends CrudRepository<TbSystem, Integer>{

	public TbSystem findByName(String name);
	
	public TbSystem findByDbId(String dbId);
	
	public void deleteByDbId(String dbId);
}
