package com.scar.test.service.mapper;

import com.scar.test.domain.Image;
import com.scar.test.service.dto.ImageDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Image} and its DTO {@link ImageDTO}.
 */
@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface ImageMapper extends EntityMapper<ImageDTO, Image> {
    //    @Mapping(target = "user_image", source = "user_image", qualifiedByName = "login")
    //    ImageDTO toDto(Image s);
}
