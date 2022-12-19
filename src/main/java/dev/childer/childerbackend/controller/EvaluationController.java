package dev.childer.childerbackend.controller;

import dev.childer.childerbackend.models.EvaluationModel;
import dev.childer.childerbackend.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    private final EvaluationService evaluationService;


    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping("")
    public @ResponseBody ResponseEntity<List<EvaluationModel>> getAllEvaluation() {
        return new ResponseEntity<>(this.evaluationService.findAllEvaluation(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Optional<EvaluationModel>> getOneEvaluation(@PathVariable Long id) {
        return new ResponseEntity<>(this.evaluationService.findEvaluationByID(id), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public @ResponseBody ResponseEntity<EvaluationModel> postEvaluation(@RequestBody EvaluationModel evaluation, @PathVariable Long id) {
        return new ResponseEntity<>(this.evaluationService.saveEvaluation(id, evaluation), HttpStatus.CREATED);
    }

    @PutMapping("")
    public @ResponseBody ResponseEntity<Optional<EvaluationModel>> putEvaluation(@PathVariable Long id, @RequestBody EvaluationModel evaluation) {
        return new ResponseEntity<>(this.evaluationService.updateEvaluation(id, evaluation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteEvaluation(@PathVariable Long id) {
        this.evaluationService.deleteByID(id);
        return new ResponseEntity<>(String.format("%d has delete.", id), HttpStatus.OK);
    }

}
