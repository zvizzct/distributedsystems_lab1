package edu.upf;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import edu.upf.filter.FileLanguageFilter;
import edu.upf.uploader.S3Uploader;

public class TwitterFilter {
    public static void main(String[] args) {
        List<String> argsList = Arrays.asList(args);
        String language = argsList.get(0);
        String outputFile = argsList.get(1);
        String bucket = argsList.get(2);
        System.out.println("Language: " + language + ". Output file: " + outputFile +
                ". Destination bucket: " + bucket);
        for (String inputFile : argsList.subList(3, argsList.size())) {

            System.out.println("Processing: " + inputFile);
            try {
                final FileLanguageFilter filter = new FileLanguageFilter(inputFile, outputFile);
                filter.filterLanguage(language);
            } catch (Exception e) {
                System.err.println("ERROR filtering the file: " + e.getMessage());
            }
        }

        try {
            final S3Uploader uploader = new S3Uploader(bucket, "lab1", "default");
            uploader.upload(Arrays.asList(outputFile));
        } catch (Exception e) {
            System.err.println("ERROR uploading to S3: " + e.getMessage());
        }
    }
    // java -cp
    // target/classes:~/.m2/repository/junit/junit/4.11/junit-4.11.jar:~/.m2/repository/com/amazonaws/aws-java-sdk-s3/1.12.399/aws-java-sdk-s3-1.12.399.jar:~/.m2/repository/org/jsoup/jsoup/1.13.1/jsoup-1.13.1.jar:~/.m2/repository/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar
    // edu.upf.TwitterFilter

}
