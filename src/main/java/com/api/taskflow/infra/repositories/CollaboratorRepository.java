package com.api.taskflow.infra.repositories;

import com.api.taskflow.domain.entities.Collaborator;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CollaboratorRepository extends MongoRepository<Collaborator, UUID> {}
