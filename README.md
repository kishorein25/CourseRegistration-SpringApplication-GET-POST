# Course Registration System (Full Stack)

A full-stack **Course Registration System** built with a Spring Boot backend and a JavaScript frontend. Students can view available courses, register for a course, and see the list of enrolled students.

## Tech Stack

| Layer     | Technology                                   |
| --------- | -------------------------------------------- |
| Backend   | Java 26, Spring Boot 4.1.1, Spring Web MVC   |
| Frontend  | HTML, CSS, JavaScript (Fetch API)            |
| Database  | MySQL with JPA / Hibernate (Spring Data JPA) |
| Build     | Maven                                        |
| Other     | Lombok                                       |

## Project Structure

```
.
├── backend/                  # Spring Boot application
│   ├── pom.xml               # Maven build file
│   ├── mvnw / mvnw.cmd       # Maven wrapper scripts
│   └── src/
│       ├── main/
│       │   ├── java/com/example/CoureRegistration/
│       │   │   ├── CourseRegistrationApplication.java   # Entry point
│       │   │   ├── Controller/CourseController.java     # REST endpoints
│       │   │   ├── Model/Course.java                    # Course entity
│       │   │   ├── Model/CourseRegistry.java            # Enrollment entity
│       │   │   ├── Repository/CourseRepo.java           # JPA repo for courses
│       │   │   ├── Repository/CourseRegistryRepo.java   # JPA repo for enrollments
│       │   │   └── Service/CourseService.java           # Business logic
│       │   └── resources/application.properties          # DB & server config
│       └── test/                                         # Tests
└── frontend/                 # Static web pages
    ├── index.html            # Home page with navigation
    ├── register.html         # Course registration form
    ├── availcourses.html     # Available courses table
    ├── enrolled.html         # Enrolled students table
    └── myscript.js           # Fetch API calls to the backend
```

## Features

- View all available courses (course id, name, trainer, duration in weeks)
- Register a student for a course (name, email id, course name)
- View the list of enrolled students
- CORS enabled so the frontend can call the backend from any origin

## Backend API

The backend runs on **port 8081**.

| Method | URL                          | Description                  | Params                               |
| ------ | ---------------------------- | ---------------------------- | ------------------------------------ |
| GET    | `/courses`                   | Get all available courses    | —                                    |
| GET    | `/courses/enrolled`          | Get all enrolled students    | —                                    |
| POST   | `/courses/register`          | Enroll a student in a course | `name`, `emailid`, `coursename`      |

Example POST request:

```
curl -X POST "http://localhost:8081/courses/register?name=Kishore&emailid=ks@mail.com&coursename=Spring%20Boot"
```

Response:

```
Congrats !! Kishore Enrolled Successfully for this course => Spring Boot
```

## Database Setup

1. Create a MySQL database:

```sql
CREATE DATABASE course_reg_sys;
```

2. Update credentials in `backend/src/main/resources/application.properties` if yours differ:

```properties
spring.datasource.url = jdbc:mysql://localhost:3306/course_reg_sys
spring.datasource.username = root
spring.datasource.password = root
```

`ddl-auto=update` lets Hibernate create/update the tables automatically, so no SQL schema is required beforehand.

## How to Run

### Backend

```bash
cd backend
./mvnw spring-boot:run        # on Linux/macOS
mvnw.cmd spring-boot:run      # on Windows
```

The API will be available at `http://localhost:8081`.

### Frontend

Open `frontend/index.html` in a browser (or serve the folder with any static server, e.g. `python -m http.server`). Then navigate to:

- **Register a course** → `register.html`
- **Available Courses** → `availcourses.html`
- **Enrolled Students** → `enrolled.html`

> Note: The frontend pages call `http://localhost:8081`, so the Spring Boot backend must be running first.

## Default Data

The `register.html` drop-down currently offers three courses:

- Java Essentials
- Python for ML
- Spring Boot

To add more courses, insert rows directly into the `course` table in MySQL (with `CourseId`, `CourseName`, `Trainer`, `DurationinWeeks`).