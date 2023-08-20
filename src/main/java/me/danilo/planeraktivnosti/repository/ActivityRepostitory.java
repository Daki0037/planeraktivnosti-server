package me.danilo.planeraktivnosti.repository;

import me.danilo.planeraktivnosti.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepostitory extends JpaRepository<Activity, Integer> {

    List<Activity> findActivityByUserId(int userId);

}
