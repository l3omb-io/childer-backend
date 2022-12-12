package dev.childer.childerbackend.repositories;

import dev.childer.childerbackend.models.IndicatorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicatorRepository extends JpaRepository<IndicatorModel, Long> {
}
