/*
Difficulty: Medium
Time limit: 2–3 hours
Language: Java
Requirements: Console-based application using OOP, ArrayList, loops, functions, and conditional statements. No external frameworks.
Problem statement
Build a Library Management System that allows a librarian to manage books and student borrowing records.
Functional requirements
1. Add a book
- Generate a unique book ID.
- Store the book title, author, and number of available copies.
- Do not allow duplicate IDs.
2. View all books
- Display every book with its ID, title, author, and available copies.
- Show a message if the library is empty.
3. Search for a book
- Search by book ID or title.
- Display matching books.
4. Update book details
- Update a book's title, author, or available copies.
- Do not allow negative copies.
5. Remove a book
- Remove a book using its ID.
- Do not remove a book if it currently has borrowed copies.
6. Register a student
- Generate a unique student ID.
- Store the student's name.
7. Borrow a book
- Accept a student ID and book ID.
- Check whether both exist.
- Allow borrowing only if at least one copy is available.
- Decrease the available copy count by one.
- Record which student borrowed the book.
8. Return a book
- Accept a student ID and book ID.
- Verify that the student actually borrowed that book.
- Increase the available copy count by one.
- Remove the corresponding borrowing record.
9. View borrowing records
- Display all currently borrowed books, along with student IDs and book IDs.
10. Main menu
Keep displaying the menu until the user chooses Exit.
===== LIBRARY MANAGEMENT SYSTEM =====

1. Add Book
2. View All Books
3. Search Book
4. Update Book
5. Remove Book
6. Register Student
7. Borrow Book
8. Return Book
9. View Borrowing Records
10. Exit

Enter your choice: */
import java.util.*;
public class lms {
    static Scanner sc=new Scanner(System.in);
    static List<Integer>bookid=new ArrayList<>();
    static List<String>bookname=new ArrayList<>();
    static List<String>authorlist=new ArrayList<>();
    static List<Integer>copies=new ArrayList<>();
    static  int nextid=100;
    private static void addbooks(){
        System.out.println("Enter book name");
        String name=sc.nextLine();
        System.out.println("Enter name of the author");
        String author=sc.nextLine();
        System.out.println("Enter the number of copies");
        int copy = sc.nextInt();
        sc.nextLine();
        int id = nextid++;
        bookid.add(id);
        bookname.add(name);
        authorlist.add(author);
        copies.add(copy);

    }
    private static void viewallbooks(){
        System.out.println("all the books present are");
        for(int i=0;i<bookname.size();i++){
            System.out.println(bookname.get(i));
        }
    }
    private static void searchbook(){
        System.out.println("Enter book id to search");
        int n=sc.nextInt();
        for(int i=0;i<bookid.size();i++){
            if(bookid.get(i)==n){
                System.out.println(bookname.get(i));
                System.out.println(authorlist.get(i));
            }
        }

    }
    
    public static void main(String[] args) {
        System.out.println("Enter your choice: ");
        System.out.println("1: Add book");
        System.out.println("2: View all books");
        System.out.println("3: search books");
        System.out.println("4: update book");
        System.out.println("5: remove book");
        System.out.println("6: register student");
        System.out.println("7: borrow book");
        System.out.println("8: Return book");
        System.out.println("9: view borrowing records");
        System.out.println("10: exit");
        int n=sc.nextInt();
        switch (n) {
            case 1:
                addbooks();
                break;
        }
    }
    
}
