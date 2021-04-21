package cn.edu.zzu.oj.converter;

import cn.edu.zzu.oj.entity.News;
import cn.edu.zzu.oj.entity.front.NewFront;
import cn.edu.zzu.oj.entity.front.ProblemFront;
import org.apache.catalina.User;
import org.springframework.beans.factory.parsing.Problem;

import java.util.ArrayList;
import java.util.List;

public class WebEntityToFrontEntity {

    public static List<NewFront> NewsToNewsFront(List<News> news){
        List<NewFront> res = new ArrayList<>();
        for(News v : news){
            NewFront temp = new NewFront().setUserId(v.getUserId())
                    .setDefunct(v.getDefunct())
                    .setImportance(v.getImportance())
                    .setNewsId(v.getNewsId())
                    .setTime(v.getTime())
                    .setTitle(v.getTitle());
            res.add(temp);
        }
        return res;
    }
}
