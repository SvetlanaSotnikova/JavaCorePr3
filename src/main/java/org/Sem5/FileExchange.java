package org.Sem5;

import java.io.*;
import java.util.ArrayList;

public class FileExchange {
    public static void main(String[] args) throws IOException {
        String file = "src/main/resources/inputFile.txt";
        System.out.println(fileExchangeBufferStream(file));
        exchangeChar("f", file);
        System.out.println(fileExchangeBufferStream(file));
    }
    public static void fileExchangeStream(String file) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] bytes = fileInputStream.readAllBytes();
            String content = new String(bytes);

            String[] numbers = content.trim().split("\\s+");
            for (String number : numbers) {
                try {
                    arrayList.add(Integer.parseInt(number));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public static String fileExchangeBufferStream(String file) throws IOException {
       try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))){
           return new String(bufferedInputStream.readAllBytes());
       }
    }
    public static void exchangeChar(String exchangeChar, String file) throws IOException {
        String str = fileExchangeBufferStream(file);
        str = str.replaceAll(exchangeChar, "**");
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file))){
            bufferedOutputStream.write(str.getBytes());
        }
    }
}
