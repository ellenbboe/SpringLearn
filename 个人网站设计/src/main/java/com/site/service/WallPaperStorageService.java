package com.site.service;

import com.site.Exception.StorageException;
import com.site.Exception.StorageFileNotFoundException;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class WallPaperStorageService implements StorageService {

//    @Autowired(由于没有联系数据库,所以不需要)
//    private WallpaperRepository wallpaperRepository;

    private final Path rootLocation;

    //设置文件路径
    @Autowired
    public WallPaperStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation() + "/wallpaper");
    }


    //保存文件
//    public void store(MultipartFile file) {
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
//        return fileRepository.findByOwnerId(id);
        return null;
    }

    //    public List<WallpaperEntity> loadAllWallpaper(){
//
//    }
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
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
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
            if (!Files.exists(rootLocation)) {
                Files.createDirectory(rootLocation);
            }
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    //保存文件 数据库存放文件信息
    @Override
    public void store(MultipartFile file, Integer id) {
//        try {
//            if (file.isEmpty()) {//空文件
//                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
//            }
//            Files.copy(file.getInputStream(), //复制文件
//                    this.rootLocation.resolve(file.getOriginalFilename()));
//(需要修改)
//            FileEntity entity = new FileEntity();
//            entity.setFilename(file.getOriginalFilename());
//            entity.setSize(file.getSize());
//            entity.setOwnerId(id);
//            entity.setFileuri("files/wallpaper/"+file.getOriginalFilename());
//            WallpaperRepository.save(entity);
//        } catch (IOException e) {
//            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
//        }
    }


    //获取存取的文件(本地文件夹)
    @Override
    public Map<String,String> loadAll(Integer pagenum) {
        try {
            Integer size = 9;
            Map<String,String> imageMap = new HashMap<String,String>();
            //得到了文件名称
            if(pagenum<1){
                pagenum = 1;
            }
            List<String> name = Files.walk(this.rootLocation, 1)//遍历文件夹
                    .filter(path -> !path.equals(this.rootLocation))//条件筛选
                    .map(path -> this.rootLocation.relativize(path).toString())
                    .collect(Collectors.toList());//将map中的path转换
            Integer length = name.size();
            Integer start = (pagenum-1)*size;
            Integer end = pagenum*size-1 > length? length : pagenum*size;

            List<String> part = name.subList(start,end);
            for (String one:part) {
                imageMap.put("/static/images/wallpaper/"+one,"/wallpaper/download/"+one);
            }
            return imageMap;
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    @Override
    public List<String> load(){
        try {
            return Files.walk(this.rootLocation, 1)//遍历文件夹
                    .filter(path -> !path.equals(this.rootLocation))//条件筛选
                    .map(path -> "/static/images/wallpaper/"+this.rootLocation.relativize(path).toString()).collect(Collectors.toList());//将map中的path转换
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }
    }

    @Override
    public Integer filecount() {
        try {
            return Files.walk(this.rootLocation, 1)//遍历文件夹
                    .filter(path -> !path.equals(this.rootLocation))//条件筛选
                    .map(path -> this.rootLocation.relativize(path).toString()).collect(Collectors.toList()).size();
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }
    }
}
