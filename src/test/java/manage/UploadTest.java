package manage;

import manage.mapper.ItemMapper;
import manage.pojo.Item;
import manage.utils.UploadFileUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class UploadTest {
    @Autowired
    UploadFileUtil uploadFileUtil;
    @Test
    void contextLoads() {
        File file=new File("C:\\Users\\Administrator\\Desktop\\aaaa.rar");
        String address = uploadFileUtil.upload(file);
        System.out.println(address);
    }
}