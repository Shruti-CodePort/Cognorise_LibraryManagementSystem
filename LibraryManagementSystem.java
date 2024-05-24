import java.util.*;
class Book 
{
    private String title;
    private String author;
    private boolean checkedOut;
    public Book(String title, String author) 
    {
        this.title = title;
        this.author = author;
        this.checkedOut = false;
    }
    public String getTitle() 
    {
        return title;
    }
    public String getAuthor() 
    {
        return author;
    }
    public boolean isCheckedOut() 
    {
        return checkedOut;
    }
    public void setCheckedOut(boolean checkedOut) 
    {
        this.checkedOut = checkedOut;
    }
}
class LibraryCatalog 
{
    private ArrayList<Book> bookList = new ArrayList<>();
    public void addBook(Book book) 
    {
        bookList.add(book);
        System.out.println("Book added to the catalog: " + book.getTitle());
    }
    public void searchByTitle(String title) 
    {
        for (Book book : bookList) 
        {
            if (book.getTitle().equalsIgnoreCase(title)) 
            {
                System.out.println("Book found: "+book.getTitle()+" by "+book.getAuthor());
                System.out.println("Status: "+(book.isCheckedOut() ? "Checked Out" : "Available"));
                return;
            }
        }
        System.out.println("Book not found in the catalog."+title);
    }
    public void searchByAuthor(String author) 
    {
        for (Book book : bookList) 
        {
            if (book.getAuthor().equalsIgnoreCase(author)) 
            {
                System.out.println("Book found: "+book.getTitle()+" by "+book.getAuthor());
                System.out.println("Status: "+(book.isCheckedOut() ? "Checked Out" : "Available"));
                return;
            }
        }
        System.out.println("No books found by the author "+author);
    }
    public void checkOutBook(String title) 
    {
        for (Book book : bookList) 
        {
            if (book.getTitle().equalsIgnoreCase(title)) 
            {
                if (book.isCheckedOut()) 
                {
                    System.out.println("Sorry, the book is already checked out.");
                } 
                else 
                {
                    book.setCheckedOut(true);
                    System.out.println("Book checked out: "+book.getTitle());
                }
                return;
            }
        }
        System.out.println("Book not found in the catalog.");
    }
    public void returnBook(String title) 
    {
        for (Book book : bookList) 
        {
            if (book.getTitle().equalsIgnoreCase(title)) 
            {
                if (book.isCheckedOut()) 
                {
                    book.setCheckedOut(false);
                    System.out.println("Book returned: "+book.getTitle());
                } 
                else 
                {
                    System.out.println("This book is already available in the catalog.");
                }
                return;
            }
        }
        System.out.println("Book not found in the catalog.");
    }
    public void allBookList() 
    {
        String check;
        Iterator<Book> itr = bookList.iterator();
        while (itr.hasNext()) 
        {
            Book bk = itr.next();
            if (bk.isCheckedOut()) 
            {
                check="checked Out";
            } 
            else 
            {
                check="Available";
            }
            System.out.printf("| %-25s | %-20s | %-10s |%n", bk.getTitle(), bk.getAuthor(), check);
            System.out.println("----------------------------------------------------------------");
        }
    }
}
public class LibraryManagementSystem 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        LibraryCatalog catalog=new LibraryCatalog();

        while(true) 
        {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a book");
            System.out.println("2. Search by title");
            System.out.println("3. Search by author");
            System.out.println("4. Check out a book");
            System.out.println("5. Return a book");
            System.out.println("6. Show the Library Catalogue");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice=sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title=sc.nextLine();
                    System.out.print("Enter book author: ");
                    String author=sc.nextLine();
                    Book book=new Book(title, author);
                    catalog.addBook(book);
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    title=sc.nextLine();
                    catalog.searchByTitle(title);
                    break;
                case 3:
                    System.out.print("Enter author name: ");
                    author=sc.nextLine();
                    catalog.searchByAuthor(author);
                    break;
                case 4:
                    System.out.print("Enter book title: ");
                    title=sc.nextLine();
                    catalog.checkOutBook(title);
                    break;
                case 5:
                    System.out.print("Enter book title: ");
                    title=sc.nextLine();
                    catalog.returnBook(title);
                    break;
                case 6:
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("|           Title           |         Author       |   Status   |");
                    System.out.println("----------------------------------------------------------------");
                    catalog.allBookList();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}