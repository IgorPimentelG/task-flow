package com.api.taskflow.infra.mappers;

import com.api.taskflow.domain.dtos.*;
import com.api.taskflow.domain.entities.Note;
import org.mapstruct.*;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface NoteMapper {
	Note map(NoteInput source);
	NoteOutput map(Note source);
	Collection<NoteOutput> map(Collection<Note> source);
	void update(@MappingTarget Note target, NoteInput input);
}
