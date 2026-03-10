import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    String group;
    double gpa;

    public Student(String name, String group, double gpa) {
        this.name = name;
        this.group = group;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return name + " (" + group + ", GPA: " + gpa + ")";
    }
}

public class StreamPractice {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 2, 8, 3, 2, 10, 5);

        List<String> words = Arrays.asList("apple", "banana", "avocado", "pear");

        List<Student> students = Arrays.asList(
                new Student("Alice", "CS-1", 3.9),
                new Student("Bob", "CS-1", 3.2),
                new Student("Charlie", "CS-2", 3.7),
                new Student("David", "CS-2", 2.9),
                new Student("Eva", "CS-1", 3.8)
        );

        // 1 Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println("Even numbers: " + evenNumbers);

        // 2 Convert strings to uppercase
        List<String> upper = words.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println("Uppercase: " + upper);

        // 3 Count strings starting with 'a'
        long countA = words.stream()
                .filter(w -> w.startsWith("a"))
                .count();

        System.out.println("Words starting with 'a': " + countA);

        // 4 Sort numbers descending
        List<Integer> sortedDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Sorted desc: " + sortedDesc);

        // 5 Find max and min
        int max = numbers.stream().max(Integer::compare).orElse(0);
        int min = numbers.stream().min(Integer::compare).orElse(0);

        System.out.println("Max: " + max + " Min: " + min);

        // 6 Remove duplicates
        List<Integer> unique = numbers.stream()
                .distinct()
                .toList();

        System.out.println("Unique: " + unique);

        // 7 Join strings
        String joined = words.stream()
                .collect(Collectors.joining(", "));

        System.out.println("Joined: " + joined);

        // 8 Group students by group
        Map<String, List<Student>> grouped =
                students.stream()
                        .collect(Collectors.groupingBy(Student::getGroup));

        System.out.println("Grouped: " + grouped);

        // 9 Average GPA
        double avgGpa =
                students.stream()
                        .mapToDouble(Student::getGpa)
                        .average()
                        .orElse(0);

        System.out.println("Average GPA: " + avgGpa);

        // 10 First 3 students with GPA > 3.5
        List<Student> topStudents =
                students.stream()
                        .filter(s -> s.getGpa() > 3.5)
                        .limit(3)
                        .toList();

        System.out.println("Top students: " + topStudents);

        // 11 Count students GPA > 3.5
        long countTop =
                students.stream()
                        .filter(s -> s.getGpa() > 3.5)
                        .count();

        System.out.println("Students with GPA > 3.5: " + countTop);
    }
}