package org.launchcode.Liftoff.Project.Restaurant.App.data;

import org.launchcode.Liftoff.Project.Restaurant.App.models.Cuisine;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends CrudRepository <Cuisine, String> {
}
