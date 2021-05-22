import java.util.ArrayList;

public class Camp
{
    private ArrayList<Patient> Plist= new ArrayList<>();
    private ArrayList<Institute> Hlist=new ArrayList<>();

    private int pAdmit=0;

    public void addP(String[] s)
    {
        Plist.add(new Patient(s));
    }

    public int getpAdmit() {
        return pAdmit;
    }

    public void addH(String s,double pp,double q,int r)
    {
        Hlist.add(new Institute(s,pp,q,r));
        Institute now = Hlist.get(Hlist.size()-1).Display();
        for(Patient p:Plist)
        {
            if(p.getOlevel()>=now.getMino()&&now.getBedsavail()>0&&p.getIadmitted()==null)
            {
                p.setIadmitted(now.getName());
                now.addP(p);
                pAdmit++;
                now.decBedsavail();
                System.out.println("Recovery days for Patient ID: "+p.getId()+"- "+p.getRedays());
            }
        }
        if(now.getBedsavail()!=0)
        {
            for(Patient p:Plist)
            {
                if(p.getTemp()<=now.getMaxtemp()&&now.getBedsavail()>0&&p.getIadmitted()==null)
                {
                    p.setIadmitted(now.getName());
                    now.addP(p);
                    pAdmit++;
                    now.decBedsavail();
                    System.out.println("Recovery days for Patient ID: "+p.getId()+" - "+p.getRedays());
                }
            }
        }
        if(now.getBedsavail()==0)
            now.setStatus("Closed");
    }

    public void removeP()
    {
        for (int i = 0; i < Plist.size(); i++) {
            Patient p=Plist.get(i);
            if(p.getIadmitted()!=null)
            {
                System.out.println("Account removed of Patient Id - "+p.getId());
                Plist.remove(p);
                i--;
            }

        }
    }

    public void removeH()
    {
        for (int i = 0; i < Hlist.size(); i++) {
            Institute h=Hlist.get(i);
            if(h.getStatus().compareTo("Closed")==0)
            {
                System.out.println("Account removed of Institute - "+h.getName());
                Hlist.remove(h);
                i--;
            }

        }

    }

    public void  getPnotadmiited()
    {
        int sum=0;
        for (Patient p:Plist)
            sum+=(p.getIadmitted()==null?1:0);
        System.out.println(sum+" Patients");
    }

    public void getHadmit()
    {
        int sum=0;
        for (Institute h:Hlist)
            sum+=(h.getStatus().compareTo("Open")==0?1:0);
        System.out.println(sum+" institutes are admitting patients currently");
    }

    public void dispH(String s)
    {
        for (Institute h:Hlist)
        {
            if(h.getName().compareTo(s)==0)
            {
                h.Display();
                break;
            }
        }
    }

    public void dispP(int id)
    {
        for (Patient p:Plist)
        {
            if(p.getId()==id)
            {
                p.deepDisplay();
                break;
            }
        }

    }

    public void dispAllP()
    {
        for (Patient p:Plist)
            p.Display();

    }

    public void dispPinH(String s)
    {
        for (Institute h:Hlist)
        {
            if(h.getName().compareTo(s)==0)
            {
                var temp =h.getPlist();
                for(Patient p:temp)
                    System.out.println(p.getName()+" recovery time is "+p.getRedays());
            }
        }

    }



}
