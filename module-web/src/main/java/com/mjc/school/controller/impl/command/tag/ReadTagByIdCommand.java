package com.mjc.school.controller.impl.command.tag;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.questions.TakeIdTag;
import com.mjc.school.service.dto.tag.TagDtoRequest;
import com.mjc.school.service.dto.tag.TagDtoResponse;

import java.io.IOException;

import static com.mjc.school.controller.constans.Constants.GET_NEWS_ID;

public class ReadTagByIdCommand implements Command {

    private final BaseController<TagDtoRequest, TagDtoResponse, Long> controller;

    private final TakeIdTag question = new TakeIdTag();

    public ReadTagByIdCommand(BaseController<TagDtoRequest, TagDtoResponse, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() throws IOException {
        System.out.println(GET_NEWS_ID);
        controller.readById(question.takeIdTag());

    }
}
