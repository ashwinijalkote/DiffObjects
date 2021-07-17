package com.github.ashwinijalkote.folders;


public class File {
    String name;
    int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        File file = (File) o;
        return size == file.size; // not based on name
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash( size);
//    }
}
