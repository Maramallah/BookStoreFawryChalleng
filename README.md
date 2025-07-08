#  Bookstore 📚

A Java-based online bookstore management system that supports multiple book types with different purchasing behaviors.



## ✨ Features

- **Multi-Book Type Support**: Handle different book categories with unique properties
- **Inventory Management**: Add books with detailed information (ISBN, title, year, price)
- **Automated Cleanup**: Remove outdated books (over 100 years old)
- **Purchase System**: Buy books with stock validation and service delivery
- **Extensible Design**: Easy to add new book types without modifying existing code

## 🏗️ Architecture

### Core Classes

#### `Book` (Abstract Class)
Base class for all book types with common properties:
- ISBN (String identifier)
- Title
- Publication Year
- Price

**Key Methods:**
- `isOutdated()`: Checks if book is over 100 years old
- `IsForBuying()`: Abstract method to determine if book can be purchased
- `BuyBook()`: Abstract method for purchase logic

#### `Purchasable` (Interface)
Interface for books that can be bought:
- `sendToPurchaseService()`: Handles delivery service integration

#### Book Types

1. **`Paperbook`**
   - Extends `Book`, implements `Purchasable`
   - Has stock quantity
   - Reduces stock on purchase
   - Sends to ShippingService

2. **`EBook`**
   - Extends `Book`, implements `Purchasable`
   - Has file type (PDF, EPUB, etc.)
   - Has stock quantity
   - Sends to MailService

3. **`ShowcaseBook`**
   - Extends `Book`
   - Display-only, cannot be purchased
   - Throws exception if purchase attempted

#### `OnlineStore`
Main application class with console interface:
- Book inventory management
- User interaction handling
- Purchase processing



## 📖 Usage

### Main Menu Options

1. **Add New Book**
   - Choose book type (1: PaperBook, 2: EBook, 3: ShowCase Book)
   - Enter book details (ISBN, title, year, price)
   - Add type-specific properties (stock, file type)

2. **Remove Outdated Books**
   - Automatically removes books published over 100 years ago
   - Shows count of removed books

3. **Buy Book**
   - Enter ISBN of desired book
   - Provide email and address
   - Specify quantity
   - System validates stock and processes purchase

4. **Exit**
   - Closes the application

### Example Workflow

```
1- Add new Book
2- Remove Outdated Books
3- Buy Book
4- Exit
Enter Your Choice : 1

what is the type of book you want to add: 1- PaperBook 2- Ebook 3-ShowCase Book : 1
Enter ISBN :ISBN123
Enter Title :Java Programming
Enter Year of Publish :2020
Enter Price :29.99
Enter Quntity : 10

[Book added to inventory]

Enter Your Choice : 3
Enter Book ISBN : ISBN123
Enter Email : customer@email.com
Enter Address : 123 Main Street
Enter Quntity : 2

Sending Book To ShippingService
Purchase successful! Total cost: $59.98
Book Bought Successfully
```

## 🔧 Code Structure

```
org.example/
├── Book.java              # Abstract base class
├── Purchasable.java       # Interface for purchasable books
├── Paperbook.java         # Physical book implementation
├── EBook.java             # Digital book implementation
├── ShowcaseBook.java      # Display-only book implementation
└── OnlineStore.java       # Main application & UI
```

## 🎨 Design Patterns Used

1. **Template Method Pattern**: `Book` class defines common structure
2. **Strategy Pattern**: Different book types implement different purchasing strategies
3. **Interface Segregation**: `Purchasable` interface only for buyable books
4. **Polymorphism**: All books treated uniformly through `Book` reference

## 🧪 Testing

The application includes basic error handling:
- Stock validation for paper books and ebooks
- Invalid input validation
- Showcase book purchase prevention
- Outdated book detection

### Test Cases to Verify

1. **Add Books**: Test adding all three book types
2. **Stock Management**: Buy books and verify stock reduction
3. **Error Handling**: Try buying showcase books or exceeding stock
4. **Outdated Books**: Add old books and test removal
5. **Invalid Input**: Test with wrong menu choices and book types

## 🔮 Future Enhancements

- **User Authentication**: Add customer accounts
- **Order History**: Track purchase history
- **Search Functionality**: Find books by title/author
- **Inventory Reports**: Generate stock reports
- **Database Integration**: Persist data between sessions
- **GUI Interface**: Replace console with graphical interface
- **Payment Processing**: Integrate payment gateway
- **Book Categories**: Add genre/category classification



## 📝 Notes

- The system is designed to be easily extensible for new book types
- Stock management is handled automatically during purchases
- Error messages provide clear feedback to users


