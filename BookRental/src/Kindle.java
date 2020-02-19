public class Kindle extends Book {
    private int StorageSize;

    @Override
    public String toString() {
        return
                "isbn= " + super.getIsbn()  + "\n" +
                        " publisher= " + super.getPublisher() + '\n' +
                        " author= " + super.getAuthor() + '\n' +
                        " title= " + super.getTitle() + '\n' +
                        " year= " + super.getYear() + "\n" +
                        " type= " + super.getType() + "\n" +
                        " storage size= " + StorageSize;
    }


    public Kindle(int isbn, String publisher, String author, String title, int year, String type, int downloadSize) throws Exception {
        super(isbn, publisher, author, title, year, type);
        this.StorageSize = downloadSize;

    }

}

