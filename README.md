A full-stack e-commerce platform built from scratch with a React SPA and a Spring Boot REST API, featuring user authentication, product management, category-based browsing, and role-based product ownership with edit/delete workflows.
Technical Architecture
Backend (Spring Boot 4 + Java 21)
RESTful API with JPA/Hibernate and PostgreSQL persistence
DTOs for validation (productRequest, signUpRequest, loginRequest), request/response mapping, and type-safe updates (productUpdateRequest)
Product image uploads stored as Base64, decoded on the server, validated (2MB cap), saved to the filesystem with UUID filenames, and served via ResourceHandlerRegistry
CORS configured for the React frontend origin
Service layer with clear separation between auth, product, and user management
Frontend (React 19 + Vite + React Router 7)
Single-page app with client-side routing and protected routes
Auth state in localStorage with token/user persistence across sessions
Hooks for data fetching (useEffect), memoized filtering (useMemo), and controlled forms (useState)
Modular components with CSS modules and shared styles (e.g. GuestHomePage.css, Home.css, ProductInfo.css, UserProduct.css)
Core Features Implemented
Auth & User Management
Sign-up with email, full name, password confirmation, and address (multi-step flow via SignUpAddress.jsx)
Login via /api/auth/login with user data stored for the session
Email existence check for validation before registration
Profile updates: name, email, password, address, city, country, zipcode
Product Catalog & CRUD
Create products with Base64 image upload, category select, price, stock quantity, and description
Full CRUD: GET all products, by category, by ID; PUT for updates; DELETE for removal
User-specific product listings (display-user-products by createdBy)
Category filtering (Electronics, Books, Clothing, Home, Sports, Other)
UI/UX
Guest landing page with hero section and auth CTAs
Category-based home layout (Books, Sports, Fashion, Home) with “See more” drill-downs
Product detail view with owner detection and conditional actions (Edit/Delete for owners; Buy/Add to Cart for visitors)
Account hub with links to user info, address, orders, and user products
Responsive, grid-based layouts
Data Modeling
userEntity: email, password, fullName, role, address, city, country, zipcode, @OneToOne cart
productEntity: name, description, price, stockQuantity, category, imageUrl, createdBy, timestamps
cartEntity: user association, cart items, created/updated timestamps (cart workflow prepared)
Technologies & Tools
Layer	Stack
Backend	Spring Boot 4, Spring Data JPA, PostgreSQL, Lombok
Frontend	React 19, Vite (Rolldown), React Router 7
API	REST (JSON), CORS-enabled cross-origin requests
Build	Gradle (Java 21), npm (Node)
