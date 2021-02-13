package task1;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class Task1 { 
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException
    {
        Scanner sc = new Scanner(System.in);
         int p,c;
      String x = sc.nextLine();
    List<String> play = new ArrayList<>(Arrays.asList(x.split(" ")));
   
       if(Arrays.stream(play.toArray()).distinct().count()==play.size()) 
       {
if (play.size()%2==0|play.size()<3)
        {
        System.out.println("error");
        }
     
else  
        {
            for(int i = 0; i<play.size(); i++)
            System.out.println(i+1 + " -  " + play.get(i));
            UUID uuid = UUID.randomUUID() ; 
            System.out.println("hmac: "+uuid);
            c=(int)( Math.random() * (play.size()+1 - 1) ) + 1;
            System.out.println("Enter your move:");
            p=sc.nextInt();
            System.out.println("Your move:"+play.get(p-1));
            System.out.println("Pc move:"+ c); 
          if ( Math.abs(p-c)<=(play.size()-1)/2 )
          {
           if(p>c)
           {
            System.out.println("win player");
           }
           else
               if(p<c)
               {
                System.out.println("win PC");
               
               }
               else 
                   if(p==c)
                   {
                    System.out.println("draw");
                   }
          }
          else
          {
          if(p>c)
           {
            System.out.println("win Pc");
           }
           else
               if(p<c)
               {
                System.out.println("win player");
               
               }
               else 
                   if(p==c)
                   {
                    System.out.println("draw");
                   }
          
          }
              
        String key = play.get(p-1);
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        sha256_HMAC.init(new SecretKeySpec(key.getBytes(), "HmacSHA256"));
        byte[] result = sha256_HMAC.doFinal(uuid.toString().getBytes());
        System.out.println ("Hmac key: "+DatatypeConverter.printHexBinary(result));

        } 
       
       }
       else
        System.out.println ("error");
      
    }
    
}
