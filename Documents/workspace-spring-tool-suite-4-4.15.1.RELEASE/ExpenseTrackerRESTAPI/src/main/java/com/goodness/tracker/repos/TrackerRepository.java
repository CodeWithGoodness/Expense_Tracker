package com.goodness.tracker.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goodness.tracker.entities.Tracker;

public interface TrackerRepository extends JpaRepository<Tracker, Integer> {

}
