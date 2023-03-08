package com.etteplan.servicemanual.maintenancetask;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

/**
 * Class to store information about MaintenanceTask.
 * 
 * @author Ville Niemi
 */
@Entity
public class MaintenanceTask {

	public enum Severity {
		critical, important, unimportant
	}

	public enum Status {
		open, closed
	}

	/**
	 * Automatically generated id for maintenance task.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * Id of the target device, the device to which the task is directed.
	 */
	private Long targetId;
	
	/**
	 * Timestamp of the moment when the task was registered first.
	 */
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Timestamp registrationTime;
	
	/**
	 * Description of the task.
	 */
	private String description;
	
	/**
	 * Severity of the task.
	 */
	private Severity severity;
	
	/**
	 * Status of the task.
	 */
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

	public MaintenanceTask(Long targetId, String description, Severity severity, Status status) {
		super();
		this.targetId = targetId;
		this.description = description;
		this.severity = severity;
		this.status = status;
	}

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
	public MaintenanceTask(Long targetId, String description, String severity, String status) {
		super();
		this.targetId = targetId;
		this.description = description;
		this.severity = Severity.valueOf(severity);
		this.status = Status.valueOf(status);
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
