package com.flightreservation_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightreservation_app.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
