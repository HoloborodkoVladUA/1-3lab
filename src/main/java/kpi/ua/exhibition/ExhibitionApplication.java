package kpi.ua.exhibition;

import kpi.ua.exhibition.controller.*;
import kpi.ua.exhibition.model.Picture;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ExhibitionApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(ExhibitionApplication.class, args);
        AuthorController authorController = context.getBean(AuthorController.class);
        ExhibitController exhibitController = context.getBean(ExhibitController.class);
        ExhibitionController exhibitionController = context.getBean(ExhibitionController.class);
        InternetUserController internetUserController = context.getBean(InternetUserController.class);
        PictureController pictureController = context.getBean(PictureController.class);
        SculptureController sculptureController = context.getBean(SculptureController.class);
        VisitorController visitorController = context.getBean(VisitorController.class);
        pictureController.save(new Picture("New Picture"));
        System.out.println(pictureController.getByTitle("New Picture"));
    }

}
