package com.api.taskflow.domain.dtos;

import java.util.Collection;
import java.util.UUID;

public record CollaboratorOutput(
  UUID id,
  String name,
  String email,
  String role,
  Collection<TaskOutput> tasks
) {}
