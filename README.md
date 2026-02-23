Request Flow (Client → Database)
```
Client
  |
  |  (1) JSON Request Body
  v
Spring Boot (Jackson)
  |
  |  Converts JSON → EmployeeRequestDTO object
  v
Controller
  |
  |  Passes RequestDTO
  v
Service Layer
  |
  |  Converts RequestDTO → Employee Entity
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
  |  Converts Entity → EmployeeResponseDTO
  v
Controller
  |
  |  Jackson Converts EmployeeResponseDTO object → JSON
  v
Client (Browser / Postman / Frontend)

```
Layer Responsibility
```
Controller  → Handles HTTP + JSON conversion
Service     → Business logic + (EmployeeRequestDTO --> Entity mapping) + ( Entity mapping --> EmployeeResponseDTO)
Repository  → Database interaction
Database    → Stores persistent data
```
