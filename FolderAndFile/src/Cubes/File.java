package Cubes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class File extends FolderFileClass {

    public int fileSize;
    public FileType fileType;

    public File(String name, int fileSize, FileType fileType) {
        this.name = name;
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.dateCreated = new Date();
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return "Name: " + name + ", Date Created: " + dateFormat.format(dateCreated) + ", File Size: " + fileSize + "MB, Format: " + fileType;
    }
}