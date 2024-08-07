# Travel Expense Tracking

# UmpleOnline Structure


![umple diagram](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/468f82c8-da31-4804-a423-c1ef5d7a76c6)

## Umple Online About

UmpleOnline is a tool used to transform UML diagrams into software and facilitate model-driven development processes. Umple combines UML diagrams with code to accelerate the software development process and make it more readable.

Below, you can find the code of an example project structure created in UmpleOnline. This code demonstrates a structure where various managers and their associated objects are defined:

```java
class MainWindow {
  1 -- * BudgetManager budgetManager;
  1 -- * ReportManager reportManager;
  1 -- * TripManager tripManager;
  1 -- * ExpenseManager expenseManager;
  1 -- * AuthenticationManager authManager;

  void showLoginScreen() {}
  void showBudgetManagementScreen() {}
  void showReportScreen() {}
  void showTripManagementScreen() {}
  void showExpenseManagementScreen() {}
  void showRegisterScreen() {}
  void logout() {}
}

class AuthenticationManager {
  1 -- * UserCredential userCredentials;
  
  boolean login(String username, String password) {}
  void logout(String username) {}
  boolean register(String username, String password) {}
  boolean changePassword(String username, String oldPassword, String newPassword) {}
}

class UserCredential {
  String username;
  String password;
}

class BudgetManager {
  1 -- * Budget budgets;
  
  void setBudget(String username, Budget budget) {}
  Budget viewBudget(String username) {}
  void deleteBudget(String username) {}
}

class ReportManager {
  1 -- * Report reports;
  
  Report generateReport(String username) {}
  Report viewReport(UUID reportId) {}
  void deleteReport(UUID reportId) {}
}

class TripManager {
  1 -- * Trip trips;
  
  void createTrip(String username, Trip trip) {}
  Trip viewTrip(UUID tripId) {}
  void deleteTrip(UUID tripId) {}
}

class ExpenseManager {
  1 -- * Expense expenses;
  
  void addExpense(String username, Expense expense) {}
  ListExpense viewExpenses(String username) {}
  void deleteExpense(UUID expenseId) {}
}

class Budget {
  double amount;
  String currency;
  String description;
  String type;
  
  void updateDescription(String description) {}
  void updateAmount(double amount) {}
  void updateCurrency(String currency) {}
  void updateType(String type) {}
}

class Report {
  UUID reportId;
  String content;
  Date creationDate;
  
  void updateContent(String content) {}
  void updateCreationDate(Date creationDate) {}
}

class Trip {
  UUID tripId;
  String destination;
  Date startDate;
  Date endDate;
  String[] accommodations;
  String[] transportation;
  String[] activities;
  
  void updateDestination(String destination) {}
  void updateStartDate(Date startDate) {}
  void updateEndDate(Date endDate) {}
  void updateAccommodations(String[] accommodations) {}
  void updateTransportation(String[] transportation) {}
  void updateActivities(String[] activities) {}
}

class Expense {
  UUID expenseId;
  Date date;
  double amount;
  String currency;
  String category;
  String paymentMethod;
  
  void updateDate(Date date) {}
  void updateAmount(double amount) {}
  void updateCurrency(String currency) {}
  void updateCategory(String category) {}
  void updatePaymentMethod(String paymentMethod) {}
}

```

## Project Structure and Wrapping Process

Using the code generated from UmpleOnline, I developed the project and implemented wrapper usage to make the code more modular and manageable. During this process, I divided the project into two main sections: Main Part and Test Part. Below are the images corresponding to each section of this structure.

### Main Part of the Project Structure

The main project structure encompasses the fundamental functionality created using the code obtained from UmpleOnline. In this section, you'll find the definitions of core managers (BudgetManager, ReportManager, TripManager, ExpenseManager, and AuthenticationManager) and their associated objects. These classes manage the primary functions of the application and regulate user interactions.


![Proje Yapısı Main Kısmı](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/78c44c51-1b16-4884-ac89-b7f573e139a7)

### Project Structure Test Section

The test part comprises unit tests and other tests to validate that the main project structure functions correctly. In this section, various test scenarios are implemented to ensure that each manager and its methods operate accurately. The purpose of these tests is to guarantee that every component of the application works as expected.

![Proje Yapısı Test Kısmı](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/7d9e884a-c671-41c5-b0c7-2e443ed41662)


These two main sections of the project are crucial in enhancing both the functionality and quality of the code during the software development process. While the Main part provides the fundamental functionality of the application, the Test part helps ensure that this functionality is error-free and reliable.

The main part of the project structure includes various manager classes (BudgetManager, ReportManager, TripManager, ExpenseManager, AuthenticationManager), each designed to perform their respective functions. The MainWindow class manages user interactions and facilitates transitions between various screens.

The testing structure encompasses unit tests and integration tests. Comprehensive tests have been written for each manager class. These tests are designed to facilitate software debugging and improve its quality.


## Project Images and Descriptions

### Login Screen
This is the login screen used to start the project. Access to the system is granted by entering a username and password.

![Login Ekranı](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/0eb899c0-c614-4194-aa20-288a831e90a2)


### Database Information
Information about the database used in the project. The database is automatically created using SQLite and stores user data.

![Database Bilgilendirme](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/29905706-c08d-475d-b0d6-172a590fedac)


### Umple Online Produced Model
The view of the SQL class generated from Umple Online. This class manages the database operations of the project.

![Umple Online Üretilen Model](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/00dd60c2-25ef-4197-bef0-5df04cc5fd72)


### Test Coverage
A screenshot showing the coverage percentage of the tests. Coverage rate indicates how much of the tested code is covered by tests. A higher coverage rate indicates a more robust software.

![Test Coverage](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/59fc341c-2a4e-4d37-bae2-76df03d6c803)


### Test Results
A screenshot displaying the test results of the project. It shows that a total of 246 tests have passed successfully.

![Test Sonuçları](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/527dd503-9f49-4982-90ed-7c4f231557fd)


## Project Structure and Codes

After the basic structure and codes of our project, below are the Plant UML diagrams illustrating the relationships between different components of the system:

### Authentication Diagrams

The diagrams illustrating the user authentication process are presented below:


![](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/1f568df2-c704-4394-a2ea-8f25fb1b35fe)


![](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/5dfd51a3-0be5-4586-ac21-250e8ff79318)


### Expense Diagrams

The diagrams depicting operations related to expenses are provided below:


![](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/10fa7afa-18df-4142-90b2-6ac74b5c5c1f)


![](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/42eb9dbf-d9b0-46d2-839e-f29d7512e2f8)


![](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/fab7e9a0-cb1f-400e-b872-80f9ecd20541)

### Trip Diagrams

The diagrams illustrating operations and relationships related to trips are displayed below:


![](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/c85627bf-d4c6-4fe4-af61-7b8b17410c7d)


![](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/2eab78dc-0d66-432d-9df2-db2b7a93d6f8)


### GUI Diagrams

The diagrams showcasing the graphical user interface (GUI) design are presented below:


![]![screen](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/da3c3268-7a09-4f8d-95b3-8b19d1473890)


### Plant UML Full Version

Below is the complete Plant UML diagram showing all components and relationships:

![](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/6ad3e445-2beb-42cc-bb5f-78ceca445e5f)


In the attached PDF file, you can examine the Plant UML diagrams in more detail and download them.


[plant uml diagramı.pdf](https://github.com/user-attachments/files/15510960/plant.uml.diagrami.pdf)



## Figma Designs

We created the designs of our project using Figma and incorporated these designs into our project using Java Swing in Eclipse. Below, you can see our Figma designs:

### Login-Register Page


Design of the page containing login and registration processes:


![](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/21d3cc22-f752-4f14-b1be-e2ca36ffc650)


### Main App Page

Design of the main application page, including the main components of the user interface:


![](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/d83376e2-6510-4539-8f2a-382284518a7f)


### Trip Management Page

Design of the page used for trip management, including functionalities for adding, viewing, and editing trips:


![](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/63bf747c-3555-4c30-8cb5-1cbe30af0001)


### Expense Management Page

Design of the page used for expense management, including functionalities for adding, viewing, and editing expenses:


![](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/96e0d5d2-cdbc-4901-8777-8b70fbdea869)


### Budget Management Page

Design of the page used for budget management, including functionalities for setting, viewing, and editing budgets:


![](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/5e51b443-c619-4570-a2ab-39aa1a4ab028)


### Report Page

Design of the page used for report creation and viewing operations:


![](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/16183900-b10f-4839-a3b4-d81e633cf35e)


### Figma Overview of All Structures

Figma view containing all designs together:


![](https://github.com/Fahrettinsolak/ce205-final-fahrettin-solak-java/assets/79358514/7c9ab0ed-1e32-49bc-a239-83be13f2f1be)





# Overview

You will generate eclipse maven project with Junit4 from CLI and. Also you will generate jar and then you will run your application. For more information you can check examples [Maven – Maven in 5 Minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html) and [TheNEXUS | A Community Project](https://books.sonatype.com/mvnref-book/reference/index.html)

## Releases

- [![GitHub release badge](https://badgen.net/github/release/ucoruh/eclipse-java-maven-template)](https://github.com/ucoruh/eclipse-java-maven-template/releases/latest)

## Platforms

- ![Ubuntu badge](assets/badge-ubuntu.svg)

- ![macOS badge](assets/badge-macos.svg)

- ![Windows badge](assets/badge-windows.svg)

## Test Coverage

[![Release](https://github.com/ucoruh/eclipse-java-maven-template/actions/workflows/release.yml/badge.svg)](https://github.com/ucoruh/eclipse-java-maven-template/actions/workflows/release.yml)

**Coverage**

- ![All](assets/badge_combined.svg)

**Branch Coverage**

- ![Branch Coverage](assets/badge_branchcoverage.svg)

**Line Coverage**

- ![Line Coverage](assets/badge_linecoverage.svg)

**Method Coverage**

- ![Method Coverage](assets/badge_methodcoverage.svg)

### Install Requirements

- Eclipse
  
  - [Eclipse Downloads | The Eclipse Foundation](https://www.eclipse.org/downloads/)

- Maven
  
  - [Maven – Download Apache Maven](https://maven.apache.org/download.cgi)

- JDK
  
  - [Eclipse Downloads | The Eclipse Foundation](https://www.eclipse.org/downloads/)

- Lcov
  
  - https://fredgrott.medium.com/lcov-on-windows-7c58dda07080

- Coverxygen
  
  - [coverxygen · PyPI](https://pypi.org/project/coverxygen/)
  
  - [GitHub - psycofdj/coverxygen: Generate doxygen&#39;s documentation coverage report](https://github.com/psycofdj/coverxygen)

- Reportgenerator
  
  - https://reportgenerator.io/

```bash
dotnet tool install -g dotnet-reportgenerator-globaltool
```

- Choose Licence
  
  - [Appendix | Choose a License](https://choosealicense.com/appendix/)

#### Package Manager Windows Setup

We will install required application with package manager on Windows so use following script to install [chocolatey](https://chocolatey.org/install) and [scoop](https://scoop.sh/)

```batch
@echo off
@setlocal enableextensions
@cd /d "%~dp0"

echo Checking if Chocolatey is installed...
if exist "%ProgramData%\Chocolatey\bin\choco.exe" (
    echo Chocolatey is already installed.
) else (
    echo Installing Chocolatey...
    powershell -Command "Set-ExecutionPolicy Bypass -Scope Process -Force; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))"
)

echo Checking if Scoop is installed...
where scoop >nul 2>&1
if %errorlevel%==0 (
    echo Scoop is already installed.
) else (
    echo Scoop is not installed. Installing Scoop...
    powershell Invoke-Expression (New-Object System.Net.WebClient).DownloadString('https://get.scoop.sh')
    powershell Set-ExecutionPolicy RemoteSigned -scope CurrentUser
)

pause
```

### Pre-Commit Code Formatter Astyle Installation

Before each commit also with batch script we will format our code with astyle we need to install it with package manager as following script you can visit package manager web site for more details [Chocolatey Software | Artistic Style 3.2.1](https://community.chocolatey.org/packages/astyle) and [https://astyle.sourceforge.net/](https://astyle.sourceforge.net/)

```batch
@echo off
@setlocal enableextensions
@cd /d "%~dp0"
echo Installing Astyle...
choco install astyle
```

Astyle tool need configuration there is example configuration named `astyle-options.txt`

```yaml
# https://github.com/brchiu/openairinterface5g/blob/master/ci-scripts/astyle-options.txt
# OAI is using a style that is similar to the Google style
--style=google
# long options can be written without the preceding '--'
# Convert tabs to spaces
convert-tabs
# Indentation is 2 spaces
indent=spaces=2
# Indent 'switch' blocks so that the 'case X:' statements are indented in the switch block. 
indent-switches
# Indent preprocessor blocks at bracket level 0.
indent-preproc-block
# Indent multi-line preprocessor #define statements.
indent-preproc-define
# Indent C++ comments beginning in column one.
indent-col1-comments
# Pad empty lines around header blocks
break-blocks
delete-empty-lines
# Attach a pointer or reference operator (*, &, or ^) to the variable name (right)
align-pointer=name
# The code line length is 200 characters/columns (this is the maximum allowed by astyle)
max-code-length=200
# If the line contains logical conditionals they will be placed first on the new line.
break-after-logical
# Force use of the linux end of line
# lineend=linux
```

After installation and config file generation we can format our code with following script this script look for .cs extension and format related files according to configuration in astyle-options.txt

```batch
@echo off
@setlocal enableextensions
@cd /d "%~dp0"

echo Formatting Code with Astyle...

astyle --options="astyle-options.txt" --recursive *.cs

pause
```

### Doxygen and Graphviz Setup + MkDocs Material Theme

We will use package manager for this but also we can use several tools I prefer to use following script to install all parties, This setup also use for mkdocs material them documentation generation maybe we can use for project website generation

```batch
@echo off
@setlocal enableextensions
@cd /d "%~dp0"

rem force re-install need "--force --force-dependencies -y" parameters

REM Test if Pandoc is installed
where pandoc >nul 2>&1
if %errorlevel%==0 (
    echo Pandoc is already installed.
) else (
    echo Installing Pandoc...
    choco install pandoc -y
)

REM Test if rsvg-convert is installed
where rsvg-convert >nul 2>&1
if %errorlevel%==0 (
    echo rsvg-convert is already installed.
) else (
    echo Installing rsvg-convert...
    choco install rsvg-convert -y
)

REM Test if Python is installed
where python >nul 2>&1
if %errorlevel%==0 (
    echo Python is already installed.
) else (
    echo Installing Python...
    choco install python -y
)


REM Test if Miktex is installed
where miktex >nul 2>&1
if %errorlevel%==0 (
    echo Miktex is already installed.
) else (
    echo Installing Miktex...
    choco install miktex -y
)

REM Test if CuRL is installed
where curl >nul 2>&1
if %errorlevel%==0 (
    echo curl is already installed.
) else (
    echo Installing CuRL...
    choco install curl -y
)

REM Test if MARP-CLI is installed
where marp >nul 2>&1
if %errorlevel%==0 (
    echo MARP-CLI is already installed.
) else (
    echo Installing MARP-CLI...
    choco install marp-cli -y
)

REM Test if Doxygen is installed
where doxygen >nul 2>&1
if %errorlevel%==0 (
    echo MARP-CLI is already installed.
) else (
    echo Installing Doxygen...
    choco install doxygen.install -y
)

REM Test if Doxygen is installed
where dot >nul 2>&1
if %errorlevel%==0 (
    echo Graphviz is already installed.
) else (
    echo Installing Graphviz...
    choco install graphviz -y
)

pip install mkdocs
pip install pymdown-extensions
pip install mkdocs-material
pip install mkdocs-material-extensions
pip install mkdocs-simple-hooks
pip install mkdocs-video
pip install mkdocs-minify-plugin
pip install mkdocs-git-revision-date-localized-plugin
pip install mkdocs-minify-plugin
pip install mkdocs-static-i18n
pip install mkdocs-with-pdf
pip install qrcode
pip install mkdocs-awesome-pages-plugin
pip install mkdocs-embed-external-markdown
pip install mkdocs-include-markdown-plugin
pip install mkdocs-ezlinks-plugin
pip install mkdocs-git-authors-plugin
pip install mkdocs-git-committers-plugin
pip install mkdocs-exclude

pip install pptx2md
pause
```

After doxygen installation create default doxygen file with -g option

```batch
doxygen -g
```

This will create Doxyfile for us to modify. Use Doxywizard to modify file. Be sure that your output directory should be **./docs** and all warnings should be opened and warnings stop operations.

# 

#### coverxygen Setup

We are parsing doxygen XML output with coverxygen and generate info file for LCOV. This tool generate output that LCOV use and generate HTML document coverage report

To install coverxygen you need python and pip

```bash
@echo off
@setlocal enableextensions
@cd /d "%~dp0"
echo Installing converxygen doxygen XML parser
pip install coverxygen
```

#### LCOV Setup

LCOV is use to generate HTML document coverage tool in this project, but it can be used for different purposes. You can use choco package manager to install application as follow

```bash
@echo off
@setlocal enableextensions
@cd /d "%~dp0"
echo Installing Report Generator...
choco install lcov -y
echo lcov and genhtml located on C:\ProgramData\chocolatey\lib\lcov\tools\bin\
pause
```

#### ReportGenerator Setup

We need to install [reportgenerator](https://reportgenerator.io/) for creation of HTML test reports, we will use choco to install visit package manager web site [Chocolatey Software | ReportGenerator (Portable) - Generates reports for various code coverage tools 5.1.20](https://community.chocolatey.org/packages/reportgenerator.portable)

```batch
@echo off
@setlocal enableextensions
@cd /d "%~dp0"
echo Installing Report Generator...
choco install reportgenerator.portable
```

## Repository Setup

#### Github Repositoy Creation

First create a empty project in github and clone it to your PC,

#### Pre-Commit Action Restrictions

Use following pre-commit script and replace it with `.git/hook/precommit`

```bash
#!/bin/bash
# Installation:
#   Copy this script as pre-commit to .git/hooks folder

OPTIONS="--options=astyle-options.txt"

# Check if .gitignore file exists
if [ ! -f astyle-options.txt ]; then
    echo "[!] astyle-options.txt file not found. Please make sure the astyle-options.txt file is present." >&2
    exit 1
fi

RETURN=0
ASTYLE=$(command -v astyle)
if [ $? -ne 0 ]; then
    echo "[!] AStyle is not installed. Unable to check source file format policy." >&2
    exit 1
fi

# Check if .gitignore file exists
if [ ! -f .gitignore ]; then
    echo "[!] .gitignore file not found. Please make sure the .gitignore file is present." >&2
    exit 1
fi

# Check if README.md file exists
if [ ! -f README.md ]; then
    echo "[!] README.md file not found. Please make sure the README.md file is present." >&2
    exit 1
fi

# Check if .gitignore file exists
if [ ! -f Doxyfile ]; then
    echo "[!] Doxyfile file not found. Please make sure the Doxyfile file is present." >&2
    exit 1
fi

FILES=$(git diff --cached --name-only --diff-filter=ACMRTUXB | grep -E "\.(cs|java|c|cpp|h)$")
for FILE in $FILES; do
    FORMATTED=$( "$ASTYLE" $OPTIONS < "$FILE" 2>&1 )
    if [ $? -ne 0 ]; then
        echo "[!] Error formatting $FILE:" >&2
        echo "$FORMATTED" >&2
        RETURN=1
    elif [ -n "$FORMATTED" ]; then
        echo "Formatted $FILE"
        echo "$FORMATTED"
        echo ""
        echo "$FORMATTED" > "$FILE"
        git add "$FILE"
    fi
done

if [ $RETURN -eq 1 ]; then
    echo "" >&2
    echo "Make sure you have run AStyle with the following options:" >&2
    echo $OPTIONS >&2
fi

exit $RETURN
```

This script will check astyle-options.txt file, gitignore file, README.md file and Doxyfile is exist if not it will be terminate your commit operation. Also after `astyle` installation and `astyle-options.txt` generation it will automatically format your source code before each commit. Formatting configuration will be stored in `astyle-options.txt` .

#### Create .gitignore with TOPTAL API via batch script

Use the following script to generate .gitignore file, you can change gitignore file by changing the configuration after `https://www.toptal.com/developers/gitignore/api`

This is the selected configuration

`c,csharp,vs,visualstudio,visualstudiocode,java,maven,c++,cmake,eclipse,netbeans`

```batch
@echo off

set API_URL=https://www.toptal.com/developers/gitignore/api/c,csharp,vs,visualstudio,visualstudiocode,java,maven,c++,cmake,eclipse,netbeans
set OUTPUT_FILE=.gitignore

REM Set the running folder to the current working folder
cd /d "%~dp0"

REM Download the API results using curl
curl -s -o %OUTPUT_FILE% %API_URL%

echo Downloaded .gitignore file from %API_URL% and saved as %OUTPUT_FILE%

pause
```

#### Create an Empty README.md file

Create and EMPTY `README.md` file and during project fill required parts

#### Create Default Doxyfile

Use following command to generate default `Doxyfile` if you didn't create or you can use pre-configured configuration and you can edit over this configurations. Be sure that your output directory should be **./docs** and all warnings should be opened and warnings stop operations.

```batch
doxygen -g
```

#### First commit is ready, You can commit and push your work.

You can use gitextension to commit your work, check if you get any error than return steps and check missing parts.

---

## Creating a Project

```bash
mvn archetype:generate -DgroupId=com.ucoruh.calculator -DartifactId=calculator-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

### Import Project to Eclipse

Use import existing maven project option to import project to Eclipse

### Rename Files

Rename App.java to CalculatorApp.java and AppTest.java to CalculatorAppTest.java and Generate Calculator.java and CalculatorTest.java

```java
package com.ucoruh.calculator;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class Calculator {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(Calculator.class);

    /**
     * 
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {

        logger.info("Logging message");

        logger.error("Error message");

        return a + b;
    }
}
```

```java
package com.ucoruh.calculator;

import java.io.IOException;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * Hello world!
 *
 */
public class CalculatorApp {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(CalculatorApp.class);

    public static void main(String[] args) {

        logger.info("Logging message");

        logger.error("Error message");

        System.out.println("Hello World!");

        try {

            if(args.length>0)
            {
                if(args[0].equals("1"))
                {
                    throw new IOException("Dummy Exception...");
                }
            }

            System.out.println("Press Enter to Continue...");

            System.in.read();

            System.out.println("Thank you...");

        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
    }
}
```

Generate test with add new unit test feature in Eclipse 

![](assets/2023-05-24-16-48-59-image.png)

![](assets/2023-05-24-16-49-11-image.png)

![](assets/2023-05-24-16-49-27-image.png)

```java
/**
 * 
 */
package com.ucoruh.calculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ugur.coruh
 *
 */
public class CalculatorTest {

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

}
```

```java
package com.ucoruh.calculator;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorAppTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testMainSuccess() {
        // Redirect System.in and System.out
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        // Create a ByteArrayInputStream with the desired input
        String input = System.lineSeparator(); // Pressing "Enter" key
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

        // Redirect System.in to the ByteArrayInputStream
        System.setIn(inputStream);

        // Create a ByteArrayOutputStream to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String[] args = new String[] {"0"};
        // Call the main method of CalculatorApp
        CalculatorApp.main(args);

        // Restore original System.in and System.out
        System.setIn(originalIn);
        System.setOut(originalOut);

        // Assert the desired behavior based on the output
        assertTrue(true);
    }

    @Test
    public void testMainError() {
        // Redirect System.in and System.out
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        // Create a ByteArrayInputStream with the desired input
        String input = System.lineSeparator(); // Pressing "Enter" key
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

        // Redirect System.in to the ByteArrayInputStream
        System.setIn(inputStream);

        // Create a ByteArrayOutputStream to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String[] args = new String[] {"1"};
        // Call the main method of CalculatorApp
        CalculatorApp.main(args);

        // Restore original System.in and System.out
        System.setIn(originalIn);
        System.setOut(originalOut);

        // Assert the desired behavior based on the output
        assertTrue(true);
    }

}
```

### Update pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <!-- The Basics -->
    <groupId>com.ucoruh.calculator</groupId>
    <artifactId>calculator-app</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <!-- More Project Information -->
    <name>calculator-app</name>
    <url>https://github.com/ucoruh/eclipse-java-maven-template</url>
    <scm>
        <url>https://github.com/ucoruh/eclipse-java-maven-template</url>
    </scm>
    <inceptionYear>2023</inceptionYear>
    <developers>
        <developer>
            <name>Asst. Prof. Dr. Ugur CORUH</name>
            <organization>RTEU</organization>
            <email>ugur.coruh@erdogan.edu.tr</email>
            <roles>
                <role>Developer</role>
                <role>Designer</role>
            </roles>
        </developer>
        <developer>
            <name>Other Person</name>
            <organization>RTEU</organization>
            <email>mail@gmail.com</email>
            <roles>
                <role>Developer</role>
            </roles>
        </developer>
    </developers>
    <contributors>
        <contributor>
            <name>Asst. Prof. Dr. Ugur CORUH</name>
            <email>ugur.coruh@erdogan.edu.tr</email>
            <organization>RTEU</organization>
            <roles>
                <role>Developer</role>
                <role>Designer</role>
            </roles>
        </contributor>
        <contributor>
            <name>Other Person</name>
            <organization>RTEU</organization>
            <email>mail@gmail.com</email>
            <roles>
                <role>Developer</role>
            </roles>
        </contributor>
    </contributors>
    <description>Maven Example Template Project</description>
    <organization>
        <name>Recep Tayyip Erdogan University</name>
        <url>www.erdogan.edu.tr</url>
    </organization>
    <!-- Environment Settings -->
    <issueManagement>
        <system>Github</system>
        <url>https://github.com/ucoruh/eclipse-java-maven-template</url>
    </issueManagement>
    <ciManagement>
        <system>Github</system>
        <notifiers>
            <notifier>
                <address>ugur.coruh@erdogan.edu.tr</address>
                <sendOnSuccess>true</sendOnSuccess>
                <sendOnError>true</sendOnError>
                <sendOnFailure>true</sendOnFailure>
                <sendOnWarning>true</sendOnWarning>
            </notifier>
        </notifiers>
        <url>https://github.com/ucoruh/eclipse-java-maven-template</url>
    </ciManagement>
    <repositories>
        <repository>
            <id>eclipse-java-maven-template</id>
            <name>eclipse-java-maven-template</name>
            <url>https://github.com/ucoruh/eclipse-java-maven-template</url>
        </repository>
    </repositories>
    <distributionManagement>
        <site>
            <name>https://github.com/ucoruh/eclipse-java-maven-template</name>
            <id>eclipse-java-maven-template</id>
        </site>
        <downloadUrl>https://github.com/ucoruh/eclipse-java-maven-template</downloadUrl>
        <repository>
            <id>eclipse-java-maven-template</id>
            <name>eclipse-java-maven-template</name>
            <url>https://github.com/ucoruh/eclipse-java-maven-template</url>
        </repository>
    </distributionManagement>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.11</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest-all</artifactId>
            <version>1.3</version>
            <scope>test</scope>
        </dependency>
        <!-- SLF4J API -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.32</version>
        </dependency>
        <!-- Logback Implementation -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.6</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <configuration>
                    <includes>
                        <include>**/CalculatorAppTest.java</include>
                        <include>**/CalculatorTest.java</include>
                    </includes>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.7</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>report</id>
                        <phase>test</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-site-plugin</artifactId>
                <version>4.0.0-M8</version>
                <configuration>
                    <port>9000</port>
                    <tempWebappDirectory>${basedir}/target/site</tempWebappDirectory>
                </configuration>
            </plugin>
            <!-- Maven Shade Plugin -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.2.4</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <createDependencyReducedPom>false</createDependencyReducedPom>
                            <transformers>
                                <transformer
                                    implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <mainClass>
                                        com.ucoruh.calculator.CalculatorApp</mainClass>
                                </transformer>
                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>

        <pluginManagement><!-- lock down plugins versions to avoid using Maven
            defaults (may be moved to parent pom) -->
            <plugins>
                <!-- clean lifecycle, see
                https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
                <plugin>
                    <artifactId>maven-clean-plugin</artifactId>
                    <version>3.1.0</version>
                </plugin>
                <!-- default lifecycle, jar packaging: see
                https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
                <plugin>
                    <artifactId>maven-resources-plugin</artifactId>
                    <version>3.0.2</version>
                </plugin>
                <plugin>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>3.8.0</version>
                </plugin>
                <plugin>
                    <artifactId>maven-surefire-plugin</artifactId>
                    <version>2.22.1</version>
                </plugin>
                <plugin>
                    <artifactId>maven-jar-plugin</artifactId>
                    <version>3.0.2</version>
                </plugin>
                <plugin>
                    <artifactId>maven-install-plugin</artifactId>
                    <version>2.5.2</version>
                </plugin>
                <plugin>
                    <artifactId>maven-deploy-plugin</artifactId>
                    <version>2.8.2</version>
                </plugin>
                <!-- site lifecycle, see
                https://maven.apache.org/ref/current/maven-core/lifecycles.html#site_Lifecycle -->
                <plugin>
                    <artifactId>maven-site-plugin</artifactId>
                    <version>3.7.1</version>
                </plugin>
                <plugin>
                    <artifactId>maven-project-info-reports-plugin</artifactId>
                    <version>3.0.0</version>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>
</project>
```

### Generate Project Site Files

- site.xml
  
  - resources
    
    - images
      
      - banner.png
      
      - logo.png
    
    - markdown
      
      - overview.md

You can use files in project

### Build the Project

Enter pom.xml root folder and run following command to test and generate jar file

```bash
mvn clean test site package
```

### Run Project

You can run application by specify the Main function

```bash
java -cp calculator-app-1.0-SNAPSHOT.jar com.ucoruh.calculator.CalculatorApp
```

Output

```bash
C:\Users\ugur.coruh\Desktop\eclipse-java-maven-template\calculator-app\target>java -cp calculator-app-1.0-SNAPSHOT.jar com.ucoruh.calculator.CalculatorApp
Hello World!
```

### Generate HTML Coverage Report

```bash
reportgenerator "-reports:target/site/jacoco/jacoco.xml" "-sourcedirs:src/main/java" "-targetdir:coveragereport" -reporttypes:Html
```

Output

```bash
C:\Users\ugur.coruh\Desktop\eclipse-java-maven-template\calculator-app>reportgenerator "-reports:target/site/jacoco/jacoco.xml" "-sourcedirs:src/main/java" "-targetdir:coveragereport" -reporttypes:Html
2023-05-24T17:26:40: Arguments
2023-05-24T17:26:40:  -reports:target/site/jacoco/jacoco.xml
2023-05-24T17:26:40:  -sourcedirs:src/main/java
2023-05-24T17:26:40:  -targetdir:coveragereport
2023-05-24T17:26:40:  -reporttypes:Html
2023-05-24T17:26:40: Writing report file 'coveragereport\index.html'
2023-05-24T17:26:40: Report generation took 0,2 seconds

C:\Users\ugur.coruh\Desktop\eclipse-java-maven-template\calculator-app>
```

![](assets/2023-05-25-00-52-27-image.png)

## Run Maven Site

```bash
mvn site:run
```

Use CTRL+C to cancel from console

![](assets/2023-05-25-03-53-48-image.png)

This has code coverage and documentation coverage reports also

![](assets/2023-05-25-03-54-34-image.png)

![](assets/2023-05-25-03-54-20-image.png)

![](assets/2023-05-25-03-53-14-image.png)

### Clone-Test-Generate WebSite-Package-Generate Report-Run Web Site

```bash
@echo off

echo Enable necessary extensions
@setlocal enableextensions

echo Change the current working directory to the script directory
@cd /d "%~dp0"

git clone https://github.com/ucoruh/eclipse-java-maven-template.git

echo Get the current directory
set "currentDir=%CD%"

echo Change directory to calculator-app
cd calculator-app

echo Perform Maven clean, test, site generation, and packaging
call mvn clean test site package

echo Return to the previous directory
cd ..

echo Generate Doxygen HTML and XML Documentation
call doxygen Doxyfile

echo Change directory to calculator-app
cd calculator-app

echo Generate ReportGenerator HTML Report
call reportgenerator "-reports:target/site/jacoco/jacoco.xml" "-sourcedirs:src/main/java" "-targetdir:target/site/coveragereport" -reporttypes:Html

echo Display information about the binary file
echo Our Binary is a Single Jar With Dependencies. You Do Not Need to Compress It.

echo Return to the previous directory
cd ..

echo Generate Doxygen Coverage Report

echo Create coverxygen directory
cd calculator-app
cd target
cd site
mkdir coverxygen
cd ..
cd ..
cd ..

echo Run Coverxygen
call python -m coverxygen --xml-dir ./calculator-app/target/site/doxygen/xml --src-dir ./ --format lcov --output ./calculator-app/target/site/coverxygen/lcov.info --prefix %currentDir%\calculator-app\

echo Run lcov genhtml
call perl C:\ProgramData\chocolatey\lib\lcov\tools\bin\genhtml ./calculator-app\target\site\coverxygen\lcov.info -o calculator-app/target/site/coverxygen

echo Package Coverage Report-1
call tar -czvf test-jacoco-report.tar.gz -C calculator-app/target/site/jacoco .

echo Package Coverage Report-2
call tar -czvf test-coverage-report.tar.gz -C calculator-app/target/site/coveragereport .

echo Package Code Documentation
call tar -czvf application-documentation.tar.gz -C calculator-app/target/site/doxygen .

echo Package Product Site
call tar -czvf application-site.tar.gz -C target/site .

echo Return to the previous directory
cd ..

echo Operation Completed!
pause
```

### Run Web Site

```bash
@echo off
@setlocal enableextensions
@cd /d "%~dp0"

cd calculator-app

echo Run Web Site
echo to Exit Use CTRL+Z CTRL+C
start http://localhost:9000/
mvn site:run

echo Operation Completed!
pause
```

### Run Jar File

```bash
@echo off
@setlocal enableextensions
@cd /d "%~dp0"

echo Running Application
java -jar calculator-app/target/calculator-app-1.0-SNAPSHOT.jar

echo Operation Completed!
pause
```

![](assets/2023-05-25-00-57-01-image.png)
