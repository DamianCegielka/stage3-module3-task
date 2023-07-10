package com.mjc.school.controller.impl.command.tag;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.questions.TakeIdTag;
import com.mjc.school.service.dto.tag.TagDtoRequest;
import com.mjc.school.service.dto.tag.TagDtoResponse;

import static com.mjc.school.controller.constans.Constants.REMOVE_TAG;

public class DeleteTagByIdCommand implements Command {

    private final BaseController<TagDtoRequest, TagDtoResponse, Long> controller;
    private final TakeIdTag question=new TakeIdTag();

    public DeleteTagByIdCommand(BaseController<TagDtoRequest, TagDtoResponse, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        System.out.println(REMOVE_TAG);
        controller.deleteById(question.takeIdTag());
    }
}
