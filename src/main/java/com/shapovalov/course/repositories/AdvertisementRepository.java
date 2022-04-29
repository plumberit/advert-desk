package com.shapovalov.course.repositories;

import com.shapovalov.course.model.Advertisement;
import org.springframework.data.repository.CrudRepository;

public interface AdvertisementRepository extends CrudRepository<Advertisement, Long> {
}
