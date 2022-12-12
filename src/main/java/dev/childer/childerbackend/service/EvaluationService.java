package dev.childer.childerbackend.service;

import dev.childer.childerbackend.models.EvaluationModel;
import dev.childer.childerbackend.repositories.EvaluationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    public EvaluationService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public List<EvaluationModel> findAllEvaluation(){
        return this.evaluationRepository.findAll();
    }

    public Optional<EvaluationModel> findEvaluationByID(Long id){
        return this.evaluationRepository.findById(id);
    }

    public EvaluationModel saveEvaluation(EvaluationModel evaluation){
        return this.evaluationRepository.save(evaluation);
    }

    public Optional<EvaluationModel> updateEvaluation(Long id, EvaluationModel newEvaluation){
        return evaluationRepository.findById(id).map(evaluation -> {
            evaluation.setTopic(newEvaluation.getTopic());
            evaluation.setIndicator(newEvaluation.getIndicator());
            return evaluationRepository.save(evaluation);
        });
    }

    public void deleteByID(Long id){
        this.evaluationRepository.deleteById(id);
    }
}
