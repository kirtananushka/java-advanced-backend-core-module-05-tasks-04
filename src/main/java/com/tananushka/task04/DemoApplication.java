package com.tananushka.task04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
   // Intentional code smell: Private constructor in utility class
   private DemoApplication() {
      // Empty private constructor
   }

   public static void main(String[] args) {
      // Intentional code smell: Direct use of System.out instead of proper logging
      System.out.println("Application starting...");
      SpringApplication.run(DemoApplication.class, args);
   }

   // Intentional code smell: Unused private method
   private static void unusedMethod() {
      System.out.println("This method is never called");
   }
}
