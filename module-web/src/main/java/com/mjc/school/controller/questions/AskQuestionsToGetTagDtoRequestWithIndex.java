package com.mjc.school.controller.questions;

import com.mjc.school.service.dto.tag.TagDtoRequest;

import java.io.IOException;

import static com.mjc.school.controller.constans.Constants.ENTER_TAG_ID;

public class AskQuestionsToGetTagDtoRequestWithIndex {

    TakeNumberFromKeyboard question1 = new TakeNumberFromKeyboard();
    AskQuestionsToGetTagDtoRequest question2 = new AskQuestionsToGetTagDtoRequest();

    public TagDtoRequest askQuestionsToGetTagDtoRequestWithIndex() throws IOException {
        System.out.println(ENTER_TAG_ID);
        Long index = Long.valueOf(question1.takeNumberFromKeyboard());
        TagDtoRequest tagDtoRequest = question2.askQuestionsToGetTagDtoRequest();
        tagDtoRequest.setId(index);
        return tagDtoRequest;
    }
}
