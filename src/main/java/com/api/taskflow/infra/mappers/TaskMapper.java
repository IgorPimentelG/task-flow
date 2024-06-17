package com.api.taskflow.infra.mappers;

import com.api.taskflow.domain.dtos.*;
import com.api.taskflow.domain.entities.Task;
import org.mapstruct.*;

import java.util.Collection;

@Mapper(componentModel = "spring", uses = CollaboratorMapper.class)
public interface TaskMapper {
	Task map(TaskInput source);
	TaskOutput map(Task source);
	Collection<TaskOutput> map(Collection<Task> source);
	void update(@MappingTarget Task target, TaskInput source);
}
