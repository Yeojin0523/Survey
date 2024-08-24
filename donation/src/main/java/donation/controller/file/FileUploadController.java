// 파일 업로드 관련
package donation.controller.file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;

@Controller
public class FileUploadController {

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("title") String title) {
        try {
            String filename = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(0)) + "-" + file.getOriginalFilename();
            Path path = Paths.get("C:/upload-dir/" + filename);
            Files.write(path, file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/main";
    }
}
