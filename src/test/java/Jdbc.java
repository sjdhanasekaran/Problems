
import org.apache.log4j.Logger;

public class Jdbc {
    public static Logger systemOut = Logger.getLogger("systemOut");
    public static Logger error = Logger.getLogger("errorLog");
    public static void main(String[] args) throws Exception {
/*        InputStream in = Jdbc.class.getResourceAsStream("/ojdbc6.jar");

        try {
            File dest = new File("ojdbc6.jar");
            Files.copy(in, dest.toPath(), StandardCopyOption.REPLACE_EXISTING);//This one is not Working
        } catch (IOException e) {
            e.getMessage();
        }
        String[] files = new String[]{"/ojdbc6.jar", "/sqljdbc4.jar"};
        String path[] = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            InputStream in2 = Jdbc.class.getResourceAsStream(files[i]);
            try {
                String fileName = files[i].replace("/", "");
                File dest = new File(fileName);
                Files.copy(in2, dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
                path[i] = dest.getAbsolutePath();
                System.out.println(path[i]);
            } catch (IOException e) {
                e.getMessage();
            }
        }
        String url = "jdbc:oracle:thin:@vmchnapi01w:1521:XE";

        String userName = "testuser";
        String password = "testpassword";
        String[] check = new String[]{"D_MASTER", "D_DEFAULT"};
        new External().sqlDataChecker(url, userName, password, check);
        DriverManager.registerDriver(new OracleDriver());
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@vmchnapi01w:1521:XE", "ADMIN", "PASSWORD");
        String SQL = "SELECT COUNT(*) AS count FROM ALL_USERS WHERE USERNAME='TESTUSER'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        while (rs.next()) {
            int count = rs.getInt("count");
            System.out.println(count);
        }
        rs.close();
        stmt.close();
        con.close();*/
new External().getDBData();
    }
}

