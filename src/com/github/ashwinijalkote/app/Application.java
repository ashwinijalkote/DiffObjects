package com.github.ashwinijalkote.app;


import com.github.ashwinijalkote.folders.File;
import com.github.ashwinijalkote.folders.Folder;

import java.util.List;

public class Application {

    public static void main(String args[]) {

        File file1 = new File("file1", 10);
        File file2 = new File("file2", 20);
        File file3 = new File("file3", 30);
        File file4 = new File("file4", 40);

        Folder nestedFolder1 = new Folder("root1NestedFolder1", 50, List.of(file3));
        Folder nestedFolder3 = new Folder("root1NestedFolder3", 50, List.of(file3));
        Folder nestedFolder2 = new Folder("root1NestedFolder2", 50, List.of(file3, file4));
        Folder nestedFolder4= new Folder("root1NestedFolder4", 50, List.of(file1, file4));
        Folder root1 = new Folder("folder1", 30, List.of(file2, file1, nestedFolder1, nestedFolder4));
        Folder root2 = new Folder("folder2", 30, List.of(file1, nestedFolder2, nestedFolder3, file2));


        root1.compareAndDiff(root2);
    }
}
