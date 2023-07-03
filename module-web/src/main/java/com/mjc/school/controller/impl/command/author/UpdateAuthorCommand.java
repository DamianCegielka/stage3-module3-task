package com.mjc.school.controller.impl.command.author;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.questions.AskQuestionsToGetAuthorDtoRequestWithIndex;
import com.mjc.school.service.dto.author.AuthorDtoRequest;
import com.mjc.school.service.dto.author.AuthorDtoResponse;

import java.io.IOException;

import static com.mjc.school.controller.constans.Constants.UPDATE_AUTHOR;


public class UpdateAuthorCommand implements Command {

    private final BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> controller;
    private final AskQuestionsToGetAuthorDtoRequestWithIndex question = new AskQuestionsToGetAuthorDtoRequestWithIndex();

    public UpdateAuthorCommand (BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() throws IOException {
        System.out.println(UPDATE_AUTHOR);
        controller.update(question.askQuestionsToGetAuthorDtoRequestWithIndex());
    }
}
