package com.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class LoggingApp {

    private static final Logger logger = LoggerFactory.getLogger(LoggingApp.class);

    public static void main(String[] args) {
        logger.info("Application started");

        try (Scanner scanner = new Scanner(System.in)) {
            logger.info("Prompting user for input...");

            System.out.print("Enter integers separated by spaces: ");
            String input = scanner.nextLine();
            logger.info("User input received: {}", input);

            List<Integer> numbers = Arrays.stream(input.split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            logger.debug("Parsed numbers: {}", numbers);

            int sum = numbers.stream().mapToInt(Integer::intValue).sum();
            double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            int max = numbers.stream().mapToInt(Integer::intValue).max().orElse(Integer.MIN_VALUE);

            logger.info("Sum: {}", sum);
            logger.info("Average: {}", average);
            logger.info("Max: {}", max);

            System.out.println("Sum: " + sum);
            System.out.println("Average: " + average);
            System.out.println("Max: " + max);

        } catch (Exception e) {
            logger.error("An error occurred: ", e);
        }

        logger.info("Application ended");
    }
}
