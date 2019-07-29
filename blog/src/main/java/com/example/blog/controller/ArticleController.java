package com.example.blog.controller;

import com.example.blog.po.Article;
import com.example.blog.service.ArticleService;
import com.example.blog.util.CreateIdUtil;
import com.example.blog.util.ResultList;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.File;

@RestController
@RequestMapping("/Article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/first")
    public PageInfo<Article> firstArticle(){
        return articleService.firstArticle();
    }

    @RequestMapping("/article")
    public PageInfo<Article> queryArticle(@RequestParam("page")Integer page){
        return articleService.queryArticle(page);
    }
    @RequestMapping("/queryById")
    public Article queryArticlebyId(@RequestParam("id") String id){
        return  articleService.queryArticlebyId(id);
    }

    @RequestMapping("/add")
    public ResultList addArticle(@RequestParam("file")MultipartFile file,Article article){
        //1. 接受上传的文件  @RequestParam("file") MultipartFile file
        ResultList resultList=new ResultList();
        if (!file.isEmpty()) {
            try {


                File path=new File("C:\\Users\\贾增起\\Documents\\HBuilderProjects\\blog\\img\\");
                if (!path.exists()){
                    path.mkdirs();
                }
                String name=CreateIdUtil.getId()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));


                BufferedInputStream  in = new BufferedInputStream(file.getInputStream());
                BufferedImage prevImage = ImageIO.read(file.getInputStream());
                double width = prevImage.getWidth();
                double height = prevImage.getHeight();
                double percent = 1024/width;
                int newWidth = (int)(width * percent);
                int newHeight = (int)(height * percent);
                //字节流转图片对象
                Image bi = ImageIO.read(in);
                //构建图片流
                BufferedImage tag = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
                //绘制改变尺寸后的图
                tag.getGraphics().drawImage(bi, 0, 0, newWidth, newHeight, null);
                //输出流
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("C:\\Users\\贾增起\\Documents\\HBuilderProjects\\blog\\img\\"+name));//保存图片到目录下
                //JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
                //encoder.encode(tag);
                ImageIO.write(tag, "JPG", out);
                in.close();
                out.write(file.getBytes());
                out.flush();
                out.close();

                article.setImage(name);
                resultList=articleService.addArticle(article);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                resultList.setMsg("上传失败");

            } catch (IOException e) {
                e.printStackTrace();
                resultList.setMsg("上传失败");

            }

        } else {
            resultList.setMsg("文件为空");

        }
        return resultList;

    }
}
