package com.api.taskflow.infra.services;

import com.api.taskflow.domain.dtos.*;
import com.api.taskflow.domain.entities.Collaborator;
import com.api.taskflow.infra.errors.NotFoundException;
import com.api.taskflow.infra.mappers.CollaboratorMapper;
import com.api.taskflow.infra.repositories.CollaboratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CollaboratorService {

	private final CollaboratorMapper mapper;
	private final CollaboratorRepository repository;

	public CollaboratorOutput create(CollaboratorInput input) {
		var collaborator = mapper.map(input);
		repository.save(collaborator);
		return mapper.map(collaborator);
	}

	public CollaboratorOutput update(UUID id, CollaboratorInput input) {
		var collaborator = find(id);
		mapper.update(collaborator, input);
		repository.save(collaborator);
		return mapper.map(collaborator);
	}

	public CollaboratorOutput findById(UUID id) {
		var collaborator = find(id);
		return mapper.map(collaborator);
	}

	public Collection<CollaboratorOutput> listAll() {
		var collaborators = repository.findAll();
		return mapper.map(collaborators);
	}

	private Collaborator find(UUID id) {
		return repository.findById(id)
		  .orElseThrow(() -> new NotFoundException("Collaborator not found."));
	}
}
