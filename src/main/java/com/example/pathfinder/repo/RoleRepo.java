package com.example.pathfinder.repo;

import com.example.pathfinder.model.entity.Picture;
import com.example.pathfinder.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {


}
