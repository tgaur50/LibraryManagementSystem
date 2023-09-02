package SwingDemos;

public class IssuedBook {
    private int id;
    private String bookCallNo;
    private String studentId;
    private String studentName;
    private String studentContact;
    private String issuedDate;

    public IssuedBook(){}

    public IssuedBook(int id, String bookCallNo, String studentId, String studentName, String studentContact, String issuedDate) {
        this.id = id;
        this.bookCallNo = bookCallNo;
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentContact = studentContact;
        this.issuedDate = issuedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookCallNo() {
        return bookCallNo;
    }

    public void setBookCallNo(String bookCallNo) {
        this.bookCallNo = bookCallNo;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentContact() {
        return studentContact;
    }

    public void setStudentContact(String studentContact) {
        this.studentContact = studentContact;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }
}
