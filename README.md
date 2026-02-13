# Library Endterm Project API (Spring Boot)

## Run in IntelliJ
Run:
`src/main/java/com/example/library/Application.java`

## DB (pgAdmin)
Create DB `library_endterm` then run:
`db/schema.sql`

## Endpoints
- GET  /api/health
- GET  /api/books
- POST /api/books
- PUT  /api/books/{id}
- DELETE /api/books/{id}

Postman collection:
`postman/Library Endterm API.postman_collection.json`

## Bonus Task — In-Memory Cache (Singleton)

A simple in-memory caching layer was implemented to improve performance.

### Cached Method
`BookService.listAllBooks()`

### How It Works
- First request to `GET /api/books` fetches data from the database.
- The result is stored in `BookCache` (Singleton).
- Repeated requests return data from cache (no DB call).
- Cache is cleared after:
  - `addBook()`
  - `updateBook()`
  - `deleteBook()`

### Design
- Cache stored in memory.
- Only one instance exists (Singleton pattern).
- Layered architecture preserved.
