package cn.edu.zzu.oj.service.impl;

import cn.edu.zzu.oj.entity.Privilege;
import cn.edu.zzu.oj.mapper.PrivilegeMapper;
import cn.edu.zzu.oj.service.IPrivilegeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuliuyuan
 * @since 2021-05-04
 */
@Service
public class PrivilegeServiceImpl extends ServiceImpl<PrivilegeMapper, Privilege> implements IPrivilegeService {

    @Autowired
    private PrivilegeMapper privilegeMapper;

    @Override
    public Integer getPrivilegeByUserId(String uId) {
        Integer res = 0;
        try {
            Privilege p = privilegeMapper.selectById(uId);
            if(p != null) res = p.getRightstr();
        } catch (Exception e){
            throw e;
        }
        return res;
    }

    @Override
    public Integer deletePrivilegeByUserId(String uId) {
        Integer res = 0;
        try {
            QueryWrapper<Privilege> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("userId", uId);
            res = privilegeMapper.delete(queryWrapper);
        } catch (Exception e){
            throw e;
        }
        return res;
    }

    @Override
    public Integer updatePrivilegeByUserId(String uId, Integer n) {
        Integer res = 0;
        try {
            Privilege p = new Privilege().setUserId(uId).setRightstr(n).setDefunct("N");
            res = privilegeMapper.updateById(p);
        } catch (Exception e){
            throw e;
        }
        return res;
    }

    @Override
    public Integer addPrivilegeByUserId(String uId, Integer privilege) {
        Integer res = 0;
        try {
            Privilege p = new Privilege().setUserId(uId).setRightstr(privilege).setDefunct("N");
            res = privilegeMapper.insert(p);
        } catch (Exception e){
            throw e;
        }
        return res;
    }
}
