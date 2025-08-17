import java.util.*;
class Validate
{
  private  String user_name;
  private String password;
  Validate(String inputuser,String inputpass){
    user_name=inputuser;
    password=inputpass;
  }
  public boolean check(String user,String pass)
  {
    return (this.user_name.equals(user))&&(this.password.equals(pass));
  }
  public String getUser()
  {
    return user_name;

  }
}
class User
{
  public static void main(String sai[])
  {
    Scanner s=new Scanner(System.in);
    Validate[] ob=new Validate[3];
    ob[0]=new Validate("Saiteja","Saiteja@24");
    ob[1]=new Validate("Tharun","Tharun@24");
    ob[2]=new Validate("Sudha", "Sudha@24");
    int i=3;
    Validate currentuser=null;
    while(i>=1)
    {
      System.out.println("enter your user name: ");
      String user=s.nextLine().trim();
      System.out.println("enter your password: ");
      String pass=s.nextLine().trim();
      for(int j=0;j<ob.length;j++)
      {
        if(ob[j].check(user, pass))
        {
            currentuser=ob[j];
            System.out.println("Login sucessfully!");
            System.out.println("Welcome "+currentuser.getUser());
            break;
        }       
      }
      i--;
      if(currentuser!=null)
      {
        break;
      }
      if(i!=0){
        System.out.println("invalid credentials");
        System.out.println("remaining attempts= "+i);
      }
    }  
    if(currentuser==null)
    {
        System.out.println("Too many failed attempts");
    }
  }
}

