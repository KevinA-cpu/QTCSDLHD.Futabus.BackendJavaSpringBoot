package com.heisenburg.backend.mapper;

import com.heisenburg.backend.dto.DetailsDTO;
import com.heisenburg.backend.entity.Details;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DetailsMapper {
    DetailsMapper INSTANCE = Mappers.getMapper(DetailsMapper.class);

    @InheritInverseConfiguration
    DetailsDTO toDetailsDTO(Details details);


    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "idNumber", target = "idNumber")
    @Mapping(source = "birthDate", target = "birthDate")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "educationLevel", target = "educationLevel")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "district", target = "district")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "introduction", target = "introduction")
    Details toDetails(DetailsDTO detailsDTO);
}

