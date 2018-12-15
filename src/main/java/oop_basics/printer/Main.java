package oop_basics.printer;

public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer(50, 7);
        System.out.println(printer.getPrinterStatus());
        System.out.println(printer.getPrintedPages());

        printer.print(1,false);
        printer.print(1,false);
        printer.print(1,false);

        System.out.println(printer.getPrinterStatus());
        printer.tonerRefill();
        printer.paperRefill(10);
        System.out.println(printer.getPrinterStatus());
        printer.print(5, true);
        System.out.println(printer.getPrintedPages());
        printer.print(3,true);
        System.out.println(printer.getPrintedPages());
        printer.print(2, true);
        printer.print(1, true);
        System.out.println(printer.getPrinterStatus());
        System.out.println(printer.getPrintedPages());

        printer.print(4,false);
        printer.print(2,false);
        printer.print(4, true);
        printer.print(2, true);
        System.out.println(printer.getPrintedPages());
        System.out.println(printer.getPrinterStatus());
    }
}
