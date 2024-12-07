package com.tananushka.task04;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class containing various intentional flaws:
 * 1. Security Vulnerabilities:
 * - SQL Injection vulnerability in unsafeMethod
 * - Hardcoded credentials
 * - Unclosed database resources
 * 2. Bugs:
 * - Division by zero in faultyLogic
 * - Null pointer potential in processData
 * 3. Code Smells:
 * - Long method
 * - Duplicate code
 * - Magic numbers
 * - Lack of proper exception handling
 */
@RestController
class SampleController {
   // Intentional vulnerability: Hardcoded credentials
   private static final String DB_URL = "jdbc:h2:mem:testdb";
   private static final String DB_USER = "sa";
   private static final String DB_PASSWORD = "password";

   @GetMapping("/unsafe")
   public String unsafeMethod(String input) {
      Connection connection = null;
      Statement statement = null;
      try {
         // Intentional vulnerability: Hardcoded credentials in code
         connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         statement = connection.createStatement();
         // Intentional vulnerability: SQL Injection flaw
         statement.executeQuery("SELECT * FROM user_data WHERE user_name = '" + input + "'");
         return "Data Retrieved";
      } catch (SQLException e) {
         // Intentional code smell: Generic exception handling
         return "Error in SQL Handling";
      }
      // Intentional bug: Resource leak - connection and statement are never closed
   }

   @GetMapping("/logic-error")
   public int faultyLogic() {
      int a = 10;
      int b = 0;
      // Intentional bug: Division by zero
      return a / b;
   }

   // Intentional code smell: Long method with high complexity
   @GetMapping("/complex")
   public List<String> complexMethod() {
      List<String> result = new ArrayList<>();
      // Intentional code smell: Magic numbers
      for (int i = 0; i < 1000; i++) {
         if (i % 2 == 0) {
            result.add("Even" + i);
         } else if (i % 3 == 0) {
            result.add("Divisible by 3: " + i);
         } else if (i % 5 == 0) {
            result.add("Divisible by 5: " + i);
         } else if (i % 7 == 0) {
            result.add("Divisible by 7: " + i);
         }
         // Duplicate code block starts
         String temp = "Processing " + i;
         System.out.println(temp);
         if (temp.length() > 15) {
            result.add(temp);
         }
         // Duplicate code block ends
      }
      return result;
   }

   // Intentional bug: Null pointer exception potential
   @GetMapping("/null-error")
   public String processData(@RequestParam String data) {
      String[] parts = data.split(",");
      // Intentional bug: No null check before accessing array
      return parts[0].toUpperCase();
   }
}