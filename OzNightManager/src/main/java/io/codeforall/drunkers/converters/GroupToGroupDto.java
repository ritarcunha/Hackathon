package io.codeforall.drunkers.converters;

import io.codeforall.drunkers.dtos.GroupDto;
import io.codeforall.drunkers.model.Group;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GroupToGroupDto implements Converter<Group, GroupDto> {


    @Override
    public GroupDto convert(Group group) {

        GroupDto groupDto=new GroupDto();

        groupDto.setName(group.getName());
        groupDto.setId(group.getId());
        groupDto.setSession(groupDto.getSession());

        return groupDto;
    }



}
