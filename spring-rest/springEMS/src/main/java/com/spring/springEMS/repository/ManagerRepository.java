package com.spring.springEMS.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.springEMS.entity.Manager;

@Repository
public interface ManagerRepository extends MongoRepository<Manager, String> {

}
