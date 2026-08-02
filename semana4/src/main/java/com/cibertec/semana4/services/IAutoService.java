package com.cibertec.semana4.services;

import com.cibertec.semana4.models.Auto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAutoService {
    Auto create(Auto auto);
    Auto get(Long id);
    List<Auto> getAll();
    List<Auto> getByFilter(Pageable pageable);
    List<Auto> getByMarcaAndModelo(String marca, String modelo);
}
