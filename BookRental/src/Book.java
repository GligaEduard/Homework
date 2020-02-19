public class Book {

    private int isbn;
    private String publisher;
    private String author;
    private String title;
    private int year;
    private String type;

    public Book(int isbn, String publisher, String author, String title, int year, String type) throws Exception {
        this.isbn = isbn;
        this.publisher = publisher;

        if(author.length() < 1){
            try {
                throw new Exception("Name must contain minimum one char.");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        this.author = author;

       if(title.length()<1){
           try {
               throw new Exception("Title must contain minimum one char");
           }catch (Exception e){
               e.printStackTrace();
           }
       }
        this.title = title;

        if(year < 0){
            try {
                throw new Exception("Please enter a year greater than 1");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        this.year = year;

        if (!type.equalsIgnoreCase("Kindle") && !type.equalsIgnoreCase("AudioBook") && !type.equalsIgnoreCase("PaperBook") && !type.equalsIgnoreCase("HarcCover")) {
            try {
                throw new Exception("Enter the corect Type.");
            }catch (Exception e){
                e.printStackTrace();
            }
            }
            this.type = type;

        }


    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return
                "isbn= " + isbn  + "\n" +
                " publisher= " + publisher + '\n' +
                " author= " + author + '\n' +
                " title= " + title + '\n' +
                " year= " + year + "\n" +
                " type= " + type ;
    }
}
