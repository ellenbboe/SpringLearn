package com.site.service;

import com.site.Exception.StorageException;
import com.site.Exception.StorageFileNotFoundException;
import com.site.Repository.FileRepository;
import com.site.entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class FileSystemStorageService implements StorageService {
    @Override
    public List<String> load() {
        return null;
    }

    @Override
    public Integer filecount() {
        return null;
    }

    @Override
    public Map<String, String> loadAll(Integer Pagenumber) {
        return null;
    }

    @Autowired
    private FileRepository fileRepository;

    private final Path rootLocation;

    //设置文件路径
    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    //保存文件 数据库存放文件信息
    @Override
    public void store(MultipartFile file,Integer id) {
        try {
            if (file.isEmpty()) {//空文件
                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
            }
            Files.copy(file.getInputStream(), //复制文件
                    this.rootLocation.resolve(file.getOriginalFilename()));

            FileEntity entity = new FileEntity();
            entity.setFilename(file.getOriginalFilename());
            entity.setSize(file.getSize());
            entity.setOwnerId(id);
            entity.setFileuri("files/"+file.getOriginalFilename());
            fileRepository.save(entity);
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }
//获取存取的文件 可以联系数据库
//    @Override
//    public Stream<Path> loadAllWallpaper() {
//        try {
//            return Files.walk(this.rootLocation, 1)//遍历文件夹
//                    .filter(path -> !path.equals(this.rootLocation))//条件筛选
//                    .map(path -> this.rootLocation.relativize(path));//将map中的path转换
//
//
//        } catch (IOException e) {
//            throw new StorageException("Failed to read stored files", e);
//        }
//    }


//数据库里面读取
    @Override
    public List<FileEntity> loadAllByOwenId(Integer id) {
//        Iterator<FileEntity> filelist = fileRepository.findByOwnerId(id);
//        List<FileEntity> fileEntities = new ArrayList<FileEntity>();
//        while(filelist.hasNext()){
//            fileEntities.add(filelist.next());
//        }
//        return fileEntities;
        return fileRepository.findByOwnerId(id);
    }

    //加载文件路径
    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }
//将文件变成resource 返回
    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }


//创建文件夹
    @Override
    public void init() {
        try {
            if(!Files.exists(rootLocation)){
                Files.createDirectory(rootLocation);
            }
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }
}
