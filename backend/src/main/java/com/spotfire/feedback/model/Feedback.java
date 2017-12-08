package com.spotfire.feedback.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "feedback")
public class Feedback implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "feedbackType")
	public String feedbackType;

	@Column(name = "feedback", nullable = true)
	public String feedbackText;
	@Lob
	@Column(name = "feedbackScreenShot", nullable = true)
	public byte[] feedbackScreenShot;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	public Date createdAt;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	public Customer cust;

	protected Feedback() {
	}

	public Feedback(String feedbackType, String feedbackText, Customer cust, byte[] screenshot) {
		this.feedbackType = feedbackType;
		this.feedbackText = feedbackText;
		this.feedbackScreenShot = screenshot;
		this.cust = cust;
		this.createdAt = new Timestamp(System.currentTimeMillis());
	}

	public Feedback(String feedbackType, String feedbackText, Customer cust) {
		this.feedbackType = feedbackType;
		this.feedbackText = feedbackText;
		this.cust = cust;
		this.createdAt = new Timestamp(System.currentTimeMillis());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFeedbackText() {
		return feedbackText;
	}

	public void setFeedbackText(String feedbackText) {
		this.feedbackText = feedbackText;
	}

	public String getFeedbackType() {
		return feedbackType;
	}

	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public byte[] getFeedbackScreenShot() {
		return feedbackScreenShot;
	}

	public void setFeedbackScreenShot(byte[] feedbackScreenShot) {
		this.feedbackScreenShot = feedbackScreenShot;
	}

}
