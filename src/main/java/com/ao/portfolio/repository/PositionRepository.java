package com.ao.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ao.portfolio.entity.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {
}