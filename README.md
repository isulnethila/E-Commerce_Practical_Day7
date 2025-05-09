# Day-07-Practicals Session

## Exercise 1: Employee Database 
**Objective:** Implement class inheritance and relationship configurations using JPA/Hibernate.

### Key Features:
- **Inheritance Strategy**: `Person` superclass with `Employee` subclass (using `@MappedSuperclass`)
- **Entity Relationships**:
  - One-to-Many: `Department` ↔ `Employee`
  - Many-to-Many: `Employee` ↔ `Project` with custom `@JoinTable`
  - One-to-One: `Employee` ↔ `Insurance`
- **Database Schema**:
  - Automatic table generation for entities
  - Custom join table `project_assignments` for employee-project relationships

### Observations:
- Requires explicit inheritance strategy annotation for proper JPA implementation
- Join table column mapping needed correction (`pro_id` ↔ `emp_id` reversal)
- Typo fix required in Insurance mapping (`insurence` → `insurance`)

---

## Exercise 2: Workshop Management System
**Scenario:** Model a university workshop system with complex participant relationships.

### Key Features:
- **Inheritance Design**: `Person` as `@MappedSuperclass` for `PostGraduate`, `UnderGraduate`, and `Presenter`
- **Core Relationships**:
  - Workshop-Session: One-to-Many (`Workshop` ↔ `Session`)
  - Session-Participants: Multiple Many-to-Many relationships:
    - `PostGraduate` ↔ `Session`
    - `UnderGraduate` ↔ `Session` 
    - `Presenter` ↔ `Session`
- **Custom Join Tables**:
  - `post_graduate_sessions`
  - `under_graduate_sessions`
  - `presenter_sessions`

### Implementation Highlights:
- Separate tracking for different participant types
- Session entity connects workshops with presenters and attendees
- Time-specific tracking with `Date` and `Time` fields in sessions

---

## Migration & Validation

### Database Migration
To migrate the database schema and data:
1. Use the `mysqldump` command to back up the existing database:
    ```bash
    mysqldump -u root -p practical_db > day7_backup.sql
    ```
2. Apply schema changes or updates using a migration tool or SQL scripts.
3. Restore the database if needed using:
    ```bash
    mysql -u root -p practical_db < day7_backup.sql
    ```

### Validation Steps
1. Verify the schema changes:
    ```sql
    SHOW TABLES;
    ```
    Expected output:
    ```
    +---------------------+
    | Tables_in_practical |
    +---------------------+
    | post_graduate       |
    | post_graduate_sessions |
    | presenter           |
    | presenter_sessions  |
    | project             |
    | project_assignments |
    | session             |
    | under_graduate      |
    | under_graduate_sessions |
    | workshop            |
    +---------------------+
    ```

2. Check data integrity by querying key relationships:
   
    - Confirm `Session` participant mappings:
      ```sql
      SELECT * FROM post_graduate_sessions;
      SELECT * FROM under_graduate_sessions;
      SELECT * FROM presenter_sessions;
      ```

3. Test application functionality to ensure all relationships and data mappings are working as expected.


## Key Learnings
- Importance of using `@MappedSuperclass` for shared fields in inheritance hierarchies.
- Handling many-to-many relationships with custom join tables for clarity and flexibility.
- Debugging and resolving mapping issues in JPA annotations.
- Structuring database schemas to reflect real-world scenarios effectively.
- Validating schema changes and ensuring data integrity through SQL queries.
- Leveraging database backup and restore commands for safe migrations.
