package com.file.processor.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document(collection = "financialTransactionEntity")
public class FinancialTransactionEntity extends BaseEntity {


    private String transactionId;
    private LocalDate transactionDate;
    private BigDecimal amount;
    private TransactionType transactionType;
    private String description;

    @Override
    public String toString() {
        return super.toString();
    }
}
