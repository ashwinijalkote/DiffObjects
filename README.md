

Compare two nested objects:
--------------------------
Two objects having nested structure, are compared and difference is produced
and displayed in certain format.

Generic Objects:  TO DO
-----------------------

Any two generic object can be compared and their diff should be displayed.


Example 1 : Comparing contents of folder
---------------

Folder object contains list of object which can be File/Folder.

Logic of comparison is based on equals method which is overidden for file and folder.
For file, two files are considered equal if their attributes(except name) are equal.
in this case, only size is added for now, more attributes will be added later.

For Folders, two folders are considered equal if all their nested objects are present in other folder and vice versa.
Here, contains is used which internally calls overriden equals method.

Folder has compareAndDiff method which prints the difference for one level and comparison is done for all levels of nesting.

Two Top level folder when compared shows the common files and folders present in both and it also shows which 
file/folder are present in one top level folder and not present in second top level folder.

Difference in structure of folder is shown only for one level nesting.

eg:


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


Output
-------

       
        Diff in objects: folder1	--->folder2
        file2: Common File
        file1: Common File
        root1NestedFolder1: Common Subdirectory
        root1NestedFolder4 is Present in folder1 ---->Not present folder2
        Not Present in folder1---->root1NestedFolder2 present in folder2
