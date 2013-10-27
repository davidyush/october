import java.util.*;
import java.util.regex.*;

public class JojoLogin{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String login;

		while(true){
			System.out.print("Please Enter the Login: ");
			login = sc.nextLine();
			if(check_login(login)){
				System.out.println("Seccess!\nYour login: " + login);
				
			}
			else{
				System.out.println("Nope!\nTry again!");
			} 
		}

	}

public static boolean check_login(String str){
		Pattern p = Pattern.compile("^([a-zA-Z]{1})" + "([a-zA-Z\\d\\.\\-]+)" + "([a-zA-Z]|\\d)" + "{1,20}$");
		Matcher m = p.matcher(str);
		return m.matches();
	}
}