package com.bandtec.gespospring.service.Project;

import com.bandtec.gespospring.entity.table.Project;
import com.bandtec.gespospring.entity.view.VwSimpleProject;

import java.util.List;
import java.util.Set;

public interface ProjectService {
   void save(List<Project> projects);
   Project findById(Integer id);
   Boolean update(Project project);
   Boolean delete(Integer id);
   Set<VwSimpleProject> findByEmployee(Integer id);
}
