package com.lzl.od;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 智能成绩表
 */
public class T7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentNums = sc.nextInt();
        int xks = sc.nextInt();
        List<String> subjects = new ArrayList<>();
        for (int i = 0; i < xks; i++) {
            String xuekei = sc.next();
            subjects.add(xuekei);
        }
        List<Student> l = new ArrayList<>();
        for (int i = 0; i < studentNums; i++) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            Student student = new Student();
            String name = s1[0];
            student.name = name;
            for (int i1 = 1; i1 < s1.length; i1++) {
                String s2 = s1[i1];
                student.subjects.put(subjects.get(i1 - 1), Integer.valueOf(s2));
            }
            l.add(student);
        }
        sc.next();
        String f = sc.nextLine();
        if (!subjects.contains(f)) {
            l.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    int sum = o1.subjects.values().stream().mapToInt(i -> i).sum();
                    int sum1 = o2.subjects.values().stream().mapToInt(i -> i).sum();
                    int i = sum - sum1;
                    if (i == 0) {
                        return o1.name.compareTo(o2.name);
                    } else {
                        return i;
                    }

                }
            });
        } else {
            l.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    int i = o1.subjects.get(f).compareTo(o2.subjects.get(f));
                    if (i == 0) {
                        return o1.name.compareTo(o2.name);
                    } else {
                        return i;
                    }
                }
            });
        }
        System.out.println(l.stream().map(o -> o.name).collect(Collectors.joining(" ")));

    }
}

class Student {
    public String name = "";
    public Map<String, Integer> subjects = new HashMap<>();
}
