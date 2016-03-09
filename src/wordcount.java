import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class wordcount {

    public static void main(String[] args) throws IOException {
        String word = "";
        int val = 0;
        while (!word.matches("quit")) {
            Scanner Sc = new Scanner(new File("/Users/hemanth/Documents/Cloudwick/pg2600.txt"));
            int k = 0;
            StringArray arrayofwords = new StringArray();
            while (Sc.hasNext()) {
                arrayofwords.add(Sc.next());
                k++;
            }

           // String [] arraynodublicates = {"the", "and", "of", "to"};;
           //removing the duplicates
            StringArray arraynodublicates = new StringArray();
            int k1=0;
            int count3 = 0;
            for (int i = 0; i < arrayofwords.getSize(); i++)
            {
                word =arrayofwords.get(i);
                //Pattern p1= Pattern.compile("\\b" + word +"\\b",Pattern.CASE_INSENSITIVE);
                String strings= "";
                for (int j=0;j < arraynodublicates.getSize();j++) {
                    strings =arraynodublicates.get(j);
                   // Matcher matcher = p1.matcher(strings);
                    if(strings.equals(word))
                    { count3++;}
                }
                if(count3>1){ }
                else{
                    arraynodublicates.add(arrayofwords.get(i));
                    k1++;
                    //System.out.println("array  "+arrayofwords.get(i));
                }
                count3 = 0;
            }

            System.out.println("Size of original array  "+arrayofwords.getSize());
            System.out.println("Size of new array  "+arraynodublicates.getSize());
            

         //calculating the frequency

            for(int i=0; i<arraynodublicates.getSize();i++)
            {
                word =arraynodublicates.get(i);
                Pattern p= Pattern.compile("\\b" + word +"\\b",Pattern.CASE_INSENSITIVE);
                int count = 0;
                String s= "";

                for(int j=0; j<arrayofwords.getSize(); j++)
                {
                    s =arrayofwords.get(j);
                    Matcher matcher = p.matcher(s);
                    if(matcher.find())
                    { count++;}
                }
                System.out.println("word is '" +word+ "' no of countmatch pattern   " + count);
            }

            System.out.println("-------continue or quit--- enter continue or quit");
            word = "quit";

        }
    }
}