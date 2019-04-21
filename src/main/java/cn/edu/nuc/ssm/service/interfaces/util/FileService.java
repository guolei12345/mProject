package cn.edu.nuc.ssm.service.interfaces.util;

import cn.edu.nuc.ssm.entity.movie.Pic;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    Pic fileUpload(MultipartFile file) throws IOException;
}
