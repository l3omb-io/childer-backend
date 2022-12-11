package dev.childer.childerbackend.repositories;

import dev.childer.childerbackend.models.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherModel , Long> {
    TeacherModel findByUserName(String userName);
}
