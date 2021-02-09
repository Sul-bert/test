package com.ssy.test.jsr269.demo;

import org.apache.commons.io.FileUtils;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.io.File;
import java.io.IOException;
import java.util.Set;

@SupportedAnnotationTypes({"com.ssy.test.jsr269.annotation.Show"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class MyProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        String filePath = "E:\\temp\\1.txt";

        try {
            FileUtils.writeStringToFile(new File(filePath), "进入MyProcessor", "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (TypeElement annotation : annotations) {
            try {
                FileUtils.writeStringToFile(new File(filePath), annotation.toString(), "utf-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileUtils.writeStringToFile(new File(filePath), roundEnv.toString(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
