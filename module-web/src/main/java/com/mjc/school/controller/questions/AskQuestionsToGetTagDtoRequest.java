package com.mjc.school.controller.questions;

import com.mjc.school.service.dto.tag.TagDtoRequest;

import static com.mjc.school.controller.constans.Constants.ENTER_TAG_NAME;

public class AskQuestionsToGetTagDtoRequest {

    TakeStringFromKeyboard questionString = new TakeStringFromKeyboard();

    public TagDtoRequest askQuestionsToGetTagDtoRequest() {
        TagDtoRequest tag = new TagDtoRequest();
        try {
            System.out.println(ENTER_TAG_NAME);
            tag.setName(questionString.takeStringFromKeyboard());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tag;
    }
}
