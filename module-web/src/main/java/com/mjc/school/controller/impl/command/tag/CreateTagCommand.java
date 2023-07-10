package com.mjc.school.controller.impl.command.tag;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.questions.AskQuestionsToGetTagDtoRequest;
import com.mjc.school.service.dto.tag.TagDtoRequest;
import com.mjc.school.service.dto.tag.TagDtoResponse;

import static com.mjc.school.controller.constans.Constants.CREATE_TAG;

public class CreateTagCommand implements Command {

    private final BaseController<TagDtoRequest, TagDtoResponse, Long> controller;
    private final AskQuestionsToGetTagDtoRequest question = new AskQuestionsToGetTagDtoRequest();

    public CreateTagCommand(BaseController<TagDtoRequest, TagDtoResponse, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        System.out.println(CREATE_TAG);
        controller.create(question.askQuestionsToGetTagDtoRequest());
    }
}
