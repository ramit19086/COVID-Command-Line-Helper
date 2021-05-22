import java.util.ArrayList;

public class Institute
{
    private String name=null;

    private double maxtemp=0, mino =0 ;
    private int bedsavail=0;

    private String status="Open";

    public void decBedsavail(){
        bedsavail--;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public double getMaxtemp() {
        return maxtemp;
    }

    public double getMino() {
        return mino;
    }

    public int getBedsavail() {
        return bedsavail;
    }

    public ArrayList<Patient> getPlist() {
        return Plist;
    }


    private ArrayList<Patient> Plist;

    public Institute(String name, double maxtemp, double mintemp, int bedsavail) {
        this.name = name;
        this.maxtemp = maxtemp;
        this.mino = mintemp;
        this.bedsavail = bedsavail;
        this.Plist=new ArrayList<>();
    }

    public void addP(Patient p)
    {
        this.Plist.add(p);
    }

    public Institute Display(){
        System.out.println(name+
                "\nTemperature should be <= "+
                maxtemp+"\nOxygen level should be >= "+
                mino + "\nNo. of available beds: "+
                bedsavail+"\nAdmission Status: "+status);
        return this;
    }
}
