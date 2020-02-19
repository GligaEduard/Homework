public class PaperBook extends Book {
    private int price;
    @Override
    public String toString() {
        return
                "isbn= " + super.getIsbn() + "\n" +
                        " publisher= " + super.getPublisher() + '\n' +
                        " author= " + super.getAuthor() + '\n' +
                        " title= " + super.getTitle() + '\n' +
                        " year= " + super.getYear() + "\n" +
                        " type= " + super.getType() + "\n" +
                        " price= " + price;
    }

    public PaperBook(int isbn, String publisher, String author, String title, int year, String type, int price) throws Exception {
        super(isbn, publisher, author, title, year, type);
        this.price = price;
    }
}
