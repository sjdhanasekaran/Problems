import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class InterActiveApp {
    public static void main(String[] args) throws Exception {
        File sourceFolder = new File("src/main/resources/lib");
        File files[] = sourceFolder.listFiles();
        assert files != null;
        for(File file : files) {
            File target=new File(file.getName());
            Files.copy(file.toPath(),
                   target.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
            /*target.deleteOnExit();*/
        }
    }
}
