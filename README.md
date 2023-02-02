# Lab 1: Getting Started with Java, AWS-SDK and S3
## Large Scale Distributed Systems - 2022/23 Edition

### Objectives
The goal of this lab is to create a small Java command line application called TwitterFilter. The application filters a collection of files containing tweets in JSON format and copies all tweets in a specified language into a new file. The filtered tweets are then uploaded to Amazon S3 in a given bucket.

### Usage
The application takes in the following parameters:

- a 2 character string representing a language in ISO 639-1 standard
- the name of a local output file to temporarily store the filtered tweets
- the name for a bucket on S3 where to upload the filtered tweets
- one or more file paths to process the tweets from

Example: `TwitterFilter es /tmp/output-es.txt test-bucket f1.json f2.json f3.json`

This command will read 3 files (f1.json, f2.json, f3.json), generate a new output file `/tmp/output-es.txt` containing all the Spanish (es) language tweets, and then upload the file to an S3 bucket named `test-bucket`.


### Dependencies
The lab uses two external libraries:

- GSON (version 2.8.6) developed by Google, one of the most used solutions for handling JSON content in Java.
- AWS-SDK for Amazon S3 (version 1.11.xxx) created by Amazon, to access S3 from Java code.
