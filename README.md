# Soap-Restful-Java

**Soap-Restful-Java** is a Java-based system that demonstrates a hybrid architecture using both SOAP and RESTful web services. It is designed to handle modern API integration needs while maintaining compatibility with legacy systems that require XML-based SOAP communication.

## 🚀 Features

* RESTful API for modern clients (JSON-based)
* SOAP services for legacy system integration (XML/WSDL-based)
* Layered service architecture with clear separation of concerns
* Modular codebase for easy extension and maintenance
* Example endpoints for employee and benefit management

## 🛠️ Technologies Used

* **Language**: Java
* **Frameworks**: Spring Boot, JAX-WS (for SOAP)
* **API**: Spring MVC (REST), JAX-WS (SOAP)
* **Database**: \[Specify here, e.g., MySQL, PostgreSQL, H2, etc.]
* **Build Tool**: Maven or Gradle
* **Containerization**: Docker (optional)

## 📦 Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/petersonchiquetto/Soap-Restful-Java.git
   ```

2. Navigate to the project directory:

   ```bash
   cd Soap-Restful-Java
   ```

3. Build the project:

   ```bash
   # Example with Maven
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

5. Access the endpoints:

   * REST: `http://localhost:8080/api/...`
   * SOAP WSDL: `http://localhost:8080/ws/ServiceName?wsdl`

## 🧱 Architecture Overview

The project follows a hybrid web services architecture that integrates both REST and SOAP protocols in a clean and modular way.

### 🔹 REST (Representational State Transfer)

REST is used to expose lightweight, JSON-based endpoints for modern clients and front-end applications.

**Example REST endpoints:**

* `GET /api/employees`
* `POST /api/benefits`

**Advantages:**

* Easy integration with frontend frameworks
* Lightweight and efficient for web/mobile apps
* Stateless and scalable

### 🔹 SOAP (Simple Object Access Protocol)

SOAP is used to interact with enterprise systems that require strict contracts and XML communication.

**Example SOAP usage:**

* Integration with legacy payroll or ERP systems
* Operations exposed via WSDL
* Secure and structured messaging

**Advantages:**

* Strong protocol-level validation
* Better suited for enterprise security and transactions
* Widely supported in legacy systems

### 🔧 Architecture Layers

```plaintext
[Frontend/Web Client]
        ↓
[REST Controllers / SOAP Endpoints]
        ↓
[Service Layer (Business Logic)]
        ↓
[Adapters: REST Clients / SOAP Clients]
        ↓
[External Systems (ERPs, Databases, Legacy Services)]
```

This layered design ensures modularity, testability, and extensibility of the system.

## 🤝 Contributing

Contributions are welcome! Here’s how you can help:

1. Fork this repository
2. Create a new feature branch: `git checkout -b feature/your-feature-name`
3. Commit your changes: `git commit -m 'Add new feature'`
4. Push your branch: `git push origin feature/your-feature-name`
5. Open a Pull Request and describe your changes

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more information.
