import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
class StudentManagementSystem{
    private String name,roll,branch;
    StudentManagementSystem(String n,String r,String b)
    {
        name=n;
        roll=r;
        branch=b;
    }
    public static boolean check(String rollnum)throws IOException{
      File f=new File("D:\\flies java text\\student.txt");
      if(!f.exists())
      {
        f.createNewFile();
      }
      Scanner h=new Scanner(f);
      while(h.hasNextLine())
      {
        String text=h.nextLine();
        if(text.contains(rollnum))
        {
          h.close();
          return false;
        }
      }
      h.close();
      return true;
    }
    public void add(String ro)throws IOException{
      File f=new File("D:\\flies java text\\student.txt");
      if(!f.exists())
      {
        f.createNewFile();
      }
      if(check(ro))
      {
        BufferedWriter bw=new BufferedWriter(new FileWriter(f,true));
        bw.write("NAME: "+name+" <==> ROLL NUMBER: "+roll+" Branch: "+branch);
        bw.newLine();
        bw.flush();
        bw.close();
      }
      else
      {
        System.out.println("studnet already present!");
        return;
      }
    }
    public static void view()throws IOException{
      File f=new File("D:\\flies java text\\student.txt");
     if(!f.exists())
     {
      System.out.println("file not existing...!");
      return;
     }
     FileReader fr=new FileReader(f);
     Scanner sr=new Scanner(fr);
     String text="";
     while((sr.hasNextLine()))
     {
      text+=sr.nextLine()+"\n";
    }
    if(text.isEmpty())
    {
      System.out.print("no records!");
    }
    else
    {
       System.out.println(text);
       sr.close();
       fr.close();
    }
 }
 public static boolean details(String r)throws IOException
 {
   File f=new File("D:\\flies java text\\student.txt");
   if(!f.exists())
    {
      System.out.println("file not existing...!");
      return false;
    }
    Scanner sa=new Scanner(f);
    while(sa.hasNextLine())
    {
      String si=sa.nextLine();
      if(si.contains(r))
      {
        System.out.println(si);
        sa.close();
        return true;
      }
    }
    sa.close();
    return false;
    
  } 
  public  static void update(String r,Scanner h)throws IOException
  {
     File f=new File("D:\\flies java text\\student.txt");
   if(!f.exists())
    {
      System.out.println("file not existing...!");
      return;
    }
    else{
      Scanner sa=new Scanner(f);
      boolean found=false;
      String text="";
      while(sa.hasNextLine())
      {
        String details=sa.nextLine();
        if(details.contains(r))
        {
          System.out.println("enter name of the student: ");
          String name=h.nextLine();
          System.out.println("enter the roll number");
          String branch=h.nextLine();
          text+="NAME: "+name+" <==> ROLL NUMBER: "+r+" Branch: "+branch+"\n";
          found=true;
        }
        else{
          text+=details+"\n";
        }
      }
      if(!found)
      {
        System.out.println("student not exits");
        h.close();
        sa.close();
        return;
      }
      BufferedWriter bw=new BufferedWriter(new FileWriter(f,false));
      bw.write(text);
      bw.close();
      sa.close();

    }

  }
    public  static void delete(String r)throws IOException
  {
     File f=new File("D:\\flies java text\\student.txt");
   if(!f.exists())
    {
      System.out.println("file not existing...!");
      return;
    }
    else{
      Scanner sa=new Scanner(f);
      boolean found=false;
      String text="";
      while(sa.hasNextLine())
      {
        String details=sa.nextLine();
        if(details.contains(r))
        {
          found=true;
          continue;
        }
        else{
          text+=details+"\n";
        }
      }
      if(!found)
      {
        System.out.println("student not exits");
        sa.close();
        return;
      }
      BufferedWriter bw=new BufferedWriter(new FileWriter(f,false));
      bw.write(text);
      bw.close();
      sa.close();

    }

  }
}
//************************************************************************************************************** */
class Student
{
  public static void main(String args[]) throws IOException
 {
    Scanner sc=new Scanner(System.in);
    int i=1;
    while(i!=0)
    {
      System.out.println("<<<<<<<MENU>>>>>>>>>>>>");
      System.out.println("1.ADD STUDENT DETAILS");
      System.out.println("2.VIEW STUDENT DETAILS");
      System.out.println("3.SEARCH STUDENT DETAILS");
      System.out.println("4.UPDATE STUDENT DETAILS");
      System.out.println("5.DELETE STUDENT");
      System.out.println("6.EXIT");
      System.out.print("Enter your option:");
      int opt=sc.nextInt();
      sc.nextLine();
      switch (opt) {
        case 1:
        System.out.println("Enter student name:");
        String name=sc.nextLine();
        System.out.println("Enter ROLL NUMBER: ");
        String Roll=sc.nextLine();
        System.out.println("Enter branch NUMBER: ");
        String branch=sc.nextLine();
        StudentManagementSystem ob=new StudentManagementSystem(name,Roll,branch);
        ob.add(Roll);
        break;
        case 2:
        StudentManagementSystem.view();
        break;
        case 3:
        System.out.println("enter student roll number to find details: ");
        String roll=sc.nextLine();
        Boolean found=StudentManagementSystem.details(roll);
        if(!found)
        {
          System.out.println("student not found!");
        }
        break;
        case 4:
        System.out.println("enter the student roll number: ");
        String r=sc.nextLine();
        StudentManagementSystem.update(r,sc);
        break;
        case 5:
        System.out.println("enter the student roll number: ");
        String ro=sc.nextLine();
        StudentManagementSystem.delete(ro);
        break;
        case 6:
        System.out.println("thank you for using Student Management System!..");
        i=0;
        break;
        default:
        System.out.println("Invalid option please try again!..");
            break;
      }
    } 
    sc.close(); 
 }
}  