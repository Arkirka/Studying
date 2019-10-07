package sample.sample;

public class WorkOrders {
    private int shiftId;
    private int numWrksh;
    private int month;
    private String techOper;
    private int mnCount;
    private int price;
    private int priceAll;

    public WorkOrders(int shiftId, int numWrksh, int month, String techOper, int mnCount, int price, int priceAll) {
        this.shiftId = shiftId;
        this.numWrksh = numWrksh;
        this.month = month;
        this.techOper = techOper;
        this.mnCount = mnCount;
        this.price = price;
        this.priceAll = priceAll;
    }
    
    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public int getNumWrksh() {
        return numWrksh;
    }

    public void setNumWrksh(int numWrksh) {
        this.numWrksh = numWrksh;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getTechOper() {
        return techOper;
    }

    public void setTechOper(String techOper) {
        this.techOper = techOper;
    }

    public int getMnCount() {
        return mnCount;
    }

    public void setMnCount(int mnCount) {
        this.mnCount = mnCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPriceAll() {
        return priceAll;
    }

    public void setPriceAll(int priceAll) {
        this.priceAll = priceAll;
    }


}
