package com.project;

import com.project.model.Input;
import com.project.model.Input2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class ParsingFileTwo implements Runnable{

    @Override
    public void run() {
        Input2 input2 = new Input2();
        String splitBy = ";";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/home/aichler/Документы/stachirovka/TZ/src/main/java/com/project/file/test1.csv"));
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
        HashSet<String> hSetName = new HashSet<>();
        HashSet<String> hSetSex = new HashSet<>();
        while(true){
            try {
                if (!((line = br.readLine()) !=null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            b = line.split(splitBy);

            hSetId.add(b[0]);
            hSetName.add(b[1]);
            hSetSex.add(b[2]);
            input2.setId(hSetId);
            input2.setName(hSetName);
            input2.setSex(hSetSex);

        }
        File file = new File("/home/aichler/Документы/stachirovka/TZ/src/main/java/com/project/file/id.csv");
        File fileName = new File("/home/aichler/Документы/stachirovka/TZ/src/main/java/com/project/file/name.csv");
        File fileSex = new File("/home/aichler/Документы/stachirovka/TZ/src/main/java/com/project/file/sex.csv");

        boolean bool;
        if(file.length() == 0){
            bool = false;
        }else{
            bool = true;
        }
        System.out.println(bool);
        try(FileWriter writer = new FileWriter(file, bool))
        {
            ArrayList<String> list = new ArrayList(input2.getId());
            for (String temp : list){
                writer.write(temp);
                writer.append(';');
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
            //name
            try(FileWriter writer = new FileWriter(fileName, false))
            {
                ArrayList<String> list = new ArrayList(input2.getName());
                for (String temp : list){
                    writer.write(temp);
                    writer.append(';');
                }
                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }

                //sex
                try(FileWriter writer = new FileWriter(fileSex, false))
                {
                    ArrayList<String> list = new ArrayList(input2.getSex());
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
