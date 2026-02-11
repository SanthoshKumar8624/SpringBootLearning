Request Flow (Client → Database)
```
Client
  |
  |  (1) JSON Request Body
  v
Spring Boot (Jackson)
  |
  |  Converts JSON → EmployeeDTO Object
  v
Controller
  |
  |  Passes DTO
  v
Service Layer
  |
  |  Converts DTO → Employee Entity
  v
Repository (JPA)
  |
  |  Calls Hibernate
  v
Database (MySQL)

```

Response Flow (Database → Client)
```
Database
  |
  |  Returns Row Data
  v
Hibernate / JPA
  |
  |  Converts Row → Employee Entity
  v
Repository
  |
  v
Service Layer
  |
  |  Converts Entity → EmployeeDTO
  v
Controller
  |
  |  Jackson Converts DTO → JSON
  v
Client (Browser / Postman / Frontend)

```
Layer Responsibility
```
Controller  → Handles HTTP + JSON conversion
Service     → Business logic + DTO <--> Entity mapping
Repository  → Database interaction
Database    → Stores persistent data
```
