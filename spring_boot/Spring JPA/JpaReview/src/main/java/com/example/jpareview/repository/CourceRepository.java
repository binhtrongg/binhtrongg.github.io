package com.example.jpareview.repository;

import com.example.jpareview.entity.Cource;
import com.example.jpareview.statics.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourceRepository extends JpaRepository<Cource,Integer> {
    List<Cource> getCourceByType(Type type);
}
