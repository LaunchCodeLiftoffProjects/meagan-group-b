package org.launchcode.Liftoff.Project.Restaurant.App.data;

import org.launchcode.Liftoff.Project.Restaurant.App.models.ImageDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDBRepository extends JpaRepository<ImageDB, String> {
}
