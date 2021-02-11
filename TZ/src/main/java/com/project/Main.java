package com.project;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.project.model.Input;

class Main{
    public static void main(String[] args) throws Exception {
        File file = new File("/home/aichler/Документы/stachirovka/TZ/src/main/java/com/project/file/id.csv");
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
        Input input = new Input();
        ParsingFileOne thread = new ParsingFileOne();
        ParsingFileTwo parsingFileTwo = new ParsingFileTwo();
        ExecutorService es = Executors.newFixedThreadPool(5);
        System.out.println(" Зaпycк потоков ");
            es.submit(new ParsingFileTwo());
            es.submit(new ParsingFileOne());
            es.shutdown();
    }

}
