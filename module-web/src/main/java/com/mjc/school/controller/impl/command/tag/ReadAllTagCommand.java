package com.mjc.school.controller.impl.command.tag;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.service.dto.tag.TagDtoRequest;
import com.mjc.school.service.dto.tag.TagDtoResponse;

import static com.mjc.school.controller.constans.Constants.GET_ALL_TAGS;

public class ReadAllTagCommand implements Command {

    private final BaseController<TagDtoRequest, TagDtoResponse, Long> controller;

    public ReadAllTagCommand(BaseController<TagDtoRequest, TagDtoResponse, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        System.out.println(GET_ALL_TAGS);
        controller.readAll();
    }
}
