import java.io.*;
import java.util.*;

public class SomeCmd{
	public static void main(String[] args){

        try{
		SomeCmd someObj = new SomeCmd();
		System.out.println(someObj.runShellScript("cd .."));
        System.out.println(someObj.runShellScript("ls"));//"chmod ugoa+rw a.txt"
		}
		catch(IOException e){ System.out.println(e.getMessage());}
	}

public String runLinuxCommand (String command) throws IOException {
        String resultExecute;
        String returnResult = "No Information : No Information";
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while ((resultExecute = bufferedReader.readLine()) != null) {
            returnResult = resultExecute;
        	}
        	return returnResult;
	}

    public ArrayList<String> runShellScript(String command) throws IOException {
        ArrayList<String> result = new ArrayList<String>();
        String resultExecute = null;
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(new String[]{"/bin/bash", "-c", command});
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while ((resultExecute = bufferedReader.readLine()) != null) {
            result.add(resultExecute);
        }
        return result;
    }
}
