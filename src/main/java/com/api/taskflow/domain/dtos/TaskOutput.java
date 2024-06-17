package com.api.taskflow.domain.dtos;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

public record TaskOutput(
  UUID id,
  String title,
  String description,
  Integer estimatedHours,
  Integer workedHours,
  CollaboratorOutput owner,
  Collection<NoteOutput> notes,
  LocalDateTime createdAt,
  LocalDateTime updatedAt
) {}
