package com.api.taskflow.infra.controllers;

import com.api.taskflow.domain.dtos.*;
import com.api.taskflow.infra.services.CollaboratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class CollaboratorController {

	private final CollaboratorService service;

	@MutationMapping("createCollaborator")
	public CollaboratorOutput create(@Argument CollaboratorInput input) {
		return service.create(input);
	}

	@MutationMapping("updateCollaborator")
	public CollaboratorOutput update(@Argument UUID id, @Argument CollaboratorInput input) {
		return service.update(id, input);
	}

	@QueryMapping("collaboratorById")
	public CollaboratorOutput findById(@Argument UUID id) {
		return service.findById(id);
	}

	@QueryMapping("collaboratorList")
	public Collection<CollaboratorOutput> listAll() {
		return service.listAll();
	}
}
