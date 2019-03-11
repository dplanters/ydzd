package com.gndc.core.mapping;

import com.gndc.core.dto.LoginInfoDTO;
import com.gndc.core.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author jingkaihui
 * @date 2019/2/11
 */
@Mapper
public interface UserModelMapping {

    UserModelMapping INSTANCE = Mappers.getMapper(UserModelMapping.class);

    UserModel loginInfoDTO2UserModel(LoginInfoDTO loginInfoDTO);

    LoginInfoDTO userModel2LoginInfoDTO(UserModel userModel);
}
