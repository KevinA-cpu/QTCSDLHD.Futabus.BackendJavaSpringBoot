package com.heisenburg.backend.mapper;

import com.heisenburg.backend.dto.ApplicationDTO;
import com.heisenburg.backend.entity.Application;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DetailsMapper.class)
public interface ApplicationMapper {
    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);

    ApplicationDTO toApplicationDTO(Application application);

    @InheritInverseConfiguration
    Application toApplication(ApplicationDTO applicationDTO);
}
