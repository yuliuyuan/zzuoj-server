package cn.edu.zzu.oj.controller;


import cn.edu.zzu.oj.Exceptions.BaseException;
import cn.edu.zzu.oj.anotation.BaseResponse;
import cn.edu.zzu.oj.converter.WebEntityToFrontEntity;
import cn.edu.zzu.oj.entity.News;
import cn.edu.zzu.oj.entity.front.NewFront;
import cn.edu.zzu.oj.enums.HttpStatus;
import cn.edu.zzu.oj.service.impl.NewsServiceImpl;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuliuyuan
 * @since 2021-03-31
 */

@BaseResponse
@RestController
@RequestMapping("/news")
public class NewsController {
    private static Logger log = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    NewsServiceImpl newsService = null;

    //显示所有的新闻
    @GetMapping("/show")
    public List<NewFront> getAllNews(@RequestParam("pos") Integer pos, @RequestParam("limit") Integer limit){
        return WebEntityToFrontEntity.NewsToNewsFront(newsService.getNews(pos, limit));
    }

    //查询新闻数目
    @GetMapping("/cnt")
    public Integer getNewsCnt(){
        return newsService.getNewsCnt();
    }

    @GetMapping("/get")
    public News getNewById(@RequestParam("id") Integer id){
        return newsService.getNewById(id);
    }
}
