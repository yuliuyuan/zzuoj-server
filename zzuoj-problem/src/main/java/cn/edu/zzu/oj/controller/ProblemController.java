package cn.edu.zzu.oj.controller;


import cn.edu.zzu.oj.Exceptions.BaseException;
import cn.edu.zzu.oj.Exceptions.ExceptionHandlerAdvice;
import cn.edu.zzu.oj.anotation.BaseResponse;
import cn.edu.zzu.oj.converter.WebEntityToFrontEntity;
import cn.edu.zzu.oj.entity.Problem;
import cn.edu.zzu.oj.entity.front.ProblemFront;
import cn.edu.zzu.oj.enums.HttpStatus;
import cn.edu.zzu.oj.service.impl.ProblemServiceImpl;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.log4j.Log4j2;
import org.omg.PortableInterceptor.INACTIVE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sun.tools.jconsole.JConsole;

import java.time.LocalDateTime;
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
 * @since 2021-04-11
 */

@BaseResponse
@RestController
@RequestMapping("/problem")
public class ProblemController {
    private static Logger log = LoggerFactory.getLogger(ProblemController.class);

    @Autowired
    ProblemServiceImpl problemService;

    //pos表示的是相对于第一条记录的偏移，数据库中第一条记录pos为0，
    @GetMapping("/show")
    public List<ProblemFront> show(@RequestParam("pos") Integer pos, @RequestParam("limit") Integer limit){
        List<Problem> list = null;
        try {
            list = problemService.getProblemsPage(pos, limit);
        } catch (Exception e){
            log.error("show problems list error: " + e.toString());
            return null;
        }
        return WebEntityToFrontEntity.ProblemToProblemFront(list);
    }

    @GetMapping("/cnt")
    public Integer getProblems(){
        return problemService.getProblemCnt();
    }


    @GetMapping("/get")
    public Problem getProblemById(@RequestParam("problemId") Integer problemId) {
        Problem problem = null;
        try {
            problem = problemService.getProblemById(problemId);
        } catch (Exception e){
            return null;
        }
        return problem;
    }
}
