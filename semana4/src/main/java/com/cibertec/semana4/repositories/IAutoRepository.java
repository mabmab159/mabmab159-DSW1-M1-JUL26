package com.cibertec.semana4.repositories;

import com.cibertec.semana4.entities.AutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutoRepository extends JpaRepository<AutoEntity, Long>, PagingAndSortingRepository<AutoEntity, Long> {
}
