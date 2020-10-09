package ru.mirea.inbo_05_19.Kuznetsov.Task3;

public class Unite {
    public static Student[] Unite(Student[] a, Student[] b) {
        Student[] z = new Student[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            z[i] = a[i];
        }
        for (int i = a.length; i < z.length; i++) {
            z[i] = b[i - a.length];
        }
        return z;
    }

    public static Student[] MergeSort(Student[] a) {
        if (a.length < 2) {
            return null;
        }
        int mid = a.length / 2;
        Student[] l = new Student[mid];
        Student[] r = new Student[a.length - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < a.length; i++) {
            r[i - mid] = a[i];
        }
        MergeSort(l);
        MergeSort(r);
        Merge(a, l, r, mid, a.length - mid);
        return a;
    }

    public static void Merge(Student[] a, Student[] l, Student[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i].iDNumber <= r[j].iDNumber) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void main(String[] args) {
        Student array2[] = new Student[5];
        Student array1[] = new Student[3];
        String Names2[] = new String[]{"Ivan", "Evgeniy", "Alexandr", "Veronika", "Ekaterina"};
        String Names1[] = new String[]{"Svyatoslav", "Roman", "Andrey"};
        int IDs2[] = new int[]{5, 3, 4, 1, 2};
        int IDs1[] = new int[]{8, 6, 7};
        double AMs2[] = new double[]{3.2, 4.1, 3.7, 4.8, 4.5};
        double AMs1[] = new double[]{3.5, 5.0, 4.4};
        for (int z = 0; z < 5; z++) {
            array2[z] = new Student(Names2[z], IDs2[z], AMs2[z]);
        }
        for (int z = 0; z < 3; z++) {
            array1[z] = new Student(Names1[z], IDs1[z], AMs1[z]);
        }
        array1 = MergeSort(Unite(array1, array2));
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i].iDNumber);
        }
    }
}