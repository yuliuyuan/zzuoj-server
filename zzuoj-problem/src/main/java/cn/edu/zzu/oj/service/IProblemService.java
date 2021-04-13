package cn.edu.zzu.oj.service;

import cn.edu.zzu.oj.entity.Problem;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuliuyuan
 * @since 2021-04-11
 */
public interface IProblemService extends IService<Problem> {


    public IPage<Problem> getProblemsPage(Page<Problem> page);

    public Integer insertProblems(List<Problem> problemList);
}