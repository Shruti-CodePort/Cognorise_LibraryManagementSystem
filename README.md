# Cognorise_LibraryManagementSystem
This code is a Java implementation of a Library Management System. It consists of three classes: `Book`, `LibraryCatalog`, and `LibraryManagementSystem`.

The `Book` class represents a book in the library and has properties like `title`, `author`, and `checkedOut` (a boolean indicating whether the book is checked out or not). It provides getter and setter methods for these properties.

The `LibraryCatalog` class manages the collection of books in the library. It has an `ArrayList` of `Book` objects called `bookList`. It provides the following functionalities:

1. `addBook(Book book)`: Adds a new book to the catalog.
2. `searchByTitle(String title)`: Searches for a book by its title and displays its status (checked out or available).
3. `searchByAuthor(String author)`: Searches for books by the author's name and displays their titles and statuses.
4. `checkOutBook(String title)`: Checks out a book by marking its `checkedOut` status as `true`.
5. `returnBook(String title)`: Returns a checked-out book by marking its `checkedOut` status as `false`.
6. `allBookList()`: Displays a formatted list of all books in the catalog with their titles, authors, and availability statuses.
