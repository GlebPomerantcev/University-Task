import java.util.Objects;

public class Book implements Comparable<Book> {
    private String author;
    private String title;
    private String genre;
    private double price;

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                Objects.equals(author, book.author) &&
                Objects.equals(title, book.title) &&
                Objects.equals(genre, book.genre);
    }

    @Override
    public String toString() {
        return author + " " + title + " " + genre + " " + price;
    }

    @Override
    public int compareTo(Book book) {
        String s1 = getAuthor() + getTitle();
        String s2 = book.getAuthor() + book.getTitle();
        return s1.compareTo(s2);
    }
}
