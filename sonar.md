## SonarQube

### **1. Access SonarQube**

1. Open your browser and navigate to [http://localhost:9000](http://localhost:9000).
2. Log in with the default credentials:
    - **Username:** `admin`
    - **Password:** `admin`
3. You will be prompted to change the default admin password. Choose a secure password and save it.
4. E.g.: `admin` => `task04`

---

### **2. Create a Project**

1. Once logged in, click **Projects** > **Create Project**.
2. Choose **Manually** (if not using GitHub or other integrations).
3. Enter a **Project Key** and **Display Name** (e.g., `task04`).
4. Click **Set Up**.

---

### **3. Generate a Token**

1. During the project setup, you’ll be asked to generate a token for authentication:
    - Name the token (e.g., `task04-token`).
    - Click **Generate** and save the token securely (you’ll need it for Maven or other tools).
    - E.g.: `sqp_afc9ee6c14d09acd2896042122599683912da06f`

---

### **4. Configure Your Maven Project**

1. Add the following to your Maven project’s `pom.xml`:
   ```xml
   <properties>
       <java.version>17</java.version>
       <sonar.projectKey>task04</sonar.projectKey>
       <sonar.host.url>http://localhost:9000</sonar.host.url>
       <sonar.login>your-sonar-token</sonar.login>
   </properties>
   ```
   ```xml
   <build>
       <plugins>
           <plugin>
               <groupId>org.sonarsource.scanner.maven</groupId>
               <artifactId>sonar-maven-plugin</artifactId>
               <version>5.0.0.4389</version>
           </plugin>
       </plugins>
   </build>
   ```

2. In your project directory, run:
   ```bash
   mvn clean verify sonar:sonar
   ```

---

### **5. View Results in SonarQube**

1. After the analysis is complete, go back to the SonarQube web interface.
2. Navigate to your project.
3. Review the results:
    - **Bugs:** Highlighted logical errors.
    - **Vulnerabilities:** Security flaws like SQL injection.
    - **Code Smells:** Refactoring opportunities.

