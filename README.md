

# LoqoAi Product Finder

## Overview

**Product Finder** is a Spring Boot application designed to help users search for products based on various criteria. It allows filtering products by category, price range, stock availability, and sorting results by specific fields such as price, rating, or creation date.

## Features

- **CRUD Operations**: Create, read, update, and delete products.
- **Advanced Search**: Filter products by category, price range, and stock availability.
- **Sorting**: Sort products based on price, rating, or creation date.
- **Spring Boot Integration**: Utilizes Spring Boot for rapid development and deployment.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [License](#license)

## Installation

### Prerequisites

- Java 17 or higher
- Maven 3.8 or higher
- MySQL 8 or higher

### Clone the Repository

```bash
git clone https://github.com/yourusername/product-finder.git
cd product-finder
```

### Build and Run

1. **Build the Project**

   Use Maven to build the project:

   ```bash
   mvn clean install
   ```

2. **Run the Application**

   Start the application using:

   ```bash
   mvn spring-boot:run
   ```

   Alternatively, you can run the generated JAR file:

   ```bash
   java -jar target/product-finder-0.0.1-SNAPSHOT.jar
   ```

## Usage

Once the application is running, you can access it at `http://localhost:8080`.

### Example Queries

- **Get All Products**

  ```http
  GET /products
  ```

- **Filter Products by Category**

  ```http
  GET /products?category=Electronics
  ```

- **Filter Products by Price Range**

  ```http
  GET /products?minPrice=100&maxPrice=1000
  ```

- **Sort Products by Price in Ascending Order**

  ```http
  GET /products?sortField=price&sortOrder=asc
  ```
- **Filter Products by Category ,Price, Price in Ascending Order, Get All Products**
 ```http
 GET /products?category=electronics&minPrice=100&maxPrice=1000&inStock=true&sortField=price&sortOrder=asc
  ```
## API Endpoints

### Product API

- **Get All Products**

  ```http
  GET /products
  ```

- **Get Product by ID**

  ```http
  GET /products/{id}
  ```

- **Create a New Product**

  ```http
  POST /products
  ```

  **Request Body:**

  ```json
  {
    "category": "Electronics",
    "name": "Smartphone",
    "price": 299.99,
    "rating": 4.5,
    "inStock": true
  }
  ```

- **Update a Product**

  ```http
  PUT /products/{id}
  ```

  **Request Body:**

  ```json
  {
    "category": "Electronics",
    "name": "Smartphone",
    "price": 279.99,
    "rating": 4.6,
    "inStock": true
  }
  ```

- **Delete a Product**

  ```http
  DELETE /products/{id}
  ```

## Configuration

Configure your application properties in `src/main/resources/application.properties`. 

Example configuration for MySQL:

```properties
spring.datasource.url=your-mysql-database-url
spring.datasource.username=username
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```

## Contributing

Contributions are welcome! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
