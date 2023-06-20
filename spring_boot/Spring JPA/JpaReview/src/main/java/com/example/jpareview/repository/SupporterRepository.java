package com.example.jpareview.repository;

import com.example.jpareview.entity.Cource;
import com.example.jpareview.entity.Supporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupporterRepository extends JpaRepository<Supporter,Integer> {
    Supporter getSupporterByCources(Cource cource);
}
