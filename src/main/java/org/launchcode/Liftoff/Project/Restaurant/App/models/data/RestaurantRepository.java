package org.launchcode.Liftoff.Project.Restaurant.App.models.data;

import org.launchcode.Liftoff.Project.Restaurant.App.models.Restaurant;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer>{
}
