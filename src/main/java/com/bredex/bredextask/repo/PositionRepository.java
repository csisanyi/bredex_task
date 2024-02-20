package com.bredex.bredextask.repo;

import com.bredex.bredextask.model.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    List<Position> findByNameContainingIgnoreCaseAndLocationContainingIgnoreCase(String name, String location);

}
