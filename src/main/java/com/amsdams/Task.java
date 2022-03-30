package com.amsdams;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Task {

	@Id
	@GeneratedValue
	private Long id;

	//@Size(max = 200, message = "Please provide a description of 200 chars")

	@NotEmpty(message = "Please provide a description")
	@Size(max=200)
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
