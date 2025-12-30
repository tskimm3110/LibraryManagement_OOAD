import model.*;
import service.*;
import service.implementation.*;

import java.util.*;
public class Main {
    public static void main(String[] args) {


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
        members.add(new Member(2,"kiki2","kiki!@#1234","09669313443","toul kork2",new Date(),10));


        List<BookCopy> bookForBorrow = new ArrayList<>();

        bookForBorrow.add(bookCopies.get(0));
        bookForBorrow.add(bookCopies.get(1));

        BorrowService borrowService = new BorrowServiceImpl();

       Borrow borrow1 = borrowService.borrowBook(members.get(0),librarians.get(0),bookForBorrow);

        Borrow borrow2 = borrowService.borrowBook(members.get(0),librarians.get(0),bookForBorrow);

        Borrow borrow3 = borrowService.borrowBook(members.get(0),librarians.get(0),List.of(bookCopies.get(2)));

        Borrow borrow4 = borrowService.borrowBook(members.get(1),librarians.get(0),List.of(bookCopies.get(3)));


        printTransaction(borrow1);
        printTransaction(borrow2);
        printTransaction(borrow3);
        printTransaction(borrow4);

        ReturnService returnService = new ReturnServiceImpl();
        FineService fineService = new FineServiceImpl();
        PaymentService paymentService = new PaymentServiceImpl();

        Return return1 = returnService.returnBook(members.get(0),borrow1.getBooks(),librarians.get(0));
        Return return2 = returnService.returnBook(members.get(0),borrow1.getBooks(),librarians.get(0));





        printHistory(members);


        checkBookStatus(bookCopies);
        System.out.println(members);

        ReservationService reservationService = new ReservationServiceImpl();
        Reservation res = reservationService.reserveBook(members.get(0), bookCopies.get(0),librarians.get(0));
        System.out.println("Reservation status: " + res.getStatus());
        reservationService.fulfillReserve(res);
        System.out.println("Reservation status: " + res.getStatus());
        System.out.println(members);


        Reservation res2 = reservationService.reserveBook(members.get(1), bookCopies.get(0),librarians.get(0));
        System.out.println("\n\nReservation status : " + res2.getStatus());
        reservationService.cancelReserve(res2);
        System.out.println("Reservation status : " + res2.getStatus());

        printHistory(members);

    }

    public static void checkBookStatus(List<BookCopy> bookCopies){
        System.out.println();
        System.out.println();
        System.out.println("BookCopy statuses after borrow:");
        for (BookCopy copy : bookCopies) {
            System.out.println("Book Title : " + copy.getBook().getTitle() +" | Copy " + copy.getCopyId() + " borrowed ? " + copy.isBorrow());
        }
        System.out.println();
        System.out.println();
    }

    public static void printTransaction(Transaction t) {
       if(t != null){
           System.out.println("====->> Transaction ID: " + t.getTransactionId());
           System.out.println(" \t->> Handled By: " + t.getHandleBy());
           System.out.println(" \t->> Borrowed By: " + t.getMember().getUserName());
           System.out.println(" \t->> Created At: " + t.getCreatedAt());
           System.out.println(" \t->> Books:");
           for (BookCopy bc : t.getBooks()) {
               System.out.print("\t - " + bc.getBook().getTitle() + " (Copy ID: " + bc.getCopyId());
               if(!bc.isBorrow()){
                   System.out.println(", Type :  Return )");
               }else {
                   System.out.println(", Type :  Borrow )");

               }
           }
       }else {
           System.out.println("Borrow Cancel!");
       }
    }

    public static void printHistory( List<Member> members){
        for (Member m : members) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Member: " + m.getUserName());
            for (History h : m.getHistories()) {
                System.out.println("  History ID: " + h.getHistoryId() + ", Date: " + h.getDate());
//                System.out.println("Transactions : "+h.getTransactions().toArray().length);
                for (Transaction t : h.getTransactions()) {
                    printTransaction(t);
//                    System.out.println("    Books:");
//                    for (BookCopy bc : t.getBooks()) {
//                        System.out.println("      - " + bc.getBook().getTitle() + " (Copy ID: " + bc.getCopyId() + ", Borrowed: " + bc.isBorrow() + ")");
//                    }
                    if (t instanceof Return) {
                        System.out.println("    Return Date: " + ((Return) t).getReturnDate());
                        System.out.println();
                        System.out.println();
                    }
                    if (t instanceof Reservation) {
                        System.out.println("    Reservation Date: " + ((Reservation) t).getReservationDate());
                        System.out.println("    Reservation Status: " + ((Reservation) t).getStatus());
                        System.out.println();
                        System.out.println();
                    }
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