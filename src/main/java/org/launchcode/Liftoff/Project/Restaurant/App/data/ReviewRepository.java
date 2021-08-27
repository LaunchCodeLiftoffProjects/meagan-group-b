package org.launchcode.Liftoff.Project.Restaurant.App.data;

import org.launchcode.Liftoff.Project.Restaurant.App.models.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
