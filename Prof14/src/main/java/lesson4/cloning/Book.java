package lesson4.cloning;

public class Book implements Cloneable {
    private String name;
    private int year;
    private Author author;

    public Book(String name, int year, Author author) {
        this.name = name;
        this.year = year;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", author=" + author +
                '}';
    }

    @Override
    protected Book clone() throws CloneNotSupportedException {
        Book newBook = (Book) super.clone(); // Приводем объект к типу Book и вызываем метод  clone
                                             // супер класса Object (это собственные поля)
        newBook.author=(Author) author.clone(); // Поле ссылочного типа - объект из класса Author (для этого
                                                // в самом классе Author нужно переопределить метод clone
        return newBook;
    }
}