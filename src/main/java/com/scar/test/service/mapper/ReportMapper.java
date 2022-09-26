package com.scar.test.service.mapper;

import com.scar.test.domain.Report;
import com.scar.test.service.dto.ReportDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Report} and its DTO {@link ReportDTO}.
 */
@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface ReportMapper extends EntityMapper<ReportDTO, Report> {
    //    @Mapping(target = "user", source = "user_report", qualifiedByName = "id")
    //    ReportDTO toDto(Report s);
}
