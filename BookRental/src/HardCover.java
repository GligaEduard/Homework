public class HardCover extends Book {
    private String coverMaterial;

    @Override
    public String toString() {
        return
                "isbn= " + super.getIsbn() + "\n" +
                        " publisher= " + super.getPublisher() + '\n' +
                        " author= " + super.getAuthor() + '\n' +
                        " title= " + super.getTitle() + '\n' +
                        " year= " + super.getYear() + "\n" +
                        " type= " + super.getType() + "\n" +
                        " cover material= " + coverMaterial;
    }

    public HardCover( int isbn, String publisher, String author, String title,int year, String type, String
        coverMaterial) throws Exception {
            super(isbn, publisher, author, title, year, type);
            this.coverMaterial = coverMaterial;
        }
    }


