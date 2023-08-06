package com.rui.library.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.rui.library.Models.Campus;


public interface CampusRepository extends CrudRepository<Campus,Long> {
    Campus findCampusByLocation(String location);
}
