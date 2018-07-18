import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import oracle.jdbc.driver.OracleDriver;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.util.*;

public class External {
    private String externalDB;
    public void getDBData() {
        String temp;
        Scanner inputScanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Installation Type : [ s ] ? ");
        temp =inputScanner.nextLine();
        String installationType = temp.isEmpty() ? "s" : temp;
        System.out.println();

        String dir = "C:\\SoftwareAG\\API_Portal\\server\\";
        System.out.print("Server Path : [ "+dir+" ] ? ");
        temp = inputScanner.nextLine();
        String serverPath = temp.isEmpty() ? dir : temp;
        System.out.println();

        System.out.print("Acc Port : ");
        String accPort = inputScanner.nextLine();

        String dbnode = "localhost";
        System.out.println();
        System.out.print("DataBase Server type : [ oracle / MS-SQL ] ? ");
        externalDB = inputScanner.nextLine();
        System.out.println();

        System.out.print("App Username : ");
        String appUsername = inputScanner.nextLine();
        System.out.println();

        System.out.print("App PassWord : ");
        String appPassword = inputScanner.nextLine();
        System.out.println();

        System.out.print("Master Schema Name : ");
        String masterSchema = inputScanner.nextLine();
        System.out.println();

        System.out.print("Default Schema Name : ");
        String defaultSchema = inputScanner.nextLine();
        System.out.println();

        if(externalDB.equals("oracle")) {
            System.out.println("# Example -> jdbc:oracle:thin:@hostName:portName:serviceName");
            // jdbc:oracle:thin:@vmchnapi01w:1521:XE
        }else if(externalDB.equals("MS-SQL")) {
            System.out.println("# Example -> jdbc:sqlserver://serverName:port;DatabaseName=dbname");
            // jdbc:sqlserver://vmchnapi01w:1433;DatabaseName=dbdje
        }
        System.out.println();
        System.out.print("Database URL : ");
        String url=inputScanner.nextLine();
        System.out.println();

        String dbUsername = null, dbPassword = null;
        if (externalDB.equalsIgnoreCase("oracle")) {

            System.out.print("Database Admin Username : ");
            dbUsername = inputScanner.nextLine();
            System.out.println();

            System.out.print("Database Admin Password : ");
            dbPassword = inputScanner.nextLine();
            System.out.println();
        }
        String[] check=new String[]{masterSchema,defaultSchema};

        String[] files = new String[]{"/ojdbc6.jar", "/sqljdbc4.jar"};
        String path[] = new String[files.length];

        for (int i = 0; i < files.length; i++) {

            InputStream in = getClass().getResourceAsStream(files[i]);
            try {
                String fileName=files[i].replace("/","");
                File dest = new File(fileName);
                Files.copy(in, dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
                path[i] = dest.getAbsolutePath();
            } catch (IOException e) {
                e.getMessage();
            }
        }
        sqlDataChecker(url,appUsername,appPassword,check);

        String jarPath;
        if(externalDB.equals("oracle")){
            jarPath =path[0];
        }else if(externalDB.equals("mssql")){
            jarPath =path[1];
        }

        System.out.println();

        System.out.println("JDBC url : " +url);
        System.out.println("appUsername : " + appUsername);
        System.out.println("appPassword : " + appPassword);
        System.out.println("masterSchema : " + masterSchema);
        System.out.println("defaultSchema : " + defaultSchema);
        if (externalDB.equals("oracle")) {
            System.out.println("dbUsername : " + dbUsername);
            System.out.println("dbPassword : " + dbPassword);
        }

        System.out.println();
        System.out.print("Setup External DB with  Above Information [ Y / N ] : [ N ] ? ");
        temp = inputScanner.nextLine();
        String confirm=temp.isEmpty()?"N" : temp;
        for (String sPath:path) {
            try {
                Files.deleteIfExists(Paths.get(sPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sqlDataChecker(String url,String userName,String password,String[] check){

        System.out.println("Validating the datas you entered ... ");
        try {
            if(externalDB.equals("oracle")){
                DriverManager.registerDriver(new OracleDriver());
            }else {
                DriverManager.registerDriver(new SQLServerDriver());
            }
            Connection con = DriverManager.getConnection(url, userName, password);
            String SQL = null;
            Integer[] count = new Integer[check.length];
            Statement stmt = null;
            ResultSet rs = null;
            for (int i = 0; i < check.length; i++) {
                if (externalDB.equals("oracle")) {
                    SQL = "SELECT COUNT(*) AS count FROM ALL_USERS WHERE USERNAME='" + check[i] + "'";
                } else if (externalDB.equals("mssql")) {
                    SQL = "SELECT COUNT(*) AS count FROM sys.schemas WHERE name='"+check[i]+"'";
                }
                stmt = con.createStatement();
                rs = stmt.executeQuery(SQL);
                while (rs.next()) {
                    count[i] = rs.getInt("count");
                }
                System.out.println(Arrays.toString(count));
                if(count[i]<=0){
                    System.out.println("Problem with your entered Data" + check[i] + ". Please Provide valid data");
                }
            }
            Arrays.stream(count).filter(c -> c <= 0).forEach(c -> {
                System.out.println("Exiting From Relational Database Setup ...");
                System.exit(1);
            });
            assert rs != null;
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            String message = ex.getLocalizedMessage();
            if (message.contains("connection")) {
                System.out.println("Could No connect to you Database . Please verify the Port or server is accesible");
            } else if (message.contains("denied")||message.contains("failed")) {
                System.out.println("Enter Correct username and password");
                System.exit(1);
            }
        }
    }
}