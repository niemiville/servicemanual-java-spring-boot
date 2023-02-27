package com.etteplan.servicemanual.maintenancetask;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class MaintenanceTask {
	
	enum Severity {
		critical, important, unimportant
	}
	
	enum Status { 
		open, closed
	}
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long targetId;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp registrationTime;
    private String description;
    private Severity severity;
    private Status status;
    
    protected MaintenanceTask() {}
    
	/**
	 * Constructor of MaintenanceTask class
	 * 
	 * @param id
	 * @param targetId
	 * @param registrationTime
	 * @param description
	 * @param severity
	 * @param status
	 */
	public MaintenanceTask(Long targetId, String description, Severity severity,
			Status status) {
		super();
		this.targetId = targetId;
		this.description = description;
		this.severity = severity;
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTargetId() {
		return targetId;
	}
	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}
	public Timestamp getRegistrationTime() {
		return registrationTime;
	}
	public void setRegistrationTime(Timestamp registrationTime) {
		this.registrationTime = registrationTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Severity getSeverity() {
		return severity;
	}
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

    
}
