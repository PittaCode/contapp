package com.pittacode.contapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Override
    public void run(String... args) {
        String[] classpathEntries = System.getProperty("java.class.path").split(":");
        System.out.println(
                "CLASSPATH"
                        + System.lineSeparator()
                        + "==============================================");
        Arrays.stream(classpathEntries)
                .sorted()
                .forEach(System.out::println);
        System.out.println("==============================================");
    }
}
