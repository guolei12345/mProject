package cn.edu.nuc.ssm.service.impl.util;

import cn.edu.nuc.ssm.entity.movie.Pic;
import cn.edu.nuc.ssm.service.interfaces.util.FileService;
import cn.edu.nuc.ssm.util.StringUtil;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public Pic fileUpload(MultipartFile file) throws IOException {
        Pic pic = new Pic();

        //使用UUID给图片重命名，并去掉四个“-”
        String name = StringUtil.getUUId().replaceAll("-", "");
        //获取文件的扩展名
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        //设置图片上传路径
        String url = this.getClass().getClassLoader().getResource("/").getPath();
        String path = url+"upload";
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdirs();
        }
        String upPath = path+"/"+name + "." + ext;
        //以绝对路径保存重名命后的图片
        file.transferTo(new File(upPath));
        pic.setPicid(name);
        pic.setPicurl(upPath);
        return pic;
    }
}
