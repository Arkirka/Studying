package sample.sample;
/**
 * @author Arkirka
 */

public class Workers {
    private int id;
    private String sfp;
    private int numWrksh;

    public Workers(int id, String sfp, int numWrksh) {
        this.id = id;
        this.sfp = sfp;
        this.numWrksh = numWrksh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSfp() {
        return sfp;
    }

    public void setSfp(String sfp) {
        this.sfp = sfp;
    }

    public int getNumWrksh() {
        return numWrksh;
    }

    public void setNumWrksh(int numWrksh) {
        this.numWrksh = numWrksh;
    }
}
