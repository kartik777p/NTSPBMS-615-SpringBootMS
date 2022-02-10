package com.nit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nit.document.Tourist;

public interface ITouristRepository extends MongoRepository<Tourist, String> {

}
