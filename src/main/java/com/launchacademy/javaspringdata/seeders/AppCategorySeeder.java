package com.launchacademy.javaspringdata.seeders;

import com.launchacademy.javaspringdata.models.AppCategory;
import com.launchacademy.javaspringdata.repositories.CategoryRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppCategorySeeder implements CommandLineRunner {

  private CategoryRepository categoryRepository;

  @Autowired
  public AppCategorySeeder(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    //create a collection of creative names and descriptions
   //Map<String, String> seedMap = new HashMap<String, String>();
    List<String> seedList = new ArrayList<String>();
    seedList.add("Social Media");
    seedList.add("Productivity");
    seedList.add("Games");
    seedList.add("Self Help");

    //loop through the collection, creating app ideas if they're not found
    //for (String name : seedMap.keySet()) {
      for (String name : seedList) {
      List<AppCategory> appCategories = categoryRepository.findAllByName(name);
      if (appCategories.size() == 0) {
        AppCategory newAppCategory = new AppCategory();
        newAppCategory.setName(name);
        categoryRepository.save(newAppCategory);
      }
    }
  }
}
