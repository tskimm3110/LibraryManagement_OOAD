import model.*;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Calendar calBorrow = Calendar.getInstance();
        Date borrowDate = calBorrow.getTime();
        calBorrow.add(Calendar.DAY_OF_MONTH, 7); // due in 7 days
        Date dueDate = calBorrow.getTime();

        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.DECEMBER, 30);
        Date releaseDate = cal.getTime();


        List<Category> categories = new ArrayList<>();

        List<Book> books = new ArrayList<>();

        List<BookCopy> bookCopies = new ArrayList<>();

        List<Member> members  = new ArrayList<>();

        List<Librarian> librarians = new ArrayList<>();

        categories.add(new Category(1,"Programming"));
        categories.add(new Category(2,"Math"));
        categories.add(new Category(3,"History"));

        System.out.println("Categories : "+categories);
        System.out.println();
        System.out.println();


        books.add(new Book(1,"Learn C++","Mrr KokoMa",releaseDate,new HashSet<>(List.of(categories.get(0), categories.get(1)))));
        System.out.println("Books  : "+books);
        System.out.println();
        System.out.println();

        bookCopies.add(new BookCopy(1,1,false,books.get(0)));
        bookCopies.add(new BookCopy(2,1,false,books.get(0)));
        bookCopies.add(new BookCopy(3,1,false,books.get(0)));
        bookCopies.add(new BookCopy(4,1,false,books.get(0)));

        System.out.println("Books Copies : " + bookCopies);
        System.out.println();
        System.out.println();


        librarians.add(new Librarian(1,"MORNING",new Date(),1,"staff-kaka","kaka123!@#","098881323","ouressey"));

        members.add(new Member(1,"kiki","kiki!@#123","0966931313","toul kork",new Date(),10));

    }


    public static void setBorrowStatus(Transaction transaction, boolean isBorrowed) {
        for(BookCopy bc : transaction.getBooks()) {
            bc.setBorrow(isBorrowed);
        }
    }

    public static void checkBookStatus(List<BookCopy> bookCopies){
        System.out.println("BookCopy statuses after borrow:");
        for (BookCopy copy : bookCopies) {
            System.out.println("Book Title : " + copy.getBook().getTitle() +" | Copy " + copy.getCopyId() + " borrowed ? " + copy.isBorrow());
        }
        System.out.println();
        System.out.println();
    }

    public static void printTransaction(Transaction t) {
        System.out.println("====->> Transaction ID: " + t.getTransactionId());
        System.out.println(" \t->> Handled By: " + t.getHandleBy().getUserName());
        System.out.println(" \t->> Borrowed By: " + t.getMember().getUserName());
        System.out.println(" \t->> Created At: " + t.getCreatedAt());
        System.out.println(" \t->> Books:");
        for (BookCopy bc : t.getBooks()) {
            System.out.println("\t - " + bc.getBook().getTitle() + " (Copy ID: " + bc.getCopyId() + ", Borrowed: " + bc.isBorrow() + ")");
        }
    }

    public static void printHistory( List<Member> members){
        for (Member m : members) {
//            System.out.println("Member: " + m.getUserName());
            for (History h : m.getHistories()) {
                System.out.println("  History ID: " + h.getHistoryId() + ", Date: " + h.getDate());
//                System.out.println("Transactions : "+h.getTransactions().toArray().length);
                for (Transaction t : h.getTransactions()) {
                    printTransaction(t);
//                    System.out.println("    Books:");
//                    for (BookCopy bc : t.getBooks()) {
//                        System.out.println("      - " + bc.getBook().getTitle() + " (Copy ID: " + bc.getCopyId() + ", Borrowed: " + bc.isBorrow() + ")");
//                    }
                    if (t instanceof Borrow) {
                        System.out.println("    Due Date: " + ((Borrow) t).getDueDate());
                        System.out.println();
                        System.out.println();

                    }
                }
            }
        }
    }

}