package com.example.pathfinder.repo;

import com.example.pathfinder.model.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepo extends JpaRepository<Picture, Long> {
}
