package terst1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hw4_2 {

    public static void main(String[] args) {
        Path filePath = Path.of("C:\\Users\\Ryan\\Downloads\\demo.txt"); // 根据实际路径修改

        try {
            String content = Files.readString(filePath);
           
            Pattern pattern = Pattern.compile("01AF0055/\\S+\\.jpg\\?HRV\\.bpp");
            Matcher matcher = pattern.matcher(content);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
