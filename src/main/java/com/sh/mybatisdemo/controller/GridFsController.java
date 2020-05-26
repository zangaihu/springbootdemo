package com.sh.mybatisdemo.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created By Sunhu At 2020/5/26 8:55
 *
 * @author Sun
 */
@RestController
@RequestMapping("/gridFs")
@Slf4j
public class GridFsController {


    //public static final Logger LOGGER=LoggerFactory.getLogger(GridFsController.class);

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Autowired
    GridFSBucket gridFSBucket;

    @RequestMapping("upload")
    public ResponseEntity saveFile(@RequestParam(name = "file")MultipartFile file){
        log.info("save file...");
        DBObject metaData=new BasicDBObject();
        metaData.put("createdDate",new Date());

        String fileName=file.getOriginalFilename();

        InputStream inputStream=null;

        try {
            inputStream=file.getInputStream();
            gridFsTemplate.store(inputStream,fileName,"application/pdf",metaData);
            log.info("file saved"+fileName);
        } catch (IOException e) {
            log.error("IOException ");
            throw new RuntimeException();
        }
        log.info("return"+fileName);
        return ResponseEntity.ok("success");
    }


    @RequestMapping("downLoad")
    public ResponseEntity downLoadFile(@RequestParam(name = "fileName") String fileName) throws IOException {

        //查询需要下载的文件
        GridFSFile gridFSFile = gridFsTemplate.findOne(new Query(Criteria.where("filename").is(fileName)));
        //打开下载流
        GridFSDownloadStream gridFSDownloadStream=gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
        //创建gridResource,获取流对象
        GridFsResource gridFsResource=new GridFsResource(gridFSFile,gridFSDownloadStream);

        InputStream inputStream = gridFsResource.getInputStream();

        File f1 = new File("D:\\test\\"+fileName);
        if (!f1.exists()) {
            f1.getParentFile().mkdirs();
        }
        byte[] bytes = new byte[1024];
        // 创建基于文件的输出流
        FileOutputStream fos = new FileOutputStream(f1);
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        inputStream.close();
        fos.close();


        return ResponseEntity.ok().build();
    }

    @RequestMapping("delete")
    public void delete(@RequestParam(name = "fileName") String fileName) {
        log.info("Deleting file.." + fileName);
        gridFsTemplate.delete(new Query().addCriteria(Criteria.where("filename").is(fileName)));
        log.info("File deleted " + fileName);


    }
}
