package com.file.processor.converter;

import com.file.processor.model.FinancialTransactionDto;
import com.file.processor.repository.entity.FinancialTransactionEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.time.LocalDateTime;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        builder = @Builder(disableBuilder = true),
        imports = {LocalDateTime.class}
)
public interface FinancialTransactionConverter {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    FinancialTransactionEntity toEntity(FinancialTransactionDto financialTransactionDto);

}
