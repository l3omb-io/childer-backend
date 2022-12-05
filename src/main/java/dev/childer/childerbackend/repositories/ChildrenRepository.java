package dev.childer.childerbackend.repositories;

import dev.childer.childerbackend.models.ChildrenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildrenRepository extends JpaRepository<ChildrenModel, Long> {
}
