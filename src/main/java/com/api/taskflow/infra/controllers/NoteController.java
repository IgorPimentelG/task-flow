package com.api.taskflow.infra.controllers;

import com.api.taskflow.domain.dtos.*;
import com.api.taskflow.infra.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class NoteController {

	private final NoteService service;

	@MutationMapping("createNote")
	public NoteOutput create(NoteInput input) {
		return service.create(input);
	}

	@MutationMapping("updateNote")
	public NoteOutput update(@Argument UUID id, @Argument NoteInput input) {
		return service.update(id, input);
	}

	@MutationMapping("deleteNote")
	public NoteOutput delete(@Argument UUID id) {
		return service.delete(id);
	}

	@QueryMapping("noteById")
	public NoteOutput findById(@Argument UUID id) {
		return service.findById(id);
	}

	@QueryMapping("noteList")
	public Collection<NoteOutput> listAll() {
		return service.listAll();
	}
}
