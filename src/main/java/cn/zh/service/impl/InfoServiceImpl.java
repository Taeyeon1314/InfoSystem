package cn.zh.service.impl;


import cn.zh.dao.InfoDao;
import cn.zh.pojo.Info;
import cn.zh.service.InfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {

    @Resource
    private InfoDao infoDao;

    @Override
    public Info findInfoById(Integer id) {
        if (id != null) {
            return infoDao.findInfoById(id);
        }

        return null;
    }

    @Override
    public List<Info> findAll() {
        return infoDao.findAll();
    }

    @Override
    public boolean delInfoById(Integer id) {
        if (id != null) {
            int result = infoDao.delInfoById(id);
            if (result > 0) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean addInfo(Info info) {
        if (info != null) {
            int result = infoDao.addInfo(info);
            if (result > 0) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean updateInfo(Info info) {
        if (info != null) {
            int result = infoDao.updateInfo(info);
            if (result > 0) {
                return true;
            }
        }

        return false;
    }
}
