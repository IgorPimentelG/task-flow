package com.api.taskflow.domain.dtos;

public record CollaboratorInput(
  String name,
  String email,
  String role
) {}
