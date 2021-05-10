package com.launchacademy.javaspringdata.repositories;

import com.launchacademy.javaspringdata.models.AppCategory;
import com.launchacademy.javaspringdata.models.Idea;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<AppCategory, Integer> {

  //public Idea findByName(String name);
  public List<AppCategory> findAllByName(String name);

}
