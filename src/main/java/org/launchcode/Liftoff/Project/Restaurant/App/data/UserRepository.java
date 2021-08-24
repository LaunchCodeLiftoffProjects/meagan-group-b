package org.launchcode.Liftoff.Project.Restaurant.App.data;


import org.launchcode.Liftoff.Project.Restaurant.App.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}

