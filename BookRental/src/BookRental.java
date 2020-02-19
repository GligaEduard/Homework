import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRental  {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        boolean running = true;
        List<Book> inventory = new ArrayList<>();
        List<Book> availableBooks = new ArrayList<>();
        List<Book> rentedBooks = new ArrayList<>();
        System.out.println("Hello there! Available options are: \n 1. Add a book \n 2. Display all books from inventory \n 3. Rent a book \n 4. Return a book \n 5. Display all books by author" +
                "\n 6. Display all books by title \n 7. Display all books by type \n 8. Display all options again \n 9. Close the program ");
        while (running){
            int userChoice = keyboard.nextInt();

            if (userChoice == 1){

                int isbn;
                System.out.println("Please enter the ISBN.");
                isbn = keyboard.nextInt();

                 String publisher;
                System.out.println("Please enter the publisher.");
                 publisher = keyboard.next();

                 String author;
                System.out.println("Please enter the author name.");
                author = keyboard.next();

                String title;
                System.out.println("Please enter the title.");
                title = keyboard.next();

                int year;
                System.out.println("Please enter the release year of book.");
                year = keyboard.nextInt();

                String type;
                System.out.println("Please enter the type of book (AudioBook, Kindle, HardCover and Paperbook).");
                type = keyboard.next();


                if(type.equalsIgnoreCase("Kindle")){
                    int storageSize;
                    System.out.println("Please enter your remain storage in GB");
                    storageSize = keyboard.nextInt();
                    Kindle kindle = new Kindle(isbn, publisher, author, title, year, type, storageSize);
                    inventory.add(kindle);
                    availableBooks.add(kindle);
                } else if (type.equalsIgnoreCase("AudioBook")){
                    String mp3 = "mp3";
                    AudioBook audioBook = new AudioBook(isbn, publisher, author, title, year, type, mp3);
                    inventory.add(audioBook);
                    availableBooks.add(audioBook);
                } else if (type.equalsIgnoreCase("HardCover")){
                    String coverMaterial = "Plastic Cover";
                    HardCover hardCover = new HardCover(isbn, publisher, author, title, year, type, coverMaterial);
                    inventory.add(hardCover);
                    availableBooks.add(hardCover);
                } else if (type.equalsIgnoreCase("PaperBook")){
                    int price = 10;
                    PaperBook paperBook = new PaperBook(isbn, publisher, author, title, year, type, price);
                    inventory.add(paperBook);
                    availableBooks.add(paperBook);
                } else {
                    Book book = new Book(isbn, publisher, author, title, year, type);
                    inventory.add(book);
                    availableBooks.add(book);
                }
//
            }

            if(userChoice == 2){
                System.out.println(inventory);
            }

            if(userChoice == 3){
                System.out.println("Please enter the isbn of the book you want to rent.");
                int isbnForRent = keyboard.nextInt();
                boolean bookFoundInInventory = false;
                if(inventory.isEmpty()){
                    try {
                        throw new Exception("Inventory is empty for now.");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                for (int bookNo = 0; bookNo < inventory.size(); bookNo++ ){
                    if(inventory.get(bookNo).getIsbn() == isbnForRent) bookFoundInInventory = true;
                }
                if(!bookFoundInInventory){
                    System.out.println("The book is not found in the inventory.");
                } else {
                   if (availableBooks.isEmpty()){
                       try {
                           throw new Exception("We have no available books.");
                       }
                       catch (Exception e){
                           e.printStackTrace();
                       }
                }
                   boolean bookFoundInAvailable = false;
                   for( int bookNo = 0; bookNo < availableBooks.size(); bookNo++){
                       if(availableBooks.get(bookNo).getIsbn() == isbnForRent){
                           rentedBooks.add(availableBooks.get(bookNo));
                           availableBooks.remove(bookNo);
                           bookFoundInAvailable = true;
                           System.out.println("Book with isbn:" + isbnForRent + " was succesfully rented.");
                       }
                   }
                   if(!bookFoundInAvailable){
                       System.out.println("The book with isbn: " +isbnForRent + " is already rented.");
                   }

                }


            }
            if(userChoice == 4){
                System.out.println("Please enter the ISBN of book you want to return");
                int isbnToReturn = keyboard.nextInt();
                boolean bookFoundinRented = false;
                for (int bookNo = 0; bookNo < rentedBooks.size(); bookNo++){
                    if(rentedBooks.get(bookNo).getIsbn() == isbnToReturn){
                        availableBooks.add(rentedBooks.get(bookNo));
                        rentedBooks.remove(bookNo);
                        bookFoundinRented = true;
                        System.out.println("Book with isbn:" + isbnToReturn + " was succesfully returned.");
                    }
                }

                if(!bookFoundinRented){
                    try {
                        throw new Exception("The book is not found in rented books.");
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }

            }
            if(userChoice == 5){

                System.out.println("Enter the name of the author`s book you`re looking for.");
                String enteredAuthor = keyboard.next();

                for (int author = 0; author<availableBooks.size(); author++){
                    if (availableBooks.get(author).getAuthor().equalsIgnoreCase(enteredAuthor)){
                        System.out.println(availableBooks.get(author));


                    }
                }
            }
            if(userChoice == 6){

                System.out.println("Please enter the book title are you looking for.");
                String enteredTitle = keyboard.next();

                for (int title = 0; title<availableBooks.size(); title++){
                    if(availableBooks.get(title).getAuthor().equalsIgnoreCase(enteredTitle)){
                        System.out.println(availableBooks.get(title));
                    }
                }
            }
            if(userChoice == 7){

                System.out.println("Please enter the type of book are you looking for(Kindle, AudioBook, HardCover, PaperBook).");
                String enteredType = keyboard.next();

                for(int type = 0; type<availableBooks.size(); type++){
                    if(availableBooks.get(type).getType().equalsIgnoreCase(enteredType)){
                        System.out.println(availableBooks.get(type));
                    }
                }
            }
            if(userChoice == 8){
                System.out.println("Available options are: \n 1. Add a book \n 2. Display all books from inventory \n 3. Rent a book \n 4. Return a book \n 5. Display all books by author \n 6. Display all books by title \n 7. Display all books by type \n 8. Display all options. \n 9. Close the program");
            }
            if(userChoice == 9){
                System.out.println("We are wainting you back. Goodbye!");
                running = false;
            }
            if (userChoice >= 10){
                System.out.println("You entered a wrong option! Available options are: \n 1. Add a book \n 2. Display all books from inventory \n 3. Rent a book \n 4. Return a book \n 5. Display all books by author \n 6. Display all books by title \n 7. Display all books by type \n 8. Display all options \n 9. Close the program.");
            }







        }


    }
}
