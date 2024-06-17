package com.api.taskflow.infra.services;

import com.api.taskflow.domain.dtos.*;
import com.api.taskflow.domain.entities.Note;
import com.api.taskflow.domain.entities.Task;
import com.api.taskflow.infra.errors.NotFoundException;
import com.api.taskflow.infra.mappers.TaskMapper;
import com.api.taskflow.infra.repositories.TaskServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

	private final TaskMapper mapper;
	private final TaskServiceRepository repository;
	private final CollaboratorService collaboratorService;

	public TaskOutput create(TaskInput input) {
		var task = mapper.map(input);
		var owner = collaboratorService.find(input.ownerId());

		task.setOwner(owner);

		repository.save(task);
		return mapper.map(task);
	}

	public TaskOutput update(UUID id, TaskInput input) {
		var task = find(id);
		mapper.update(task, input);

		if (!input.ownerId().equals(task.getOwner().getId())) {
			var owner = collaboratorService.find(input.ownerId());
			task.setOwner(owner);
		}

		repository.save(task);
		return mapper.map(task);
	}

	public TaskOutput findById(UUID id) {
		var task = find(id);
		return mapper.map(task);
	}

	public Collection<TaskOutput> listAll() {
		var tasks = repository.findAll();
		return mapper.map(tasks);
	}

	public void assignNote(UUID taskId, Note note) {
		var task = find(taskId);
		task.addNote(note);
		repository.save(task);
	}

	public void unassignNote(UUID taskId, Note note) {
		var task = find(taskId);
		task.removeNote(note);
		repository.save(task);
	}

	private Task find(UUID id) {
		return repository.findById(id)
		  .orElseThrow(() -> new NotFoundException("Task not found."));
	}
}
