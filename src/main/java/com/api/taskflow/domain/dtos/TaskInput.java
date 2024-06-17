package com.api.taskflow.domain.dtos;

import java.util.UUID;

public record TaskInput(
  String title,
  String description,
  Integer estimatedHours,
  Integer workedHours,
  UUID ownerId
) {}
