package com.productservice.productservice.inheritencerelations.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaReprository extends JpaRepository<Ta,Long> {
    @Override
    Ta save(Ta ta);
}
