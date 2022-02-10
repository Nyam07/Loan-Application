
package read_file;

/**
 *
 * @author NYAM
 */
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class Read_file {
    
    
   //Method to get the txt file data into an array
    public static String[] getText(String filepath) throws FileNotFoundException{
        
        File text = new File(filepath);
        Scanner scan = new Scanner(text);
        
        String[] textData = {};
        
        //use a list for easier addition of the data line by line
        List<String> arrlist= new ArrayList<>();
        
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            
            arrlist.add(line);
        }
        textData = arrlist.toArray(new String[arrlist.size()]);
        
        return textData;
        
    }
    
    // Method to calcultae the total monthly payments
    public static double[] getLoanAmount(int score, double amount){
        double[] results = new double[2];
        
        if (score <= 700){
            results[0] = amount * 0.00486;
            results[1] = 4.15;
        }
        else{
            results[0] = amount * 0.00424;
            results[1] = 3.05;
        }
        
        return results;
    }
    
    
    // method to add the data to the text file
    static String[] getTextFile(String name, double amount, double rate, double monthlyPay) throws FileNotFoundException{
        String templateFilepath = "C:\\\\Users\\\\NYAM\\\\Dropbox\\\\My PC (DESKTOP-LP0AS1I)\\\\Downloads\\\\approvalTemplate.txt";
        String []letter = getText(templateFilepath);
       
        int len  = letter.length;
        int i = 0;
        
        while (i < len){
           if (letter[i].contains("NAME")) {
               letter[i] = "Dear " + name + ",";
           }
           else if(letter[i].contains("AMOUNT")){
                letter[i] = "Loan Amount: " + amount;
            }
            else if (letter[i].contains("RATE")){
                letter[i] = "Interest Rate: " + rate;
            }
            else if (letter[i].contains("PAY")){
                letter[i] = "Estimated Monthly Payment: $" + monthlyPay;
            }
           i++;
        }
        
            return letter;
    }
    
    //method to write to txt file
    static void printTxt(String filename, String []arr) throws IOException{
        
        FileWriter writer = new FileWriter(filename);
        
        int len = arr.length;
        
        for (int i=0; i<len; i++){
            writer.write(arr[i] + "\n");
        }
        System.out.println("Success");
        writer.close();
    }
        

    public static void main(String[] args) throws FileNotFoundException, IOException {
       
        // get the data for the first txt file
        String applicantFilepath = "C:\\\\Users\\\\NYAM\\\\Dropbox\\\\My PC (DESKTOP-LP0AS1I)\\\\Downloads\\\\applicants.txt";
        String []data = getText(applicantFilepath);
        
        //loop through the array to collect individual parts of the data
        int index = 1;
        for (String i : data){
            
            
            //split the array according to tab stops
            String splitarray[] = i.split("\t");
            String number = splitarray[0];
            String name = splitarray[1];
            
            String str_amount = splitarray[2];
            double amount = Double.parseDouble(str_amount);
            
            String str_score = splitarray[3];
            int score = Integer.parseInt(str_score);
            
            //call method to calculate total monthly payments
            double [] results = getLoanAmount(score, amount);
            double monthlyPayment = results[0];
            double rate = results[1];
            
            // call method to generate the final letter 
            String []finalLetter = getTextFile(name, amount, rate, monthlyPayment);
            
            //print out the contents of the letter
            for (String j: finalLetter){
                System.out.println(j);
            }
            
            //create the filename for the letter
            String filename = "Letter0"+index+"_" + number + ".txt";
            
            //call method to write the txt file
            printTxt(filename, finalLetter);
            
            index ++;
           
            
        }
        
        
        

            }
    
}
