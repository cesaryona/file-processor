package com.file.processor.repository;

import com.file.processor.repository.entity.FinancialTransactionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialTransactionRepository extends MongoRepository<FinancialTransactionEntity, String> {
}
