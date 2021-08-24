package org.launchcode.Liftoff.Project.Restaurant.App.data;

import org.launchcode.Liftoff.Project.Restaurant.App.models.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, String> {
}
