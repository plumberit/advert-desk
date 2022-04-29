package com.shapovalov.course.repositories;

import com.shapovalov.course.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
