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
@Table(name="tb_dbinfo")
public class TbDbInfo {

	@Id
	private String id;
	
	@Column(name="db_name", nullable=true, length=50)
	private String dbName;
	
	@Column(name="db_driverclass", nullable=true, length=255)
	private String dbDriverClass;
	
	@Column(name="db_url", nullable=true, length=255)
	private String dbUrl;
	
	@Column(name="db_user", nullable=true, length=50)
	private String dbUser;
	
	@Column(name="db_password", nullable=true, length=50)
	private String dbPassword;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbDriverClass() {
		return dbDriverClass;
	}

	public void setDbDriverClass(String dbDriverClass) {
		this.dbDriverClass = dbDriverClass;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public TbDbInfo(String id) {
		super();
		this.id = id;
	}
	
	public TbDbInfo() {}
	
	
}
