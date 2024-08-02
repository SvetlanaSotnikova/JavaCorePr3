package src.main.java.org.Sem5HMBackup;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BackupFiles.createDirectoryPath("src/main/java/org/Sem5");
        BackupFiles.createBackupDirectory("src/main/java/org/Sem5HM");
    }
}
