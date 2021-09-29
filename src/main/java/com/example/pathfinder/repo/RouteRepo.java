package com.example.pathfinder.repo;

import com.example.pathfinder.model.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepo extends JpaRepository<Route, Long> {
}
