package com.shapovalov.course.repositories;

import com.shapovalov.course.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {
}
