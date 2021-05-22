public class Patient
{
    private static int uid=0;

    private String iadmitted=null;

    private final String name;

    private final int age;
    private final double olevel;
    private final double temp;
    private final int id;
    private final int redays;


    Patient(String[] s)
    {
        this.name=s[0];
        this.temp=Double.parseDouble(s[1]);
        this.olevel=Double.parseDouble(s[2]);
        this.age=Integer.parseInt(s[3]);
        this.id=++uid;
        this.redays=(int)(100-this.olevel)+(int)Math.abs((int)(this.temp-98))+2;
    }

    public int getRedays() {
        return redays;
    }

    public String getIadmitted() {
        return iadmitted;
    }

    public void setIadmitted(String iadmitted) {
        this.iadmitted = iadmitted;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getOlevel() {
        return olevel;
    }

    public double getTemp() {
        return temp;
    }

    public int getId() {
        return id;
    }

    public void Display(){
        System.out.println(id+" "+name);
    }

    public void deepDisplay(){
        System.out.println(id+" "+ name+
                "\n Temperature is: "+temp+
                "\n Oxygen level is: "+olevel+
                (iadmitted==null?"\nAdmission Status: not admitted":("\nAdmission Status: Admitted "+"\nAdmitting Institute: "+iadmitted)) );
    }

}
