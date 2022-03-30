package com.amsdams;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Task {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty(message = "Please provide a description")
	private String description;

	@NotNull(message = "Please provide a priority")
	private Long priority;

	// avoid this "No default constructor for entity"
	public Task() {
	}

	public Task(String description, Long priority) {

		this.description = description;
		this.priority = priority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

}
