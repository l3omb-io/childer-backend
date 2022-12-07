package dev.childer.childerbackend.controller;

import dev.childer.childerbackend.models.ChildrenModel;
import dev.childer.childerbackend.service.ChildrenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/children")
public class ChildrenController {

    @Autowired
    private final ChildrenService childrenService;

    public ChildrenController(ChildrenService childrenService) {
        this.childrenService = childrenService;
    }


    @GetMapping("")
    public @ResponseBody ResponseEntity<List<ChildrenModel>> getAllChildren(){
        return new ResponseEntity<>(this.childrenService.findAllChildren(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<ChildrenModel> getOneChildren(@PathVariable Long id){
        return new ResponseEntity<>(this.childrenService.findChildrenByID(id),HttpStatus.OK);
    }

    @PostMapping("")
    public @ResponseBody ResponseEntity<ChildrenModel> postChildren(@RequestBody ChildrenModel children){
        return new ResponseEntity<>(this.childrenService.saveChildren(children),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<ChildrenModel> putChildren(@PathVariable Long id,@RequestBody ChildrenModel children){
        return new ResponseEntity<>(this.childrenService.updateChildren(id,children),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteChildren(@PathVariable Long id){
        this.childrenService.deleteByID(id);
        return new ResponseEntity<>(String.format("has delete."),HttpStatus.OK);
    }
}
