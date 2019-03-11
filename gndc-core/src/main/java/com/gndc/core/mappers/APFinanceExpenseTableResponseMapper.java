package com.gndc.core.mappers;

import com.gndc.core.api.finance.APFinanceExpenseTableResponse;
import com.gndc.core.model.EventFee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface APFinanceExpenseTableResponseMapper {

    APFinanceExpenseTableResponseMapper INSTANCE = Mappers.getMapper(APFinanceExpenseTableResponseMapper.class);

    APFinanceExpenseTableResponse convert(EventFee eventFee);
}
