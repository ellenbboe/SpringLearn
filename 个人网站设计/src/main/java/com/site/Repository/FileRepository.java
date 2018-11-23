package com.site.Repository;

import com.site.entity.FileEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;
import java.util.List;

public interface FileRepository extends CrudRepository<FileEntity,Integer> {
    //保存文件信息save
    //删除文件信息
    //获取文件信息(按照owner的id)
    List<FileEntity> findByOwnerId(Integer ownerId);

}
