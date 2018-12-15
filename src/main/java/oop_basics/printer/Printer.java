package oop_basics.printer;

public class Printer {
    private int tonerLevel;
    private int simplexPrinted;
    private int duplexPrinted;
    private int paperInStock;

    public Printer(int tonerLevel, int paperInStock) {
        if (tonerLevel >= 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        }
        if (paperInStock >= 0 && paperInStock <= 1000) {
            this.paperInStock = paperInStock;
        }
        this.simplexPrinted = 0;
        this.duplexPrinted = 0;
    }

    public void print(int printPages, boolean duplex) {    //duplex - mode that allows the printing of a sheet of paper on both sides automatically
        if (this.tonerLevel - (printPages * 5) < 0) {    //5 - conditional number of toner losses per page
            System.out.println("Printing is not possible. Toner level is insufficient.");
        } else if (!duplex && this.paperInStock - printPages < 0) {
            System.out.println("Printing is not possible. Not enough paper for this operation.");
        } else if (duplex && printPages == 1) {
            System.out.println("Duplex mode is useless for one-page printing. Please try again with more pages to print or change the printing mode.");
        } else if (duplex && (printPages % 2 != 0) && this.paperInStock - (printPages / 2 + 1) < 0 || duplex && (printPages % 2 == 0) && this.paperInStock - (printPages / 2) < 0) {
            System.out.println("Printing is not possible. Not enough paper for this operation.");
        } else {
            this.tonerLevel -= (printPages * 5);
            if (!duplex) {
                this.simplexPrinted += printPages;
                this.paperInStock -= printPages;
                System.out.println("Simplex printing started: " + printPages + " simplex pages printed. Total number of simplex printed pages: " + this.simplexPrinted);
            } else {      //in duplex mode, we use only a half of paper
                if (printPages % 2 == 0) {
                    this.paperInStock -= printPages / 2;
                } else {
                    this.paperInStock -= (printPages / 2) + 1;
                }
                this.duplexPrinted += printPages;
                System.out.println("Duplex printing started: " + printPages + " duplex pages printed. Total number of duplex printed pages: " + this.duplexPrinted);
            }
            System.out.println("Remaining toner level: " + this.tonerLevel + "% | Paper in stock: " + this.paperInStock);
        }
    }

    public void tonerRefill() {
        this.tonerLevel = 100;
        System.out.println("The toner level refilled by a new cartridge. Toner level is " + this.tonerLevel + "%");
    }

    public void paperRefill(int paper) {
        if (paper + this.paperInStock >= 0 && paper + this.paperInStock <= 1000 && paper > 0) {
            this.paperInStock += paper;
            System.out.println("The printer refilled with new sheets of paper. Paper in stock: " + this.paperInStock);
        } else {
            System.out.println("Incorrect procedure of paper refilling.");
        }
    }

    public String getPrinterStatus() {
        return "Current toner level: " + this.tonerLevel + "%. Paper in stock: " + this.paperInStock;
    }

    public String getPrintedPages() {
        return "Total amount of printed pages is: " + (this.simplexPrinted + this.duplexPrinted) + ". Including: in simplex mode - " + this.simplexPrinted + " | in duplex mode - " + this.duplexPrinted + "\n";
    }
}

