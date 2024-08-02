package org.Sem5HM.Task1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class BackupFiles {
    public static void createDirectoryPath(String path) {
        File sourcePath = new File(path);
        if (!sourcePath.isDirectory()) {
            System.out.println("The provided path is not a directory: " + sourcePath.getAbsolutePath());
            return;
        }

        File dir = new File(sourcePath, "backup");
        if (!dir.exists()) {
            dir.mkdir();
        } else {
            System.out.println("The provided path already exists: " + dir.getAbsolutePath());
            return;
        }

        File[] files = sourcePath.listFiles((dir1, name) -> new File(dir1, name).isFile());
        if (files != null && files.length > 0) {
            for (File file : files) {
                try {
                    Path source = file.toPath();
                    Path target = Paths.get(dir.getAbsolutePath(), addSuffixFile(file.getName()));
                    Files.copy(source, target);
                    if (file.getName().endsWith(".java")) {
                        updateClassName(target);
                    }
                    System.out.println("File " + file.getName() + "was copied successfully");
                } catch (IOException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        } else {
            System.out.println("No files to backup in directory");
        }
    }

    private static String addSuffixFile(String path) {
        int dot = path.lastIndexOf('.');
        String fileName = dot == -1 ? path : path.substring(0, dot);
        String extension = dot == -1 ? "" : path.substring(dot);
        return fileName + "Backup" + extension;
    }

    private static void updateClassName(Path filePath) throws IOException {
        List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
        String originalClassName = filePath.getFileName().toString().replace(".java", "").replace("Backup", "");
        String newClassName = filePath.getFileName().toString().replace(".java", "");
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, lines.get(i).replace("class " + originalClassName, "class " + newClassName));
        }
        Files.write(filePath, lines, StandardCharsets.UTF_8);
    }

    // в инете нашла
    private static void updateClassName(Path filePath, Path sourcePath, Path backupPath) throws IOException {
        List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
        String originalClassName = filePath.getFileName().toString().replace(".java", "").replace("Backup", "");
        String newClassName = filePath.getFileName().toString().replace(".java", "");

//        String originalPackagePath = getPackagePath(sourcePath, filePath);
//        String newPackagePath = getPackagePath(backupPath, filePath);
        String originalPackagePath = sourcePath.toString().replace(File.separatorChar, '.');
        String newPackagePath = backupPath.toString().replace(File.separatorChar, '.');

        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, lines.get(i).replace("class " + originalClassName, "class " + newClassName));
            if (lines.get(i).startsWith("package ")) {
                lines.set(i, "package " + newPackagePath + ";");
            }
        }
        Files.write(filePath, lines, StandardCharsets.UTF_8);
    }

    private static String getPackagePath(Path basePath, Path filePath) {
        Path relativePath = basePath.relativize(filePath.getParent());
        String packagePath = relativePath.toString().replace(File.separatorChar, '.');
        return "org." + packagePath;
    }

    public static void createBackupDirectory(String path) throws IOException {
        Path sourcePath = Paths.get(path);
        if (!Files.isDirectory(sourcePath)) {
            System.out.println("The provided path is not a directory: " + sourcePath.toAbsolutePath());
            return;
        }

        Path backupPath = sourcePath.resolveSibling(sourcePath.getFileName() + "Backup");
        if (!Files.exists(backupPath)) {
            Files.createDirectory(backupPath);
        }

        Files.walk(sourcePath).forEach(source -> {
            Path target = backupPath.resolve(sourcePath.relativize(source));
            try {
                if (Files.isDirectory(source)) {
                    if (!Files.exists(target)) {
                        Files.createDirectory(target);
                    }
                } else {
                    Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                    if (source.toString().endsWith(".java")) {
                        updateClassName(target, sourcePath, backupPath);
                    }
                }
                System.out.println("File " + source + " was copied successfully");
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        });
    }
}
