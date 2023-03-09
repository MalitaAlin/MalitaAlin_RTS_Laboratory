import java.lang.reflect.Array;

public class App {
    public static void main(String[] args) throws Exception {

       // Exercise 1  
       ComplexNumber nr1 = new ComplexNumber(2, 5);
       ComplexNumber nr2 = new ComplexNumber(4, -1);
        System.out.println("The two complex numbers are: "+nr1.toString() + " and "+nr2.toString());
        System.out.println("The sum of ("+nr1.toString() + ") and ("+ nr2.toString()+") is:\n ("
                +nr1.toString() +") + ("+ nr2.toString()+") = "+nr1.addition(nr2)  );
        System.out.println("The product of ("+nr1.toString() + ") and ("+ nr2.toString()+") is:\n ("
        +nr1.toString() +") * ("+ nr2.toString()+") = "+nr1.multiplication(nr2)  );

        //Exercise 2
        int array1[][]={{2, 3, 1},{7 , 1, 6},{9, 2, 4}};  
        int array2[][]={{8, 5, 3},{3, 9, 2},{2, 7, 3}};  
        int resultarray[][]=new int[3][3];  
        resultarray= arraysum(array1,array2); 
        System.out.println("\n Exercise 2 \n  Sum of arrays is:");
       arrayprint( resultarray);
        resultarray= arrayproduct(array1,array2);
        System.out.println("\n Product of arrays is:");
        arrayprint( resultarray);
    }

  //Exercise 2
    public static int[][] arraysum(int[][] array1,int[][] array2){
        int resultarray[][]=new int[3][3]; 
        for(int i=0;i<3;i++){    
            for(int j=0;j<3;j++){    
            resultarray[i][j]=array1[i][j]+array2[i][j];    //use - for subtraction  
         }    
            }    
        return resultarray; 
    }
    
    public static int[][] arrayproduct(int[][] array1,int[][] array2){
        int resultarray[][]=new int[3][3];  
        for(int i=0;i<3;i++){    
            for(int j=0;j<3;j++){    
            resultarray[i][j]=0;      
              for(int k=0;k<3;k++)      
               {      
               resultarray[i][j]+=array1[i][k]*array2[k][j];      
               }//end of k loop  
            }//end of j loop   
            }    
      return resultarray;
    }

    public static void arrayprint(int[][] array){
        for (int i = 0; i < array.length; i++){
        // Loop through all elements of current row
          for (int j = 0; j < array[i].length; j++)
             {System.out.print(array[i][j] + " "); }
           System.out.print("\n"); }
    }
}
    //Exercise 1
class ComplexNumber{

    private double imagPart;
    private double realPart;
  

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imagPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }
    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImagPart() {
        return imagPart;
    }
    public void setImagPart(double imaginaryPart) {
        this.imagPart = imaginaryPart;
    }

    @Override
    public String toString() {
        if(imagPart >= 0)
       return realPart+" + "+imagPart+"i" ;
        else return  realPart+" "+ imagPart+"i" ; 
    }

    
    public String addition(Object otherNr){
        if( (! ( otherNr instanceof ComplexNumber)) || otherNr ==null  ){
            throw new IllegalArgumentException("Object is null or not an instance of ComplexNumber class.");
             }
            ComplexNumber other = (ComplexNumber) otherNr;
            //this.realPart + other.realPart
            ComplexNumber result = new ComplexNumber(this.realPart+other.realPart, this.imagPart+other.imagPart);
             return  result.toString() ;    
    }

    public String multiplication(Object otherNr){
        if( (! ( otherNr instanceof ComplexNumber)) || otherNr ==null  ){
            throw new IllegalArgumentException("Object is null or not an instance of ComplexNumber class.");
             }
            ComplexNumber other = (ComplexNumber) otherNr;
            ComplexNumber result = new ComplexNumber(this.realPart*other.realPart -this.imagPart*other.imagPart , 
            this.realPart*other.imagPart -this.imagPart*other.realPart);
             return  result.toString() ;    
    }

}

