import java.util.Scanner;

public class work
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Camp c=new Camp();
        int noofpatients=Integer.parseInt(sc.nextLine());
        for (int i = 0; i < noofpatients; i++) {
            var s=sc.nextLine().split(" ");
            c.addP(s);
        }
        while(c.getpAdmit()!=noofpatients)
        {
            int qno=sc.nextInt();

            if(qno==1) {
                String s=sc.next();
                System.out.println("Enter critical temperature");
                double t=sc.nextDouble();
                System.out.println("Enter Oxygen Level");
                double o=sc.nextDouble();
                System.out.println("Enter No of avail beds");
                int b=sc.nextInt();
                c.addH(s,t,o,b);
            }
            else if(qno==2) c.removeP();
            else if(qno==3) c.removeH();
            else if(qno==4) c.getPnotadmiited();
            else if(qno==5) c.getHadmit();
            else if(qno==6) c.dispH(sc.next());
            else if(qno==7) c.dispP(sc.nextInt());
            else if(qno==8) c.dispAllP();
            else if(qno==9) c.dispPinH(sc.next());


        }
    }
}

