package com.api.taskflow.infra.services;

import com.api.taskflow.domain.dtos.*;
import com.api.taskflow.domain.entities.Note;
import com.api.taskflow.infra.errors.NotFoundException;
import com.api.taskflow.infra.mappers.NoteMapper;
import com.api.taskflow.infra.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteService {

	private final NoteMapper mapper;
	private final NoteRepository repository;
	private final TaskService taskService;
	private final CollaboratorService collaboratorService;

	public NoteOutput create(NoteInput input) {
		var note = mapper.map(input);
		var author = collaboratorService.find(input.authorId());
		note.setAuthor(author);
		repository.save(note);

		taskService.assignNote(input.taskId(), note);

		return mapper.map(note);
	}

	public NoteOutput update(UUID id, NoteInput input) {
		var note = find(id);

		if (!note.getAuthor().getId().equals(input.authorId())) {
			var author = collaboratorService.find(input.authorId());
			note.setAuthor(author);
		}

		repository.save(note);
		return mapper.map(note);
	}

	public NoteOutput findById(UUID id) {
		var note = find(id);
		return mapper.map(note);
	}

	public Collection<NoteOutput> listAll() {
		var notes = repository.findAll();
		return mapper.map(notes);
	}

	public NoteOutput delete(UUID id) {
		var note = find(id);
		repository.delete(note);
		return mapper.map(note);
	}

	public Note find(UUID id) {
		return repository.findById(id)
		  .orElseThrow(() -> new NotFoundException("Note not found."));
	}
}
