package com.project;

import com.project.model.Input;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class ParsingFileOne implements Runnable{
    Input input;

    public ParsingFileOne(Input input) {
        this.input = input;
    }

    public ParsingFileOne() {
    }


    @Override
    public synchronized void run() {
//        Input input = new Input();
        String splitBy = ";";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/home/aichler/Документы/stachirovka/TZ/src/main/java/com/project/file/test.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] b;
        HashSet<String> hSetId = new HashSet<>();
        HashSet<String> hSetVersion = new HashSet<>();
        HashSet<String> hSetPath = new HashSet<>();
        while(true){
            try {
                if (!((line = br.readLine()) !=null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            b = line.split(splitBy);

            hSetId.add(b[0]);
            hSetVersion.add(b[1]);
            hSetPath.add(b[2]);
            input.setId(hSetId);
            input.setPath(hSetPath);
            input.setVersion(hSetVersion);

        }

        File file = new File("/home/aichler/Документы/stachirovka/TZ/src/main/java/com/project/file/id.csv");
        File filePath = new File("/home/aichler/Документы/stachirovka/TZ/src/main/java/com/project/file/path.csv");
        File fileVersion = new File("/home/aichler/Документы/stachirovka/TZ/src/main/java/com/project/file/version.csv");
        boolean bool;
        if(file.length() == 0){
            bool = false;
        }else{
            bool = true;
        }
        System.out.println(bool);
        //id
        try(FileWriter writer = new FileWriter(file, bool))
        {

            ArrayList<String> list = new ArrayList(input.getId());
            for (String temp : list){
                writer.write(temp);
                writer.append(';');
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
            //Path
            try(FileWriter writer = new FileWriter(filePath, false))
            {

                ArrayList<String> list = new ArrayList(input.getPath());
                for (String temp : list){
                    writer.write(temp);
                    writer.append(';');
                }
                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
                //version
                try(FileWriter writer = new FileWriter(fileVersion, false))
                {
                    ArrayList<String> list = new ArrayList(input.getVersion());
                    for (String temp : list){
                        writer.write(temp);
                        writer.append(';');
                    }
                    writer.flush();
                }
                catch(IOException ex){
                    System.out.println(ex.getMessage());
                }


        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

