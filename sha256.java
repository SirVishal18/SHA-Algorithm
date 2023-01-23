import java.util.Scanner;
import java.security.MessageDigest;
public class sha256{
    public static String getsha256hash(String data) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++){
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String: ");
        String input=sc.nextLine();
        String hash=getsha256hash(input);
        System.out.println("Hash Value: ");
        System.out.println(hash); 
    }
}
