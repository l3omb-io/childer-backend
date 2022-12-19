package dev.childer.childerbackend.service;

import dev.childer.childerbackend.models.EvaluationModel;
import dev.childer.childerbackend.repositories.ChildrenRepository;
import dev.childer.childerbackend.repositories.EvaluationRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private ChildrenRepository childrenRepository;

    public EvaluationService(EvaluationRepository evaluationRepository, ChildrenRepository childrenRepository) {
        this.evaluationRepository = evaluationRepository;
        this.childrenRepository = childrenRepository;
    }

    public List<EvaluationModel> findAllEvaluation() {
        return this.evaluationRepository.findAll();
    }

    public Optional<EvaluationModel> findEvaluationByID(Long id) {
        return this.evaluationRepository.findById(id);
    }

    public EvaluationModel saveEvaluation(Long id, EvaluationModel evaluation) {
        this.childrenRepository.findById(id).map(child -> {
            evaluation.setChildren(child);
            return this.evaluationRepository.save(evaluation);
        });
        return evaluation;
    }

    public Optional<EvaluationModel> updateEvaluation(Long id, EvaluationModel newEvaluation) {
        return evaluationRepository.findById(id).map(evaluation -> {
            evaluation.setTopic(newEvaluation.getTopic());
            evaluation.setIndicator(newEvaluation.getIndicator());
            return evaluationRepository.save(evaluation);
        });
    }

    public void deleteByID(Long id) {
        this.evaluationRepository.deleteById(id);
    }


}
