package Cubes;

public class MainClass {

    public static void main(String[] args) {
        Folder folder1 = new Folder("Main Folder");
        File file1 = new File("50 Cent", 4, FileType.MP3);
        File file2 = new File("Metalica", 5, FileType.MP3);
        File file3 = new File("The Ramones", 2, FileType.MP3);
        folder1.addFolderAndFile(file1);
        folder1.addFolderAndFile(file2);
        Folder folder3 = new Folder("Empty");
        folder1.addFolderAndFile(folder3);
        
        Folder folder2 = new Folder("Music");
        folder2.addFolderAndFile(file3);
        
        folder1.addFolderAndFile(folder2);
        
        System.out.println(folder1);
        System.out.println("------------------------");
        
        folder1.createFolder("Java tutorial");
        folder1.createFile("Lesson 1", 14, FileType.PDF);
        
        folder1.search("Music");
        folder1.search("Videos");
        folder2.search("The Ramones");
        int totalSizeOfFiles = folder1.sumFileSize();
        System.out.println("Total Size Of Files: " + totalSizeOfFiles + "MB");
    }
}