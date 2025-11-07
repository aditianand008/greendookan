# Green Dooan - E-Commerce Shopping Cart System

## Overview
Green Dooan is a full-featured online shopping cart system with a clean green and off-white aesthetic. Built with Java Spring Boot backend and HTML/CSS/JavaScript frontend.

## Features

### Core Functionality
- ✅ User Authentication (Customer & Admin roles)
- ✅ Product Catalog Management (Add, Update, Delete, Search, Filter)
- ✅ Shopping Cart with Add/Remove/Update quantity
- ✅ Secure Checkout & Order Processing
- ✅ XML-based Order History Storage
- ✅ Customer Profile Management
- ✅ Sales Reports & Analytics
- ✅ Email/SMS Notifications
- ✅ Low Stock Alerts

### Technology Stack
- **Backend**: Java 11+, Spring Boot, Spring Security, Spring Data JPA
- **Database**: H2 (Development) / MySQL (Production)
- **Frontend**: HTML5, CSS3, JavaScript
- **Order Storage**: XML (JAXB)
- **Build Tool**: Maven

## Project Structure

```
greendookan/
├── src/
│   ├── main/
│   │   ├── java/com/greendookan/
│   │   │   ├── controllers/      # REST API endpoints
│   │   │   ├── models/           # Entity classes
│   │   │   ├── repositories/     # JPA repositories
│   │   │   ├── services/         # Business logic
│   │   │   ├── security/         # Authentication & authorization
│   │   │   └── GreenDookanApplication.java
│   │   └── resources/
│   │       ├── static/           # HTML, CSS, JS files
│   │       ├── templates/        # Thymeleaf templates
│   │       ├── xml/              # Order history XML storage
│   │       └── application.properties
├── pom.xml                       # Maven dependencies
└── README.md
```

## Setup Instructions

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Maven 3.6+
- Git

### Installation Steps

1. **Clone the repository**
```bash
git clone https://github.com/aditianand008/greendookan.git
cd greendookan
```

2. **Build the project**
```bash
mvn clean install
```

3. **Run the application**
```bash
mvn spring-boot:run
```

4. **Access the application**
- Open browser: `http://localhost:8080`
- Admin Login: `admin@greendookan.com` / `admin123`
- Customer Login: Create account via registration

## Configuration

Edit `src/main/resources/application.properties`:

```properties
# Server Configuration
server.port=8080

# Database Configuration (H2 for development)
spring.datasource.url=jdbc:h2:mem:greendookan
spring.datasource.username=sa
spring.datasource.password=

# For MySQL (Production)
# spring.datasource.url=jdbc:mysql://localhost:3306/greendookan
# spring.datasource.username=root
# spring.datasource.password=yourpassword

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# XML Storage Path
xml.orders.path=src/main/resources/xml/orders/
```

## API Endpoints

### Authentication
- `POST /api/auth/register` - Register new customer
- `POST /api/auth/login` - User login
- `POST /api/auth/logout` - User logout

### Products
- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `GET /api/products/search?name={name}` - Search products
- `POST /api/products` - Add product (Admin)
- `PUT /api/products/{id}` - Update product (Admin)
- `DELETE /api/products/{id}` - Delete product (Admin)

### Cart
- `GET /api/cart` - Get customer cart
- `POST /api/cart/add` - Add item to cart
- `PUT /api/cart/update/{itemId}` - Update cart item quantity
- `DELETE /api/cart/remove/{itemId}` - Remove item from cart

### Orders
- `POST /api/orders/checkout` - Place order
- `GET /api/orders/history` - Get order history
- `GET /api/orders/{id}` - Get order details
- `GET /api/orders/xml/{id}` - Download order as XML

### Admin
- `GET /api/admin/reports/sales` - Sales reports
- `GET /api/admin/customers` - Customer list
- `GET /api/admin/orders` - All orders

## Default Login Credentials

**Admin Account**
- Email: admin@greendookan.com
- Password: admin123

**Test Customer Account**
- Email: customer@test.com
- Password: customer123

## Features in Detail

### 1. Product Management
- Admins can add/edit/delete products
- Products have name, description, price, category, stock quantity
- Product images supported
- Low stock alerts when quantity < 10

### 2. Shopping Cart
- Session-based cart for guests
- Persistent cart for logged-in users
- Real-time price calculations
- Stock validation before checkout

### 3. Order Processing
- Checkout with order summary
- Order confirmation page
- Orders stored in database AND XML format
- Email notifications sent on order placement

### 4. XML Order Storage
- Each order saved as individual XML file
- Format: `order_<orderid>_<timestamp>.xml`
- Contains customer info, products, pricing, timestamps
- Can be imported/exported for reporting

### 5. User Profiles
- View/edit personal information
- Manage shipping addresses
- View order history
- Track order status

### 6. Admin Dashboard
- Product inventory management
- Customer management
- Order processing and tracking
- Sales analytics and reports
- Export data to XML/Excel

## UI Design

### Color Scheme
- **Primary**: Green (#43a047, #379446)
- **Secondary**: Off-white (#f6fff8)
- **Text**: Dark green (#1b5e20)
- **Accents**: Light green variations

### Design Principles
- Clean, minimal interface
- Smooth transitions and interactions
- Mobile-responsive design
- Accessible with proper contrast
- Intuitive navigation

## Security Features
- Password encryption (BCrypt)
- CSRF protection
- SQL injection prevention
- XSS protection
- Secure session management
- Role-based access control

## Testing

Run tests:
```bash
mvn test
```

## Deployment

### Deploy to Heroku
```bash
heroku create greendookan
git push heroku main
```

### Deploy to AWS
- Package as JAR: `mvn package`
- Upload to EC2 or Elastic Beanstalk
- Configure MySQL database

## Troubleshooting

**Issue**: Port 8080 already in use
- Solution: Change port in `application.properties`

**Issue**: Database connection error
- Solution: Verify database credentials and connection string

**Issue**: XML files not saving
- Solution: Check write permissions for xml directory

## Contributing

1. Fork the repository
2. Create feature branch (`git checkout -b feature/NewFeature`)
3. Commit changes (`git commit -m 'Add NewFeature'`)
4. Push to branch (`git push origin feature/NewFeature`)
5. Open Pull Request

## License
MIT License - feel free to use for personal or commercial projects

## Support
For issues or questions:
- Email: support@greendookan.com
- GitHub Issues: [Create an issue](https://github.com/aditianand008/greendookan/issues)

## Roadmap
- [ ] Payment gateway integration (Stripe/PayPal)
- [ ] Product reviews and ratings
- [ ] Wishlist functionality
- [ ] Coupon/discount codes
- [ ] Multi-language support
- [ ] Mobile app (React Native)

---

**Version**: 1.0.0  
**Author**: Aditi Anand  
**Last Updated**: November 2025
