package com.sh.mybatisdemo;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisdemoApplicationTests {

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Autowired
    GridFSBucket gridFSBucket;

    @Test
    void contextLoads() {

    }

    @Test
    void testGridFs() throws FileNotFoundException {
        //读取文件
        File file=new File("C:\\Users\\葬爱虎\\Desktop\\指导老师成绩评定表.pdf");

        //获取输入流
        FileInputStream fileInputStream=new FileInputStream(file);

        ObjectId objectId = gridFsTemplate.store(fileInputStream, "指导成绩表.pdf");
        String fileId = objectId.toString();
        System.out.println(fileId);
    }

    @Test
    void testDownLoad() throws IOException {
        String fileId = "5ecb963e358df867c53ec782";
        //查询需要下载的文件
        GridFSFile gridFSFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(fileId)));
        //打开下载流
        GridFSDownloadStream gridFSDownloadStream=gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
        //创建gridResource,获取流对象
        GridFsResource gridFsResource=new GridFsResource(gridFSFile,gridFSDownloadStream);

        InputStream inputStream = gridFsResource.getInputStream();

        File f1 = new File("D:\\test\\get.pdf");
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
    }


    @Test
    void testDelete(){

        gridFsTemplate.delete(new Query(Criteria.where("_id").is("5ecb963e358df867c53ec782")));

    }



}
