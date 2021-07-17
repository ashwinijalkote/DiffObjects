package com.github.ashwinijalkote.folders;

import java.util.List;

public class Folder {
    String name;
    int size;
    List<Object> objects;

    public Folder(String name, int size, List<Object> objects) {
        this.name = name;
        this.size = size;
        this.objects = objects;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public List<Object> getObjects() {
        return objects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Folder that = (Folder) o;
        if (size != that.size) {
            return false;
        }

        if (this.objects == null && that.objects == null) return true;

        boolean allMatchInSecond = true;
        boolean allMatchInFirst = true;
        if (this.objects != null) {
            allMatchInSecond = this.objects.stream().allMatch(obj -> (that.objects != null && that.objects.contains(obj)));
        }

        if (that.objects != null) {
            allMatchInFirst = that.objects.stream().allMatch(obj -> (this.objects != null && this.objects.contains(obj)));
        }
        return allMatchInFirst && allMatchInSecond;
    }

//        @Override
//        public int hashCode () {
//            return Objects.hash(size, objects);
//        }

        public void compareAndDiff(Object o) {
            Folder that = (Folder) o;
            if (this.equals(o) == true) return;

            System.out.println("\nDiff in objects: " + this.name + "\t--->" + that.getName());
            if (this.objects != null) {
                this.objects.forEach(obj -> {
                    if (that.objects == null || !that.objects.contains(obj)) {
                        if (obj instanceof File) {
                            System.out.println(((File) obj).getName() + " is Present in " + this.getName()+  "--- ---->" + "Not present in " + that.getName());
                        } else {
                            System.out.println(((Folder) obj).getName() + " is Present in " + this.getName()+  " ---->" + "Not present " + that.getName());
                        }
                    } else {
                        if (obj instanceof File) {
                            System.out.println(((File) obj).getName() + ": Common File");
                        } else {
                            System.out.println(((Folder) obj).getName() + ": Common Subdirectory");
                        }
                    }
                });
            }

            if (that.objects != null) {
                that.objects.forEach(obj -> {
                    if (this.objects == null || !this.objects.contains(obj)) {
                        if (obj instanceof File) {
                            System.out.println("Not Present in" +   this.getName()+ " ---->" + ((File) obj).getName() + " present in " + that.getName());
                        } else {
                            System.out.println("Not Present in " + this.getName() + "---->" + ((Folder) obj).getName() + " present in " + that.getName());
                        }

                    }
                });
            }
        }
    }
