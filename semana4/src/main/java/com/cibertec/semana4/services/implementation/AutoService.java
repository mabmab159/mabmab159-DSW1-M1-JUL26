package com.cibertec.semana4.services.implementation;

import com.cibertec.semana4.entities.AutoEntity;
import com.cibertec.semana4.models.Auto;
import com.cibertec.semana4.repositories.IAutoRepository;
import com.cibertec.semana4.services.IAutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoService implements IAutoService { //Controller - Service - Repository | Model - Conversion - Entity
    private final IAutoRepository iAutoRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Auto create(Auto auto) {
       /* AutoEntity autoEntity = AutoEntity.builder()
                .id(auto.getId())
                .marca(auto.getMarca())
                .modelo(auto.getModelo())
                .placa(auto.getPlaca())
                .color(auto.getColor())
                .fechaCompra(auto.getFechaCompra())
                .build();
        AutoEntity respuesta = iAutoRepository.save(autoEntity);
        return Auto.builder()
                .id(respuesta.getId())
                .marca(respuesta.getMarca())
                .modelo(respuesta.getModelo())
                .placa(respuesta.getPlaca())
                .color(respuesta.getColor())
                .fechaCompra(respuesta.getFechaCompra())
                .build();*/
        AutoEntity autoEntity = objectMapper.convertValue(auto, AutoEntity.class);
        return objectMapper.convertValue(iAutoRepository.save(autoEntity), Auto.class);
    }

    @Override
    public Auto get(Long id) {
        return objectMapper.convertValue(iAutoRepository.findById(id).orElse(null), Auto.class);
        // findById -> where id = ?
        // findByNombreAndModeloWhereColorIs() -> where nombre = ? and modelo = ? and color = ?
        // findByIdAndModeloWhereColorIsAndTop10CountGroupByMonthFechaCompra() -> where id = ? and modelo = ? and color = ?
    }

    @Override
    public List<Auto> getAll() {
        return objectMapper.convertValue(iAutoRepository.findAll(), new TypeReference<List<Auto>>() {
        });
    }

    @Override
    public List<Auto> getByFilter(Pageable pageable) {
        return objectMapper.convertValue(iAutoRepository.findAll(pageable).stream().toList(), new TypeReference<List<Auto>>() {
        });
    }

    @Override
    public List<Auto> getByMarcaAndModelo(String marca, String modelo) {
        return objectMapper.convertValue(iAutoRepository.searchByMarcaAndModeloNative(marca, modelo), new TypeReference<List<Auto>>() {
        });
    }
}
