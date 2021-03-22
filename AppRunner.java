package main.java.com.minaev.crud;

import main.java.com.minaev.crud.model.Label;
import main.java.com.minaev.crud.repository.LabelRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;

public class AppRunner {


    public static void main(String[] args) {
        LabelRepository.createNewFileNIO();


        Label label1 = new Label();
        label1.setId(1);
        label1.setCategory("Sport");
        Label label2 = new Label();
        label2.setId(2);
        label2.setCategory("News");
        Label label3 = new Label();
        label3.setId(3);
        label3.setCategory("Hobby");

        LabelRepository.saveLabel(label2);
        LabelRepository.saveLabel(label1);


        String test = Label.labelToString(label1);
        Label testLabel = Label.stringToLabel(test);
        LabelRepository.saveLabel(testLabel);
        List<Label> testList = LabelRepository.getAll();
        for (int i = 0; i < testList.size(); i++) {
            LabelRepository.saveLabel(testList.get(i));
        }

        LabelRepository.saveLabel(label3);
        System.out.println("Использование метода getById" + LabelRepository.getById(3).getId() + " " + LabelRepository.getById(3).getCategory());
        LabelRepository.deleteById(3);
        LabelRepository.update(label2, "Cinema");


    }
}

