package Cubes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Folder extends FolderFileClass {

    private ArrayList<Object> listOfFoldersAndFiles = new ArrayList<>();

    public Folder() {

    }

    public Folder(String name) {
        this.name = name;
        this.dateCreated = new Date();
    }

    public void addFolderAndFile(Object obj) {
        listOfFoldersAndFiles.add(obj);
    }

    public void createFolder(String name) {
        listOfFoldersAndFiles.add(new Folder(name));
    }

    public void createFile(String name, int fileSize, FileType fileType) {
        listOfFoldersAndFiles.add(new File(name, fileSize, fileType));
    }

    public int sumFileSize() {
        int sum = 0;
        for (Object obj : listOfFoldersAndFiles) {
            if (obj instanceof File) {
                File file = (File) obj;
                sum += file.fileSize;
            } else if (obj instanceof Folder) {
                Folder folder = (Folder) obj;
                sum += folder.sumFileSize();
            }
        }
        return sum;
    }

    public boolean search(String search) {
        List<String> names = new ArrayList<>();

        for (Object item : listOfFoldersAndFiles) {
            if (item instanceof File) {
                File file = (File) item;
                names.add(file.name);
            } else if (item instanceof Folder) {
                Folder folder = (Folder) item;
                names.add(folder.name);
            }
        }

        System.out.println(names.contains(search));
        return names.contains(search);
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String folderDetails = "Folder Details:\n";
        folderDetails += "Name: " + name + "\n";
        folderDetails += "Date Created: " + dateFormat.format(dateCreated) + "\n";
        folderDetails += "List of files and folders:\n";

        for (Object obj : listOfFoldersAndFiles) {
            if (obj instanceof Folder) {
                Folder folder = (Folder) obj;
                folderDetails += "\t" + folder.toString() + "\n";
            }
            if (obj instanceof File) {
                File file = (File) obj;
                folderDetails += "\t" + file.toString() + "\n";
            }
        }

        return folderDetails;
    }
}