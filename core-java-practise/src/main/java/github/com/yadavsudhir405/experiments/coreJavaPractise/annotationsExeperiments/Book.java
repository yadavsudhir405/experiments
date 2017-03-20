package github.com.yadavsudhir405.experiments.coreJavaPractise.annotationsExeperiments;

import java.lang.annotation.Annotation;

/**
 * @author sudhir
 *         Date:1/12/16
 *         Time:7:40 AM
 *         Project:core-java-practise
 */
@BookDetail(author = "customAuthour",publisher = "customPublisher")
public class Book {
    private String name;
    private String author;
    private String publisher;
    private int price;

    public Book(String owner, int price) {
        this.name = owner;
        this.price = price;
        assignAuthorAndPublisher();
    }
    private void assignAuthorAndPublisher(){
        Class<? extends Book> bookClass=this.getClass();
        if (bookClass.isAnnotationPresent(BookDetail.class)){
            Annotation annotation=bookClass.getAnnotation(BookDetail.class);
            BookDetail bookDetail=(BookDetail)annotation;
            assignValuesFromMetaData(bookDetail);
        }
    }
    private void assignValuesFromMetaData(BookDetail bookDetail){
        this.author=bookDetail.author();
        this.publisher=bookDetail.publisher();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (price != book.price) return false;
        return name != null ? name.equals(book.name) : book.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                '}';
    }
}
