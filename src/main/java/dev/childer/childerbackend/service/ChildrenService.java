package dev.childer.childerbackend.service;

import dev.childer.childerbackend.models.ChildrenModel;
import dev.childer.childerbackend.repositories.ChildrenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChildrenService {

    private final ChildrenRepository childrenRepository;


    public ChildrenService(ChildrenRepository childrenRepository) {
        this.childrenRepository = childrenRepository;
    }


    public List<ChildrenModel> findAllChildren(){
        return this.childrenRepository.findAll();
    }

    public ChildrenModel findChildrenByID(Long id){
        return this.childrenRepository.getReferenceById(id);
    }

    public ChildrenModel saveChildren(ChildrenModel children){
        return this.childrenRepository.save(children);
    }

    public ChildrenModel updateChildren(Long id , ChildrenModel children){
        ChildrenModel c = findChildrenByID(id);

        c.setFname(children.getFname());
        c.setLname(children.getLname());
        c.setBod(children.getBod());
        c.setGrade(children.getGrade());
        c.setIdCard(children.getIdCard());
        c.setTel(children.getTel());
        c.setImagePath(children.getImagePath());
        c.setParentName(children.getParentName());
        c.setBook(children.getBook());
        c.setNickName(children.getNickName());

        childrenRepository.save(c);
        return c;
    }

    public void deleteByID(Long id){
        this.childrenRepository.deleteById(id);
    }
}
