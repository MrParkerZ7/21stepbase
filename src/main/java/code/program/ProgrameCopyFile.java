package code.program;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class ProgrameCopyFile {

    static class CoppyFile {

        static void fileInOut(String pathIn, String pathOut) {
            try (FileInputStream fileIn = new FileInputStream(pathIn);
                 FileOutputStream fileOut = new FileOutputStream(pathOut)) {
                byte[] data = new byte[512];
                while (fileIn.read(data) != -1) {
                    fileOut.write(data);
                }
                System.out.println("Copy file successful!!");
            } catch (IOException e) {
                System.out.println("Erro_r: " + e);
            }
        }
    }

    public static void main(String[] args) {
        for (String in : args) {
            if (in.contains("cp")) {
                String pathOut = "C:\\Users\\Parky_z7\\Desktop\\4k-copy.jpg";
                String[] command = in.split("_");

                CoppyFile.fileInOut(command[1], pathOut);
            }
        }
    }
}

//                "cp"
//                "E:\\BackProject\\IdeaProjects\\-MyProject\\21-day-base\\4k.jpg"
//                "C:\\Users\\Parky_z7\\Desktop\\4k-copy.jpg"
