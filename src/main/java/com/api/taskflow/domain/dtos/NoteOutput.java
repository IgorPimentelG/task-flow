package com.api.taskflow.domain.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record NoteOutput(
  UUID id,
  String title,
  String content,
  CollaboratorOutput author,
  TaskOutput task,
  LocalDateTime createdAt,
  LocalDateTime updatedAt
) {}
