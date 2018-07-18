/*
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.mkyong.core.utils</groupId>
	<artifactId>dateUtils</artifactId>
	<packaging>jar</packaging>
	<version>1.0-SNAPSHOT</version>
	<name>dateUtils</name>
	<url>http://maven.apache.org</url>

	<properties>
		<jdk.version>1.7</jdk.version>
		<jodatime.version>2.5</jodatime.version>
		<junit.version>4.11</junit.version>
		<log4j.version>1.2.17</log4j.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>com.googlecode.json-simple</groupId>
			<artifactId>json-simple</artifactId>
			<version>1.1.1</version>
		</dependency>
	</dependencies>

	<build>
		<finalName>dateutils</finalName>
		<plugins>
			<!-- Set a compiler level -->
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<configuration>
					<source>${jdk.version}</source>
					<target>${jdk.version}</target>
				</configuration>
			</plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <configuration>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <mainClass>Jdbc</mainClass>
                        </manifest>
                        <manifestEntries>
                            <Class-Path>ojdbc6.jar sqljdbc4.jar</Class-Path>
                        </manifestEntries>
                    </archive>
                </configuration>
            </plugin>


            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-assembly-plugin</artifactId>
                <configuration>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <mainClass>Jdbc</mainClass>
                        </manifest>
                    </archive>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                </configuration>
                <executions>
                    <execution>
                        <id>make-my-jar-with-dependencies</id>
                        <phase>package</phase>
                        <goals>
                            <goal>single</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>







			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-jar-plugin</artifactId>
				<configuration>
					<archive>
						<manifest>
							<addClasspath>true</addClasspath>
							<mainClass>com.mkyong.core.utils.Jdbc</mainClass>
						</manifest>
						<manifestEntries>
							<Class-Path>resources/lib/</Class-Path>
						</manifestEntries>
					</archive>
				</configuration>
			</plugin>

			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-dependency-plugin</artifactId>
				<executions>
					<execution>
						<id>copy-dependencies</id>
						<phase>package</phase>
						<goals>
							<goal>copy-dependencies</goal>
						</goals>
						<configuration>
							<includeScope>runtime</includeScope>
							<outputDirectory>${project.build.directory}/dependency-jars/</outputDirectory>
						</configuration>
					</execution>
				</executions>
			</plugin>

		</plugins>
	</build>

</project>*/
/*package com.softwareag.cluster;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import oracle.jdbc.driver.OracleDriver;

import org.json.simple.JSONArray;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

public class External{
    private String externalDB, installationType, serverPath, accPort,dbnode,jarPath;
    public JSONArray dbArray=new JSONArray();
    private static final Logger systemOut = Logger.getLogger("systemOut");
    private static final Logger error = Logger.getLogger("errorLog");
    public void getDBData() {
        String temp;
        Scanner inputScanner = new Scanner(System.in);
        if(UserInterface.getInstance().setExternalDB) {
            installationType= JsonReader.getInstance().getInstallationType();
            serverPath = UserInterface.getInstance().serverPath;
            accPort=JsonReader.getInstance().getAccPort();
            System.out.println();

            IntStream.range(0, JsonReader.getInstance().getNodes().size())
                    .mapToObj(i -> "n" + String.valueOf(i + 1) + " \t \t " + JsonReader.getInstance().getNodes().get(i).getIp()).forEach(System.out::println);
            System.out.println();

            System.out.print("Node to configure Database : ");
            dbnode=inputScanner.nextLine();
            System.out.println();
        }else{
        System.out.println();
        System.out.print("Installation Type : [ s ] ? ");
        temp =inputScanner.nextLine();
        installationType = temp.isEmpty() ? "s" : temp;
        System.out.println();

      String dir = /*UserInterface.getInstance().isWindows() ? "C:\\SoftwareAG\\API_Portal\\server\\"/* : "/opt/softwareag/API_Portal/server/";
/*        System.out.print("Server Path : [ "+dir+" ] ? ");
        temp = inputScanner.nextLine();
        serverPath = temp.isEmpty() ? dir : temp;
        System.out.println();

        System.out.print("Acc Port : ");
        accPort = inputScanner.nextLine();

        dbnode = "localhost";
        System.out.println();
        *//*}*//*
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

        if(externalDB.equals("oracle")){
            jarPath =path[0];
        }else if(externalDB.equals("mssql")){
            jarPath =path[1];
        }

        System.out.println();
       *//* if(UserInterface.getInstance().setExternalDB) {
            System.out.println("Node To Configure " + externalDB + " database : " + dbnode);
        }*//*
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
        System.out.print("Setup com.softwareag.cluster.External DB with  Above Information [ Y / N ] : [ N ] ? ");
        temp = inputScanner.nextLine();
        String confirm=temp.isEmpty()?"N" : temp;*/
       /* if (confirm.equals("Y")||(confirm.equals("y"))) {
            if (UserInterface.getInstance().setExternalDB) {
                String localJarPath= jarPath.replace("\\", "\\\\");
                JSONObject dbObj = new JSONObject();
                dbObj.put("appUsername", appUsername);
                dbObj.put("appPassword", appPassword);
                dbObj.put("masterSchema", masterSchema);
                dbObj.put("defaultSchema", defaultSchema);
                dbObj.put("jarPath",localJarPath);
                if (externalDB.equals("oracle")) {
                    dbObj.put("dbUsername", dbUsername);
                    dbObj.put("dbPassword", dbPassword);
                }
                dbArray.add(dbObj);
            } else {
                setDB(url,appUsername, appPassword, masterSchema, defaultSchema,dbUsername, dbPassword,jarPath);
            }
        }
        for (String sPath:path) {
            try {
                Files.deleteIfExists(Paths.get(sPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*public void setDB(String url,String appUsername,String appPassword,String masterSchema,
                      String defaultSchema,String dbUsername, String dbPassword,String jarPath) {


        ArrayList<String> command = new ArrayList<>();
        command.add("add node n1 "+dbnode+" @" + accPort + " Clous g3h31m");
        command.add("set current node n1");
        ClusterHelper.getInstance().nodeListWriter(serverPath, command);
        command.clear();


        Process runnable = Executor.getInstance().executor(serverPath, "list", true);
        Scanner runableList = new Scanner(runnable.getInputStream());
        ArrayList<String> nodeDetails = new ArrayList<>();
        while (runableList.hasNextLine()) {
            String line1 = runableList.nextLine();
            if (line1.contains("com.aris")) {
                String[] ss = line1.split("\\s+");
                nodeDetails.add(ss[0]);
            }
        }

        for (String nodeDetail1 : nodeDetails) {
            if (nodeDetail1.contains("postgres")) {
                System.out.print("\rDeconfiguring Postgres");
                command.add("stop postgres_" + installationType);
                command.add("wait for STOPPED of postgres_" + installationType);
                command.add("force deconfigure postgres_" + installationType);
            }else if(nodeDetail1.contains("cloudsearch")){
                command.add("stop cloudsearch_" + installationType);
                command.add("wait for STOPPED of cloudsearch_" + installationType);
            }
        }
        command.add("stop apiportalbundle_" + installationType);
        command.add("wait for STOPPED of apiportalbundle_" + installationType);
        System.out.print("\rStoping Runnables ");
        Executor.getInstance().executor(serverPath, command);
        command.clear();

        String serverName;
        if(externalDB.equals("oracle")) {
            int a = url.indexOf("@")+1;
            int c = url.substring(a).indexOf(":");
            serverName=url.substring(a,a+c);
        }else {
            int a=  url.lastIndexOf("/")+1;
            int c=  url.substring(a).indexOf(":");
            serverName=url.substring(a,a+c);
        }
        Map<String, String> regMap = new HashMap<>();
        regMap.put("url",url);
        regMap.put("serverName",serverName);
        regMap.put("appUsername", appUsername);
        regMap.put("appPassword", appPassword);
        String cmd;
        if (externalDB.equals("oracle")) {
            regMap.put("dbUsername", dbUsername);

            regMap.put("dbPassword", dbPassword);

            cmd = ClusterHelper.getInstance().templateReader("oracle.tp", regMap);
        } else {

            cmd = ClusterHelper.getInstance().templateReader("sql.tp", regMap);
        }
        command.add(cmd);

        System.out.print("\rRegistering com.softwareag.cluster.External service.");
        Process registerProcess = Executor.getInstance().executor(serverPath, command, true);
        command.clear();
        Scanner idScanner = new Scanner(registerProcess.getInputStream());
        String serviceId = "";
        while (idScanner.hasNextLine()) {
            String s = idScanner.nextLine();
            systemOut.info(s);
            if (s.contains("serviceId")) {

                serviceId = s.substring(s.indexOf("Id") + 3, s.length() - 1);
            }
        }


        command.add("assign tenant master to service " + serviceId + " com.aris.cip.db.schema=" + masterSchema);
        command.add("assign tenant default to service " + serviceId + " com.aris.cip.db.schema=" + defaultSchema);
        System.out.print("\rAssigning Schemas to tenant...");
        Executor.getInstance().executor(serverPath, command);
        command.clear();

        if(externalDB.equals("oracle")) {
            String temp= jarPath.replace("\\", "\\\\");
            command.add("enhance apiportalbundle_" + installationType + " with commonsClasspath local file \""+temp+"\"");
        }else{
            String temp= jarPath.replace("\\", "\\\\");
            command.add("enhance apiportalbundle_" + installationType + " with commonsClasspath local file \""+temp+"\"");
        }

        System.out.print("\rEnhancing apiportalbundle...");
        Executor.getInstance().executor(serverPath, command);
        command.clear();

        command.add("start apiportalbundle_"+installationType);
        command.add("start cloudsearch_"+installationType);
        System.out.print("\rStarting runnables");
        Executor.getInstance().executor(serverPath,command);
    }
*/
  /*  public void sqlDataChecker(String url,String userName,String password,String[] check){

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
}*/