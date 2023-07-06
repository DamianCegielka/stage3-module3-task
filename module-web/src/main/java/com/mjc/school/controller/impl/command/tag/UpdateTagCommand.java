package com.mjc.school.controller.impl.command.tag;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.questions.AskQuestionsToGetTagDtoRequestWithIndex;
import com.mjc.school.service.dto.tag.TagDtoRequest;
import com.mjc.school.service.dto.tag.TagDtoResponse;

import java.io.IOException;

import static com.mjc.school.controller.constans.Constants.UPDATE_AUTHOR;

public class UpdateTagCommand implements Command {
    private final BaseController<TagDtoRequest, TagDtoResponse, Long> controller;
    private final AskQuestionsToGetTagDtoRequestWithIndex question = new AskQuestionsToGetTagDtoRequestWithIndex();

    public UpdateTagCommand (BaseController<TagDtoRequest, TagDtoResponse, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() throws IOException {
        System.out.println(UPDATE_AUTHOR);
        controller.update(question.askQuestionsToGetTagDtoRequestWithIndex());
    }
}
