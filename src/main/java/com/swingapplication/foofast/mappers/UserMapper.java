package com.swingapplication.foofast.mappers;

import com.swingapplication.foofast.dtos.requests.UserRequest;
import com.swingapplication.foofast.dtos.responses.UserResponse;
import com.swingapplication.foofast.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    static UserMapper getInstance() {
        return Mappers.getMapper(UserMapper.class);
    }

    User mapToUser(UserRequest request);

    User updateToUser(UserRequest request, @MappingTarget User user);

    UserResponse mapToUserResponse(User user);

}
