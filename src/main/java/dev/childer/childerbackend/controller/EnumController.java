package dev.childer.childerbackend.controller;

import dev.childer.childerbackend.models.enumModels.Term;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enum")
public class EnumController {

    @GetMapping("/get")
    public String getByTerm(@RequestParam(required = false,name = "term")Term term){
        return term.name();
    }
}
