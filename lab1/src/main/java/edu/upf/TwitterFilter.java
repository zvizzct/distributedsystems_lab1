
package edu.upf;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import edu.upf.filter.FileLanguageFilter;

public class TwitterFilter {
    public static void main(String[] args) throws IOException {
        List<String> argsList = Arrays.asList(args);
        String language = argsList.get(0);
        String outputFile = argsList.get(1);
        String bucket = argsList.get(2);
        System.out.println("Language: " + language + ". Output file: " + outputFile +
                ". Destination bucket: " + bucket);
        for (String inputFile : argsList.subList(3, argsList.size())) {

            System.out.println("Processing: " + inputFile);
            final FileLanguageFilter filter = new FileLanguageFilter(inputFile,
                    outputFile);
            try {
                filter.filterLanguage(language);
            } catch (Exception e) {
                System.err.println("ERROR:" + e.getMessage());
            }
        }

        // final S3Uploader uploader = new S3Uploader(bucket, "prefix", "upf");
        // uploader.upload(Arrays.asList(outputFile));
    }
}
