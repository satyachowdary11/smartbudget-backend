# 💰 Smart Budget – Spring Boot Backend

A secure personal finance tracker built with **Spring Boot**, using **JWT authentication**, **MySQL**, and **REST APIs**. Enables users to track income, expenses, and manage transaction data securely.

---

## ✅ Features

- User Registration & Login (JWT secured)
- Role-based access ready (RBAC)
- Add/View Transactions (income & expenses)
- CORS enabled for React frontend
- Secure endpoints using JWT filter

---

## 🧱 Tech Stack

| Technology | Version |
|------------|---------|
| Spring Boot | 3.2.x   |
| Java        | 21      |
| MySQL       | 8.x     |
| Spring Security | ✅ |
| JWT         | ✅ |
| Maven       | ✅ |
| Lombok      | ✅ |

---

## 📁 Project Structure

```bash
src/main/java/com/satyasolutions/smartbudget/
├── config/         # Security and CORS config
├── controller/     # REST APIs
├── dto/            # Request/Response DTOs
├── entity/         # User and Transaction models
├── repository/     # JPA Repositories
├── security/       # JWT filter and utilities
├── service/        # Business logic
└── SmartBudgetApplication.java
🔐 JWT Authentication
On successful login, a token is returned.

All future requests must include:

http
Copy
Edit
Authorization: Bearer <token>
🔧 Endpoints
Method	Endpoint	Description
POST	/api/auth/register	Register new user
POST	/api/auth/login	Login and get token
GET	/api/transactions	Get user transactions
POST	/api/transactions	Add a transaction

⚠️ Common Errors & Fixes
❌ Issue	💡 Fix
401 Unauthorized	Missing/invalid JWT token. Make sure frontend sends Authorization header.
CORS error	Ensure CORS config allows http://localhost:3000 in CorsConfig.java.
Login failed: Network Error	Backend not running or CORS misconfigured. Check network tab and restart backend.
No transactions visible in frontend	Ensure transactions are tied to the authenticated user. Check user_id in DB.
Cannot read properties of undefined (reading 'data')	Backend was returning plain string. Changed to LoginResponse DTO with { token: "" }

⏰ Development Timeline
Date	Update Description
2025-06-25	✅ Project created – Spring Boot setup
2025-06-26	✅ JWT authentication added
2025-06-27	✅ User registration + token setup
2025-06-28	✅ Transactions API + filtering added
2025-06-29	✅ CORS + frontend integration fixed
2025-06-30	✅ Final debugging and UI testing done

🚀 Running the App
Clone the repo

bash
Copy
Edit
git clone https://github.com/yourusername/smartbudget-backend.git
cd smartbudget-backend
Add your MySQL DB in application.properties:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/smartbudget
spring.datasource.username=root
spring.datasource.password=yourpass
Run the app:

bash
Copy
Edit
./mvnw spring-boot:run
🙌 Author
Satya
Backend Developer | Spring Boot | Java
Feel free to connect!

