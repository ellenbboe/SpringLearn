package com.service;

import com.Dao.studentDao;
import com.studnet.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class service {
    @Resource
    private studentDao studentDao;

    public List<StudentEntity> queryList() {
        return studentDao.findAll();
    }

    @Transactional
    public void save(StudentEntity studentEntity) {
        studentDao.save(studentEntity);
        throw new RuntimeException("添加数据错误");
    }

    public void save(Iterable<StudentEntity> users) {
        studentDao.saveAll(users);
    }


    /**
     * 根据id查询
     * 
     * @param id
     * @return
     */
    public StudentEntity get(int id) {
        return studentDao.getOne(id);

    }

    public void delete(int id) {
        studentDao.deleteById(id);
    }
}
