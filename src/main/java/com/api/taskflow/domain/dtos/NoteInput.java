package com.api.taskflow.domain.dtos;

import java.util.UUID;

public record NoteInput(
  String title,
  String content,
  UUID authorId,
  UUID taskId
) {}
