package com.productservice.productservice.inheritencerelations.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("j_mentorrepository")
public interface MentorRepository extends JpaRepository<Mentor,Long> {
    @Override
    Mentor save(Mentor mentor);
}
