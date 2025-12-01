# Job4j Tracker

![CI GitHubAction](https://github.com/1oogabooga1/job4j_tracker/actions/workflows/maven.yml/badge.svg)

## Overview

Job4j Tracker is a console-driven application built as part of the Job4j Java educational program.
It demonstrates clean OOP design, modular architecture, consistent use of interfaces, and unit testing.

The application allows users to manage task “items” through a structured console menu.

## Features 
	-	➕ Add new items
	-	♻️ Update existing items by ID
	-	🗑 Delete items by ID
	-	📋 Display all items
	-	🔎 Search items by name
	-	🛡 Input validation for menu selections and IDs
	-	🧩 Easily extendable command system based on the Strategy pattern

## Tech Stack & Architecture

### Core Technologies
	-	Java 17
	-	Maven
	-	JDBC — early persistence layer
	-	Hibernate ORM — later-stage storage abstraction and entity mapping
	-	Lombok — boilerplate reduction (models, DTOs, builders)
	-	JUnit 5, Hamcrest — testing
	-	GitHub Actions CI
	-	H2 / PostgreSQL (depending on module)

## What I Learned
#### Developing this project helped me build a solid foundation in:
	-	OOP & SOLID principles
	-	Interface-driven development
	-	Dependency inversion
	-	Separation of concerns
	-	Unit testing & mocks
	-   Designing maintainable console applications
	-	Java Collections 
    -   Sql usage 
  

#### This was one of the first large educational projects in my Java journey.

## Project Evolution
This project was developed throughout the Job4j training program and evolved along with my skills.
Each module of the course introduced new technologies, patterns, and architectural principles, which were gradually integrated into the project.
#### As a result, different stages of the Tracker include:
	-	JDK core features — collections, OOP, interfaces, exception handling
	-	JDBC — first introduction to persistence and SQL operations
	-	Hibernate ORM — working with entities, sessions, and configuration
	-	Lombok — simplifying boilerplate (getters, constructors, builders)
	-	Layered architecture — separation into service, repository, and UI layers
	-   Unit testing & mocks — building stable and testable modules 
    -   Different databases - PostgreSQL, H2, Liquibase
While the final version of the Tracker remains a console application, internally it reflects the full progression of the Job4j program, touching key backend development skills.
