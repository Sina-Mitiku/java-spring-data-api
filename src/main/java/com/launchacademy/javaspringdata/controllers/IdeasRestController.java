package com.launchacademy.javaspringdata.controllers;

import com.launchacademy.javaspringdata.models.Idea;
import com.launchacademy.javaspringdata.repositories.IdeaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdeasRestController {
  private IdeaRepository ideaRepository;

  @Autowired
  public IdeasRestController(IdeaRepository ideaRepository) {
    this.ideaRepository = ideaRepository;
  }

  @GetMapping("/api/v1/ideas")
  public Iterable<Idea> getIdeas() {
    return ideaRepository.findAll();
  }

  @GetMapping("/api/v1/ideas/{id}")
  public Optional<Idea> getIdeaById(@PathVariable Integer id) {
    return ideaRepository.findById(id);
  }

  @GetMapping("/api/v1/ideas/name/{name}")
  public Iterable<Idea> getIdeaByName(@PathVariable String name) {
    return ideaRepository.findByNameStartingWith(name);
  }

  @GetMapping("/api/v1/ideas/name2/{name}")
  public Iterable<Idea> getIdeaByName2(@PathVariable String name) {
    return ideaRepository.findByNameEndingWith(name);
  }

  @GetMapping("/api/v1/ideas/description/{description}")
  public Iterable<Idea> getIdeasByDescriptionNC(@PathVariable String description) {
    return ideaRepository.findByDescriptionNotContaining(description);
  }
}
