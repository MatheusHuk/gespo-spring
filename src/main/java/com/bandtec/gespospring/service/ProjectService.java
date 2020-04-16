package com.bandtec.gespospring.service;

import com.bandtec.gespospring.model.Project;

import java.util.List;

public interface ProjectService {
   void save(List<Project> projects);
   Project findById(Integer id);
   Boolean update(Project project);
   Boolean delete(Integer id);
}
