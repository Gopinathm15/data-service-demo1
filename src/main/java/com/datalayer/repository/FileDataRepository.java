package com.datalayer.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.datalayer.domains.FileData;

public interface FileDataRepository extends MongoRepository<FileData, String> {

	List<FileData> findByName(String name);
}
