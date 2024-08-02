package org.Sem5;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
//       task1.
//       Создать массив из 9 цифр и записать его в файл, используя поток вывода.
        int[] arr = {1, 5, 7, 8, 5, 3, 6, 9, 4,0,0,0};
//        writeArrayToFile(arr);
//        readArrayFromFile();
//        FileExchange.fileExchangeBufferStream("src/main/resources/inputFile.txt");
    }

    static void writeArrayToFile(int[] arr) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/outputFile.txt")) {
            for (int i : arr) {
                fileOutputStream.write((i + " ").getBytes());
            }
            System.out.println("successful done!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    static void readArrayFromFile() {
        ArrayList<Integer> arrayList = new ArrayList<>();
//        try (FileReader reader = new FileReader("src/main/resources/outputFile.txt")) {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/outputFile.txt")) {
            int n;
            boolean flag = true;
            while ((n = fileInputStream.read()) != -1) {
                char ch = (char) n;
                if (ch == '0' && flag)
                    flag = false;
                else if (ch != ' '){
                    flag = true;
                    try {
                        arrayList.add(Integer.parseInt(String.valueOf(ch)));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        int[] arr = new int[arrayList.size()];
        int i = 0;
        for (Integer integer : arrayList) {
            arr[i++] = integer.intValue();
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
