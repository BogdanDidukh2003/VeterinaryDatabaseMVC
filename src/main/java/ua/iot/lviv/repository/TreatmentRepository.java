package ua.iot.lviv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.iot.lviv.domain.implementation.TreatmentEntity;

@Repository
public interface TreatmentRepository extends JpaRepository<TreatmentEntity, Long> {
}
