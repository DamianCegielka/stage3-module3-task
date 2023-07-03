package com.mjc.school.controller.impl.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.impl.command.author.*;
import com.mjc.school.controller.impl.command.news.*;
import com.mjc.school.service.dto.author.AuthorDtoRequest;
import com.mjc.school.service.dto.author.AuthorDtoResponse;
import com.mjc.school.service.dto.news.NewsDtoRequest;
import com.mjc.school.service.dto.news.NewsDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandFactory {

    @Autowired
    private final BaseController<NewsDtoRequest, NewsDtoResponse, Long> newsController;
    @Autowired
    private final BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController;
    @Autowired
    private final Invoker invoker;

    private int chosenNumber = -1;


    public CommandFactory(BaseController<NewsDtoRequest, NewsDtoResponse, Long> newsController,
                BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController,
                Invoker invoker) {
        this.newsController = newsController;
        this.authorController = authorController;
        this.invoker=invoker;
    }



    public void mainController(int chosenNumber) throws IOException {
        try {
                switch (chosenNumber) {
                    case 1 -> invoker.setCommand(new CreateNewsCommand(newsController));
                    case 2 -> invoker.setCommand(new CreateAuthorCommand(authorController));
                    case 3 -> System.out.println("TO DO create tag");
                    case 4 -> invoker.setCommand(new ReadAllNewsCommand(newsController));
                    case 5 -> invoker.setCommand(new ReadAllAuthorsCommand(authorController));
                    case 6 -> System.out.println("TO DO get all tags");
                    case 7 -> invoker.setCommand(new ReadNewsByIdCommand(newsController));
                    case 8 -> invoker.setCommand(new ReadAuthorByIdCommand(authorController));
                    case 9 -> System.out.println("TO DO get tag by id");
                    case 10 -> invoker.setCommand(new UpdateNewsCommand(newsController));
                    case 11 -> invoker.setCommand(new UpdateAuthorCommand(authorController));
                    case 12 -> System.out.println("TO DO update tag");
                    case 13-> invoker.setCommand(new DeleteNewsByIdCommand(newsController));
                    case 14 ->invoker.setCommand(new DeleteAuthorByIdCommand(authorController));
                    case 15 -> System.out.println("TO DO delete tag by id");
                    case 16 -> System.out.println("TO DO Get author by news id");
                    case 17 -> System.out.println("TO DO Get tags by news id.");
                    case 18 -> System.out.println("TO DO Get news by various parameter");
                    case 0 -> System.out.println("By by!");
                    default -> System.out.println("Error!");
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
