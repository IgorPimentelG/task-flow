package com.api.taskflow.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("tasks")
public class Task {

	@Id
	private UUID id = UUID.randomUUID();

	private String title;
	private String description;

	@Field("estimated_hours")
	private Integer estimatedHours;

	@Field("worked_hours")
	private Integer workedHours = 0;

	@DBRef
	private Collaborator owner;

	@DBRef
	private List<Note> notes = new ArrayList<>();

	@Field("created_at")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Field("updated_at")
	private LocalDateTime updatedAt;

	public void addNote(Note note) {
		notes.add(note);
	}

	public void removeNote(Note note) {
		notes.remove(note);
	}
}
