package ru.mirea.inbo_05_19.Kuznetsov.Task1;

public class Sorting {
    public static void InsertionSort(Student array[]) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            Student key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].iDNumber > key.iDNumber) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String args[]) {
        Student array[] = new Student[5];
        String Names[] = new String[]{"Ivan", "Evgeniy", "Alexandr", "Veronika", "Ekaterina"};
        int IDs[] = new int[]{5, 3, 4, 1, 2};
        double AMs[] = new double[]{3.2, 4.1, 3.7, 4.8, 4.5};
        for (int i = 0; i < array.length; i++) {
            array[i] = new Student(Names[i], IDs[i], AMs[i]);
        }
        InsertionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].iDNumber);
        }
    }
}