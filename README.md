# Lab 1: Getting Started with Java, AWS-SDK and S3
## Large Scale Distributed Systems - 2022/23 Edition

### Objectives
The goal of this lab is to create a small Java command line application called TwitterFilter. The application filters a collection of files containing tweets in JSON format and copies all tweets in a specified language into a new file. The filtered tweets are then uploaded to Amazon S3 in a given bucket.

### Usage
First, build the app with `mvn package`. Then, navigate to the `target` folder and run the app with the jar file named `lab1-1.0.jar`:

The application takes in the following parameters:

- [language]: a 2 character string representing a language in ISO 639-1 standard
- [output file]: the name of a local output file to temporarily store the filtered tweets
- [bucket]: the name for a bucket on S3 where to upload the filtered tweets
- [input file(s)]: one or more file paths to process the tweets from

Example: `java -cp lab1-1.0.jar edu.upf.TwitterFilter es /tmp/output.txt testbucket Eurovision3.json Eurovision4.json Eurovision5.json`

This command will read 3 files (Eurovision3.json, Eurovision4.json, Eurovision5.json), generate a new output file `/tmp/output-es.txt` containing all the Spanish (es) language tweets, and then upload the file to an S3 bucket named `testbucket`.


### Dependencies
The lab uses two external libraries:

- GSON (version 2.2.4) developed by Google, one of the most used solutions for handling JSON content in Java.
- AWS-SDK for Amazon S3 (version 1.12.399) created by Amazon, to access S3 from Java code.
- JUnit (version 4.13.1) for testing.
- JSoup (version 1.15.3) for parsing HTML.
