package ua.opnu;

public class BookData implements Comparable<BookData> {

    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        if (reviews == 0) {
            return 0.0;   // без відгуків вважаємо рейтинг 0
        }
        return total / reviews;
    }

    @Override
    public int compareTo(BookData other) {
        double r1 = this.getRating();
        double r2 = other.getRating();

        if (r1 > r2) {
            // кращий рейтинг → "менше"
            return -1;
        } else if (r1 < r2) {
            return 1;
        } else {
            // рівні рейтинги → порівнюємо за назвою звичайно
            return this.title.compareTo(other.title);
        }
    }

    @Override
    public String toString() {
        return "BookData{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", reviews=" + reviews +
                ", total=" + total +
                ", rating=" + getRating() +
                '}';
    }
}