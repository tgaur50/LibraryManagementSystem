package SwingDemos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LibraryManagement {
    private ArrayList<Books> listOfBooks;
    private ArrayList<IssuedBook> listOfIssuedBooks;
    private ArrayList<Librararian> listOfLibrarians;

    public LibraryManagement(){
        listOfBooks = new ArrayList<>();
        listOfIssuedBooks = new ArrayList<>();
        listOfLibrarians = new ArrayList<>();
    }

    public LibraryManagement(ArrayList<Books> listOfBooks, ArrayList<IssuedBook> listOfIssuedBooks, ArrayList<Librararian> listOfLibrarians) {
        this.listOfBooks = listOfBooks;
        this.listOfIssuedBooks = listOfIssuedBooks;
        this.listOfLibrarians = listOfLibrarians;
    }

    public ArrayList<Books> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(ArrayList<Books> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public ArrayList<IssuedBook> getListOfIssuedBooks() {
        return listOfIssuedBooks;
    }

    public void setListOfIssuedBooks(ArrayList<IssuedBook> listOfIssuedBooks) {
        this.listOfIssuedBooks = listOfIssuedBooks;
    }

    public ArrayList<Librararian> getListOfLibrarians() {
        return listOfLibrarians;
    }

    public void setListOfLibrarians(ArrayList<Librararian> listOfLibrarians) {
        this.listOfLibrarians = listOfLibrarians;
    }
}
