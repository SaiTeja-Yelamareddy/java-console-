
import java.util.*;
class Opertions
{
    public double add(double a,double b)
    {
        return a+b;
    }
    public int add(int a,int b)
    {
        return a+b;
    }
    public double sub(double a,double b)
    {
        return a-b;
    }
       public int sub(int a,int b)
    {
        return a-b;
    }
    public double mul(double a,double b)
    {
        return a*b;
    }
        public int mul(int a,int b)
    {
        return a*b;
    }
     public double div(double a,double b)
    {
        if(b==0)
        {
            System.out.println("division is not possible");
            return 0;
        }
        return a/b;
    }
    public int div(int a,int b)
    {
        if(b==0)
        {
            System.out.println("division is not possible");
            return 0;
        }
        return a/b;
    }
}
class Calculator2
{
    public static void main(String args[])
    {
        Scanner h=new Scanner(System.in);
        Opertions ob=new Opertions();
        while(true)
        {
                      System.out.println("<---->Simple Calculator<----->");
          System.out.println("1.integer\n2.double");
          System.out.println("enter which  type you want: ");
          int type=h.nextInt();
          if(type>2)
          {
            System.out.println("you enter wrong type number exiting....!");
            break;
          }
          System.out.print("enter a value: ");
          double a=h.nextDouble();
          System.out.print("enter operator(+,-,*,/): ");
          char op=h.next().charAt(0);
          System.out.print("enter b value: ");
          double b=h.nextDouble();
          switch (op) {
            case '+':
            if(type==1)
            {
                System.out.println("Addition is "+(int)a+" + "+(int)b+" is "+ob.add((int)a,(int)b));
                break;
            }
            else
            {
                System.out.println("Addition is "+a+" + "+b+" is "+ob.add(a,b));  
                break;
            }
            case '-':
            if(type==1)
            {
                System.out.println("Subraction is "+(int)a+" - "+(int)b+" is "+ob.sub((int)a,(int)b));
                break;
            }
            else
            {
                System.out.println("Subraction is "+a+" - "+b+" is "+ob.sub(a,b));
                break;
            }
            case '*':
            if(type==1)
            {
                System.out.println("Multiplication is "+(int)a+" * "+(int)b+" is "+ob.mul((int)a,(int)b));
                break;
            }
            System.out.println("Multiplication is "+a+" * "+b+" is "+ob.mul(a,b));
            break;
            case '/':
            if(b==0)
            {
                System.out.println("cannot divide by Zero");
                break;
            }
                if(type==1)
                {
                    System.out.println("Division is "+(int)a+" / "+(int)b+" is "+ob.div((int)a,(int)b));
                    break;
                }
                else
                {
                  System.out.println("Division is "+a+" / "+b+" is "+ob.div((int)a,(int)b));
                  break;
                }
                default:
                System.out.println("Invaild operator!");          
          }
            System.out.print("Do you want to continue(yes/no): ");
            String S=h.next();
           if(!"yes".equalsIgnoreCase(S))
            {
              System.out.println("Thanks for using Simple Calculator");
              break;
            } 
        }
    }
}    