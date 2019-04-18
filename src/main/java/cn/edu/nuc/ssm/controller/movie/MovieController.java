package cn.edu.nuc.ssm.controller.movie;

import cn.edu.nuc.ssm.controller.BaseController;
import cn.edu.nuc.ssm.entity.PageInfo;
import cn.edu.nuc.ssm.entity.movie.Movie;
import cn.edu.nuc.ssm.entity.movie.Pic;
import cn.edu.nuc.ssm.entity.movie.Type;
import cn.edu.nuc.ssm.service.interfaces.movie.MovieService;
import cn.edu.nuc.ssm.service.interfaces.movie.TypeService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/movie")
public class MovieController extends BaseController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private TypeService typeService;
    /**
     * 请求查询角色
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String getAdd(Model model){
        logger.info("to get add");
        List<Type> typeList = typeService.selectAllType();
        model.addAttribute("typeList",typeList);
        return "/movie/add";
    }

    /**
     * 请求查询角色
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String postAdd(Movie movie, MultipartFile file, Model model, HttpSession session) throws IOException {
        logger.info("to get add");
        //使用UUID给图片重命名，并去掉四个“-”
        String name = UUID.randomUUID().toString().replaceAll("-", "");
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
        //把图片存储路径保存到数据库
        String msg = "";
        Pic pic = new Pic();
        pic.setPicid(name);
        pic.setPicurl(upPath);
        movie.setPicid(pic.getPicid());
        int rtn = movieService.insertSelective(movie);
        if(rtn>0){
            msg = "添加功能成功！";
        }else   {
            msg = "添加功能失败！";
        }
        model.addAttribute("msg",msg);
        return "/index";
    }

    @RequestMapping(value="/search",method=RequestMethod.GET)
    public String list(@RequestParam(name="current",defaultValue="1") int current,
                       @RequestParam(name="key",defaultValue="")String key,
                       @RequestParam(name="offset",defaultValue="5")int offset,
                       Model model){
        PageInfo<Movie> moviePageInfo = movieService.selectMovieByKey(current,key,offset);
        model.addAttribute("moviePage", moviePageInfo);
        return "/movie/select";
    }
}
