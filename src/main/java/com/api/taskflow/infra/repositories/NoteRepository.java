package com.api.taskflow.infra.repositories;

import com.api.taskflow.domain.entities.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoteRepository extends MongoRepository<Note, UUID> {}
