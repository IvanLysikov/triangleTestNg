package org.example;

import org.example.exeptions.TriangleNotExistsException;
import org.example.exeptions.NotEnoughDataException;
import org.example.exeptions.OutOfRangeException;
import org.example.exeptions.TriangleException;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> userInputData = getDataFromUser();
        String result = processTriangleData(userInputData);
        System.out.println(result);
    }

    private static List<String> getDataFromUser(){
        List<String> userInputData = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number:");
        userInputData.add(scanner.nextLine());
        System.out.println("Enter second number:");
        userInputData.add(scanner.nextLine());
        System.out.println("Enter third number:");
        userInputData.add(scanner.nextLine());
        return userInputData;
    }

    public static String processTriangleData(List<String> userInputData){
        List<Integer> triangleSides = new ArrayList<>();
        try {
            triangleSides = processInputData(userInputData);
            String triangleType = calculateTriangleType(triangleSides);
            return String.format("triangle with sides %s is %s", userInputData, triangleType);

        } catch (TriangleException e) {
            return String.format(e.getMessage());
        }
    }

    private static String calculateTriangleType(List<Integer> triangleSides) {
        Set<Integer> triangleSidesSet = new HashSet<>(triangleSides);
        return switch (triangleSidesSet.size()) {
            case 1 -> "equilateral";
            case 2 -> "isosceles";
            default -> "scalene";
        };
    }

    private static void validateInputData(List<Integer> triangleSides) {
        if (triangleSides.stream().anyMatch(value -> value < 1)) {
            throw new OutOfRangeException();
        }

        long sum = triangleSides.stream()
                .mapToLong(Integer::longValue) // Convert Integer to int
                .sum();

        boolean hasValueEqualToHalfSum = triangleSides.stream()
                .anyMatch(num -> (num >= sum / 2.0));

        if (hasValueEqualToHalfSum) {
            throw new TriangleNotExistsException();
        }
    }

    private static List<Integer> processInputData(List<String> userInputData) {
        if (userInputData.stream().anyMatch(""::equals)) {
            throw new NotEnoughDataException();
        }

        List<Integer> intTriangleSides = null;
        try {
            intTriangleSides = userInputData.stream().map(Integer::parseInt).toList();
        } catch (Exception e) {
            throw new OutOfRangeException();
        }

        validateInputData(intTriangleSides);

        return intTriangleSides;
    }
}
