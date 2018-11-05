package server;

import org.springframework.web.multipart.MultipartFile;

public class filemodel {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
