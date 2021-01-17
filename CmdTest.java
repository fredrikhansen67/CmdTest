import java.io.*;

public class CmdTest {
	
	private void executeCmd(String folder,String cmd) {
		ProcessBuilder builder = new ProcessBuilder(
				"cmd.exe", folder, cmd);
      builder.redirectErrorStream(true);
      Process p;
	try {
		p = builder.start();
		 BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	      String line;
	      while (true) {
	          line = r.readLine();
	          if (line == null) { break; }
	          System.out.println(line);
	      }
	} catch (IOException e) {
		e.printStackTrace();
	}
     
  }
		
	
	
    public static void main(String[] args) throws Exception {
    	CmdTest ct = new CmdTest();
    	ct.executeCmd( "/c", "cd \"C:\\git\" && rmdir /s /q Test");
    	ct.executeCmd( "/c", "cd \"C:\\git\" && dir && git clone git@github.com:fredrikhansen67/Test.git");

    }
}
