package dev.childer.childerbackend.repositories;

import dev.childer.childerbackend.models.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, Long> {
}
