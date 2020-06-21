package com.example.cinema.entities;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class programme_film {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 

	
	private String Subject;
	
	 private LocalDateTime StartTime ;
	 private LocalDateTime EndTime;
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public LocalDateTime getStartTime() {
		return StartTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		StartTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return EndTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		EndTime = endTime;
	}
	
}
