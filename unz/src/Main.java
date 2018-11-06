import java.io.*;
import java.util.*;

public class Main {

    private static ArrayList<Book> range = new ArrayList<>();

    public static void main(String[] args){
        readFile();
        sortingByAuthor();
//        sortingByGenre();
        writeFile();
        selling();
    }

    private static void writeFile(){
        try {
            File file = new File("output.txt");
            FileWriter writer = new FileWriter(file, false);
            int indx = 0;
            for (Book b :range) {
                writer.write(indx+" "+ b + "\n");
                writer.flush();
                indx++;
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }

    private static void readFile() {
        try{
        Scanner reader = new Scanner(new File("input.txt"));
        while (reader.hasNext()) {
            String[] line = reader.nextLine().split(" ");
            Book book = new Book();
            book.setAuthor(line[0]);
            book.setTitle(line[1]);
            book.setGenre(line[2]);
            book.setPrice(Double.valueOf(line[3]));
            range.add(book);
        }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    private static void sortingByAuthor(){
        Collections.sort(range);
        for (Book b: range){
            System.out.println(range.indexOf(b)+ " " + b);
        }
    }

    private static void sortingByGenre(){
        range.sort(Comparator.comparing(Book::getGenre));
//        range.sort((p1, p2)->p1.getGenre().compareTo(p2.getGenre()));
        for (Book b: range){
            System.out.println(range.indexOf(b)+ " " + b);
        }
    }

    private static void selling(){
        Scanner sc = new Scanner(System.in);
        Scanner qq = new Scanner(System.in).useDelimiter(" *");

        try {
            System.out.println("Bank ");
            double bank = sc.nextDouble();
            double check = 0;
            System.out.println("Choose ");
            ArrayList<Integer> selected = new ArrayList<>();
            while (qq.hasNextInt()){
                selected.add(qq.nextInt());
            }
            for (Integer i : selected) {
                check += range.get(i).getPrice();
            }

            if (bank < check) {
                System.out.println("Check: " + check + ". Not enough money");
            } else if (bank == check) {
                System.out.println("Check: " + check + "Thanks");
            } else {
                System.out.println("Check: " + check + ". Thanks. Your change: " + (bank - check));
            }
        }catch (InputMismatchException e){
            System.out.println("Wrong Type!");
        }catch (IndexOutOfBoundsException e){
            System.out.println("Wrong index! We haven't this one!");
        }
    }

}
