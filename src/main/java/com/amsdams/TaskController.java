package com.amsdams;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amsdams.error.TaskNotFoundException;

@RestController
@Validated
public class TaskController {

	@Autowired
	private TaskRepository repository;

	// Find
	@GetMapping("/tasks")
	List<Task> findAll() {
		return repository.findAll();
	}

	// Save
	@PostMapping("/tasks")
	Task newTask(@Valid @RequestBody Task newTask) {
		return repository.save(newTask);
	}

	// Find
	@GetMapping("/tasks/{id}")
	Task findOne(@PathVariable @Min(1) Long id) {
		return repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
	}

	// Save or update
	@PutMapping("/tasks/{id}")
	Task updateTask(@RequestBody Task newTask, @PathVariable Long id) {

		return repository.findById(id).map(x -> {
			x.setDescription(newTask.getDescription());
			x.setPriority(newTask.getPriority());
			return repository.save(x);
		}).orElseThrow(() -> new TaskNotFoundException(id));

	}

	@DeleteMapping("/tasks/{id}")
	void deleteTask(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
