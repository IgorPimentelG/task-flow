package com.api.taskflow.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("collaborators")
public class Collaborator {

	@Id
	private UUID id = UUID.randomUUID();

	private String name;
	private String email;
	private String role;

	@DBRef
	private List<Task> tasks;
}
