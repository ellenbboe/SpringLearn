package com.site.service;

import com.site.entity.FileEntity;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    void store(MultipartFile file,Integer id);

    List<FileEntity> loadAllByOwenId(Integer id);

    Map<String,String> loadAll(Integer Pagenum);

    Integer filecount();

    Path load(String filename);

    List<String> load();

    Resource loadAsResource(String filename);

}
