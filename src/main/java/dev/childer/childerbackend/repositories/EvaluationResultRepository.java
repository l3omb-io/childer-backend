package dev.childer.childerbackend.repositories;

import dev.childer.childerbackend.models.EvaluationResultModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationResultRepository extends JpaRepository<EvaluationResultModel, Long> {
}
