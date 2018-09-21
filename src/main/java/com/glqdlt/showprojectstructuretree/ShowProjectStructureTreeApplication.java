package com.glqdlt.showprojectstructuretree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

import static com.glqdlt.showprojectstructuretree.Utill.renderFolder;

@SpringBootApplication
public class ShowProjectStructureTreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowProjectStructureTreeApplication.class, args);

        File folder = new File((args.length >= 1 && args[0].length() > 0)
                ? args[0]
                : ".");

        if (!folder.isDirectory())
        {
            throw new IllegalArgumentException("Invalid directory: " + folder.getName());
        }

        int level = 0;
        System.out.println(renderFolder(folder, level, new StringBuilder(), false));

    }
}
