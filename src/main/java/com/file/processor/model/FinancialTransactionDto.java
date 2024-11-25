package com.file.processor.model;

import com.file.processor.repository.entity.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinancialTransactionDto {

    private String transactionId;
    private LocalDate transactionDate;
    private BigDecimal amount;
    private TransactionType transactionType;
    private String description;

}
