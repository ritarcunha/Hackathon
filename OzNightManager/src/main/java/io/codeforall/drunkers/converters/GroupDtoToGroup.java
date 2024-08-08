package io.codeforall.drunkers.converters;

import io.codeforall.drunkers.dtos.GroupDto;
import io.codeforall.drunkers.model.Group;
import io.codeforall.drunkers.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GroupDtoToGroup implements Converter<GroupDto, Group> {

    private GroupService groupService;


    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    @Override
    public Group convert(GroupDto groupDto) {
        Group group= (groupDto.getId() != null ? groupService.get(groupDto.getId()) : new Group() );

        group.setName(groupDto.getName());
        group.setSession(groupDto.getSession());
        group.setId(groupDto.getId());
        group.setUsers(groupDto.getUsers());


        return group;
    }
}


