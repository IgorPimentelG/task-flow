package com.api.taskflow.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("notes")
public class Note {

	@Id
	private UUID id = UUID.randomUUID();

	private String title;
	private String content;

	@DBRef
	private Collaborator author;

	@Field("created_at")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Field("updated_at")
	private LocalDateTime updatedAt;
}
