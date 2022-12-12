package dev.childer.childerbackend.service;

import dev.childer.childerbackend.models.EvaluationResultModel;
import dev.childer.childerbackend.repositories.EvaluationResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationResultService {

    private final EvaluationResultRepository evaluationResultRepository;

    public EvaluationResultService(EvaluationResultRepository evaluationResultRepository) {
        this.evaluationResultRepository = evaluationResultRepository;
    }

    public List<EvaluationResultModel> findAllEvaluationResult(){
        return this.evaluationResultRepository.findAll();
    }

    public Optional<EvaluationResultModel> findEvaluationResultByID(Long id){
        return this.evaluationResultRepository.findById(id);
    }

    public EvaluationResultModel saveEvaluationResult(EvaluationResultModel evaluationResult){
        return this.evaluationResultRepository.save(evaluationResult);
    }

    public Optional<EvaluationResultModel> updateEvaluationResult(Long id, EvaluationResultModel newEvaluationResult){
        return this.evaluationResultRepository.findById(id).map(evaluationResult -> {
//            evaluationResult.setIndicator(newEvaluationResult.getIndicator());
            evaluationResult.setTerm(newEvaluationResult.getTerm());
            evaluationResult.setScore(newEvaluationResult.getScore());

            return this.evaluationResultRepository.save(evaluationResult);
        });
    }

    public void deleteByID(Long id){
        this.evaluationResultRepository.deleteById(id);
    }
}
