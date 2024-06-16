package com.api.taskflow.infra.mappers;

import com.api.taskflow.domain.dtos.*;
import com.api.taskflow.domain.entities.Collaborator;
import org.mapstruct.*;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface CollaboratorMapper {
	Collaborator map(CollaboratorInput source);
	CollaboratorOutput map(Collaborator source);
	Collection<CollaboratorOutput> map(Collection<Collaborator> source);
	void update(@MappingTarget Collaborator target, CollaboratorInput source);
}
