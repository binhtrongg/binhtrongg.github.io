package com.example.chonqjetairwebapp.repository;
import com.example.chonqjetairwebapp.entity.Role;
import com.example.chonqjetairwebapp.statics.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(Roles name);

}
