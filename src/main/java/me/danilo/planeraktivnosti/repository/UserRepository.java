package me.danilo.planeraktivnosti.repository;

import me.danilo.planeraktivnosti.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
