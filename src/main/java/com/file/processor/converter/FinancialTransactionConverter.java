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
    @Mapping(target = "createdAt", expression = "java(getLocalDateTimeNow())")
    @Mapping(target = "updatedAt", expression = "java(getLocalDateTimeNow())")
    FinancialTransactionEntity toEntity(FinancialTransactionDto financialTransactionDto);

    default LocalDateTime getLocalDateTimeNow() {
        return LocalDateTime.now();
    }
}
