package com.gmcc.monitor.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_monitor")
public class TbMonitor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="monitor_name", nullable=true, length=255)
	private String monitorName;
	
	@Column(name="monitor_type", nullable=true, length=30)
	private String monitorType;
	
	@Column(name="corn_expression", nullable=true, length=255)
	private String cornExpression;
	
	@Column(name="monitor_person", nullable=true, length=255)
	private String monitorPerson;
	
	@Column(name="monitor_value", nullable=true, length=255)
	private String monitorValue;
	
	@Column(name="monitor_sql", nullable=true)
	private String monitorSql;
	
	@Column(name="monitor_url", nullable=true, length=255)
	private String monitorUrl;
	
	@Column(name="status", nullable=true, length=2)
	private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_time;
	
	@Column(name="job_id", nullable=true, length=36)
	private String jobId;
	
	@Column(name="db_id", nullable=true, length=36)
	private String dbId;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMonitorName() {
		return monitorName;
	}

	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}

	public String getMonitorType() {
		return monitorType;
	}

	public void setMonitorType(String monitorType) {
		this.monitorType = monitorType;
	}

	public String getCornExpression() {
		return cornExpression;
	}

	public void setCornExpression(String cornExpression) {
		this.cornExpression = cornExpression;
	}

	public String getMonitorPerson() {
		return monitorPerson;
	}

	public void setMonitorPerson(String monitorPerson) {
		this.monitorPerson = monitorPerson;
	}

	public String getMonitorValue() {
		return monitorValue;
	}

	public void setMonitorValue(String monitorValue) {
		this.monitorValue = monitorValue;
	}

	public String getMonitorSql() {
		return monitorSql;
	}

	public void setMonitorSql(String monitorSql) {
		this.monitorSql = monitorSql;
	}

	public String getMonitorUrl() {
		return monitorUrl;
	}

	public void setMonitorUrl(String monitorUrl) {
		this.monitorUrl = monitorUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	
	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	
	

	public String getDbId() {
		return dbId;
	}

	public void setDbId(String dbId) {
		this.dbId = dbId;
	}

	public TbMonitor() {}

	public TbMonitor(int id) {
		super();
		this.id = id;
	}
	
	
}









