package com.api.taskflow.infra.controllers;

import com.api.taskflow.domain.dtos.*;
import com.api.taskflow.infra.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class TaskController {

	private final TaskService service;

	@MutationMapping("createTask")
	public TaskOutput create(@Argument TaskInput input) {
		return service.create(input);
	}

	@MutationMapping("updateTask")
	public TaskOutput update(@Argument UUID id, TaskInput input) {
		return service.update(id, input);
	}

	@QueryMapping("taskById")
	public TaskOutput findById(@Argument UUID id) {
		return service.findById(id);
	}

	@QueryMapping("taskList")
	public Collection<TaskOutput> listAll() {
		return service.listAll();
	}
}
