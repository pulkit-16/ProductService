package com.productservice.productservice.inheritencerelations.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    @Override
     User save(User user);
}
