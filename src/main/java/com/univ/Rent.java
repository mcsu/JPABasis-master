package com.univ;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Rent {
	
	Date beginRent;
	Date endRent;
	long key;

	@Temporal(TemporalType.TIMESTAMP)
	public Date getBeginRent() {
		return beginRent;
	}

	public void setBeginRent(Date beginRent) {
		this.beginRent = beginRent;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getEndRent() {
		return endRent;
	}

	public void setEndRent(Date endRent) {
		this.endRent = endRent;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getKey() {
		return key;
	}

	public void setKey(long key) {
		this.key = key;
	}
	
}
