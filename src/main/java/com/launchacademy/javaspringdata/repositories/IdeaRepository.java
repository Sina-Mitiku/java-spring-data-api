package com.launchacademy.javaspringdata.repositories;

import com.launchacademy.javaspringdata.models.Idea;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IdeaRepository extends CrudRepository<Idea, Integer> {
  //public Idea findByName(String name);
  public List<Idea> findAllByName(String name);

  //Return all Ideas
  List<Idea> findAll();

  //find by id
  Idea findById(int id);

  //Return specific Idea by name
  Idea findByName(String name);

  //Return an Idea which doesn't contain the word "Facebook"
  List<Idea> findByDescriptionNotContaining(String name);

  //Return all Ideas that start with "Cat"
  List<Idea> findByNameStartingWith(String name);

  //Return all Ideas that end with "Cat"
  List<Idea> findByNameEndingWith(String name);

//if you want to write a custom query
  @Query("SELECT i from Idea i where i.name like :namePrefix%")
  public Idea whereNameStartsWith(@Param("namePrefix") String namePrefix);
}