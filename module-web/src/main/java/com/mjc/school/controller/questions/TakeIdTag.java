package com.mjc.school.controller.questions;

import static com.mjc.school.controller.constans.Constants.ENTER_TAG_ID;

public class TakeIdTag {

    TakeNumberFromKeyboard questionNumber = new TakeNumberFromKeyboard();

    public Long takeIdTag() {
        try {
            System.out.println(ENTER_TAG_ID);
            return Long.valueOf(questionNumber.takeNumberFromKeyboard());
        } catch (Exception e) {
        }
        return null;
    }
}
