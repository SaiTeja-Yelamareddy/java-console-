import java.util.*;
class User
{
    private  String cardno;
    private  String pin;
    private  static int balance;
    User(String no,String pass,int money)
    {
      cardno=no;
      pin=pass;
      balance=money;
    }
    public boolean authentication(String inputcard,String inputpin)
    {
      return cardno.equals(inputcard)&&pin.equals(inputpin);
    }
    public static Boolean authenticationAmount(String t)
    {
    // Check if string contains only digits
      for (int i = 0; i < t.length(); i++) {
        if (!Character.isDigit(t.charAt(i))) {
            return false;
        }
      }
      return true;
    }

    public void balanceCheck()
    {
       System.out.println("Current balance = ₹" + balance);
    }
    public  static void withdraw(String a)
    {
      if(User.authenticationAmount(a))
      {
        int b=Integer.parseInt(a);
        if((b>=0)&&(b<=balance))
        {
          balance-=b;
          System.out.println("₹" +b+ " withdrawn sucessfully.");
        }
        else
        {
          System.out.println("insufficent balanace! please check!");
          System.exit(0);
        }

      }
      else{
        System.out.println("invald withdraw amount");
        System.exit(0);
      } 
    }
    public static void deposit(String a)
    { 
       if(User.authenticationAmount(a))
       {
         int b=Integer.parseInt(a);
         if(b>=0)
         {
          balance+=b;
          System.out.println("₹"+b+"Deposit sucessfully!");
         }
         else
          {
           System.out.println("invald deposit amount");
           System.exit(0);
          }
        }
      else{
        System.out.println("invald deposit amount");
        System.exit(0);
      }
    }       
}
class Atm
{
  public static void main(String sai[])
     {
       Scanner s= new Scanner(System.in);
        System.out.println("enter your card number: ");
        String cardno=s.next();
        System.out.println("enter your pin: ");
        String pin=s.next();
        User[] ob1=new User[9];
        ob1[0]=new User("486486486","1504",459722);
        ob1[1]=new User("789789789","1504",78900);
        ob1[2]=new User("456456456","1504",56789);
        ob1[3]=new User("123123123","1504",6754478);
        ob1[4]=new User("741741741","1504",5642345);
        ob1[5]=new User("852852852","1504",345789);
        ob1[6]=new User("963963963","1504",3456789);
        ob1[7]=new User("159159159","1504",4568327);
        ob1[8]=new User("753753753","1504",56442);
        User currentuser=null;
        for(int i=0;i<ob1.length;i++)
        {
          if(ob1[i].authentication(cardno,pin))
          {
            currentuser=ob1[i];
            break;
          }
        }
        if(currentuser==null)
        {
           System.err.println("Invaid card number or PIN. Try again!");
            System.exit(0);

        }
        while(true)
        {
           System.out.println("1.check balance ");
           System.out.println("2.withdraw ");
           System.out.println("3.Deposit ");
           System.out.println("4.exit ");
           int c=s.nextInt();
           switch(c)
           {
             case 1:
             currentuser.balanceCheck();
             break;
             case 2:
             System.out.println("enter your withdrawl amount: ");
              String d=s.next();
              currentuser.withdraw(d);
              break;
              case 3:
              System.out.println("enter your deposit amount:");
              String e=s.next();
              currentuser.deposit(e);
              currentuser.balanceCheck();
              break;
              case 4:
              System.out.println("Thankyou visit again!");
              System.exit(0);
            }
        }
      }
}