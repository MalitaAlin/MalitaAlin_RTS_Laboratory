package Files;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//RebelDot Problem 1 - Java implementation
public class FileHandling {
    
    public static void main(String[] args) throws Exception {
        FileHandler example=new FileHandler();
        
        example.reader.readFile("Example.txt");
        example.writer.writeFile();
        example.clone.cloneFile("Example.txt");
    }

}


 class FileHandler{
   private FileReader in;
    private FileWriter out;
    Reader reader;
    Cloning clone;
     Writer writer;
    
   public FileHandler(){
    this.in = null;
    this.out = null;
    reader.in=this.in;
    writer.out=this.out;
    clone.in=this.in;
    clone.out=this.out;


   }
}

class Reader{
   FileReader in;
public void readFile(String fileName) throws IOException{

   try {
       in = new FileReader(fileName);
       
       
       int c;
       while ((c = in.read()) != -1) {
          System.out.println(c);
       }
    }finally {
       if (in != null) {
          in.close();
       }
       
    }
 }
}
  
 class Cloning{
   FileReader in;
   FileWriter out;


 public File cloneFile(String fileName) throws IOException{
  
  int index = fileName.lastIndexOf('.');
   if(index > 0) {
     String extension = fileName.substring(index + 1); 
    
  try (Scanner input = new Scanner(System.in)) {
     System.out.println("\nEnter name for the copy file: ");
     String newFileName =  input.toString();
       File newFile = new File(newFileName +"."+extension);

       try{
        if (newFile.createNewFile()) {
        System.out.println("File created: " + newFile.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 


       try {
        in = new FileReader(fileName);
        out = new FileWriter(newFile);
           
           int c;
           while ((c = in.read()) != -1) {
              out.write(c);
           }
        }finally {
           if (in != null) {
              in.close();
           }
           if (out != null) {
              out.close();
           }
        }
      return newFile;
  }
 }
 else {  System.out.println("FIle extension could not be identified.");
 return null; }
}

}


class Writer{
   FileWriter out;
public File writeFile(){
  Scanner input = new Scanner(System.in);
     System.out.println("\nEnter name for the copy file: ");
     String newFileName =  input.toString(); 

      Scanner input1= new Scanner(System.in);
        System.out.println("\nEnter file exxtension: ");
        String extension =  input1.toString();

       File newFile = new File(newFileName +"."+extension);

       try{
        if (newFile.createNewFile()) {
        System.out.println("File created: " + newFile.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 


       try {
       out = new FileWriter(newFile);
       Scanner input2= new Scanner(System.in);
       System.out.println("\nEnter String into: "); //writing loop could be added.
       String example =  input2.toString();
        out.write(example);
        out.close();
        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }

   return newFile;
 }
}