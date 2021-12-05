package ua.iot.lviv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.iot.lviv.domain.implementation.PetEntity;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {
}
