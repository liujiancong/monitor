package com.gmcc.monitor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_job")
public class TbJob {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private String id;

	@Column(name="job_name", nullable=true, length=50)
	private String jobName;
	
	@Column(name="job_desc", nullable=true, length=50)
	private String jobDesc;
	
	@Column(name="classname", nullable=true, length=255)
	private String className;
	
	@Column(name="job_group", nullable=true, length=50)
	private String jobGroup;
	
	@Column(name="status", nullable=true, length=2)
	private String status;
	
	@Column(name="corn_expression", nullable=true, length=255)
	private String cornExpression;
	
	@Column(name="monitor_id", nullable=true, length=255)
	private String monitorId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCornExpression() {
		return cornExpression;
	}

	public void setCornExpression(String cornExpression) {
		this.cornExpression = cornExpression;
	}
	
	
	
	public String getMonitorId() {
		return monitorId;
	}

	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}

	public TbJob() {}

	public TbJob(String id) {
		super();
		this.id = id;
	}
	
}
