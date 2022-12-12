package dev.childer.childerbackend.service;

import dev.childer.childerbackend.models.IndicatorModel;
import dev.childer.childerbackend.repositories.IndicatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndicatorService {

    private final IndicatorRepository indicatorRepository;

    public IndicatorService(IndicatorRepository indicatorRepository) {
        this.indicatorRepository = indicatorRepository;
    }

    public List<IndicatorModel> findAllIndicator(){
        return this.indicatorRepository.findAll();
    }

    public Optional<IndicatorModel> findIndicatorByID(Long id){
        return this.indicatorRepository.findById(id);
    }

    public IndicatorModel saveIndicator(IndicatorModel indicator){
        return this.indicatorRepository.save(indicator);
    }

    public Optional<IndicatorModel> updateIndicator(Long id,IndicatorModel newIndicator){
        return this.indicatorRepository.findById(id).map(indicator -> {
            indicator.setEvaluation(newIndicator.getEvaluation());
            indicator.setTitle(newIndicator.getTitle());
//            indicator.setEvaluationResult(newIndicator.getEvaluationResult());

            return this.indicatorRepository.save(indicator);
        });
    }

    public void deleteByID(Long id){
        this.indicatorRepository.deleteById(id);
    }
}
