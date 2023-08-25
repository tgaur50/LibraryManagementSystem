package SwingDemos;
import java.util.Date;

public class Books {
    private int id;
    private String callNo;
    private String bookName;
    private String authorName;
    private String publisherName;
    private int quantity;
    private int issuedQuantity;
    private String addedDate;
    public Books(int id, String callNo, String bookName, String authorName, String publisherName, int quantity, int issuedQuantity, String addedDate) {
        this.id = id;
        this.callNo = callNo;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.quantity = quantity;
        this.issuedQuantity = issuedQuantity;
        this.addedDate = addedDate;
    }

    public Books() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCallNo() {
        return callNo;
    }

    public void setCallNo(String callNo) {
        this.callNo = callNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(int issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }
}
