package com.cibertec.semana4.repositories;

import com.cibertec.semana4.entities.AutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAutoRepository extends JpaRepository<AutoEntity, Long>, PagingAndSortingRepository<AutoEntity, Long> {

    //Query regulares - JPQL -> SQL (Cualquier gestor que tengas conectado) | Es un poco mas lento
    //@Query("select auto from AutoEntity auto where auto.marca=?1 and auto.modelo = ?2")
    //List<AutoEntity> searchByMarcaAndModelo(String marca, String modelo);

    //Query dinamicas - Native -> SQL (Solo va a funcionar para la BD que soporte este Query) | Es un poco mas rapido
    @Query(value = "select * from auto where marca=?1 and modelo = ?2", nativeQuery = true)
    List<AutoEntity> searchByMarcaAndModeloNative(String marca, String modelo);

}
