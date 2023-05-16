package manage.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.util.Date;

@Component
public class UploadFileUtil {

    @Value("${aliyun.oss.endpoint}")
    String endpoint;

    @Value("${aliyun.oss.bucket}")
    String bucket;

    @Value("${aliyun.oss.accesskeyId}")
    String accesskeyId;

    @Value("${aliyun.oss.accesskeySecret}")
    String accesskeySecret;

    //上传文件并返回下载地址
    public String upload(File file) {
        String returnURL = null;
        OSS oss = new OSSClientBuilder().build(endpoint, accesskeyId, accesskeySecret);
        try {
            String objectName = file.getName();
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, objectName, file);
            oss.putObject(putObjectRequest);

            //查看bucket是否已经存在这个文件名
//            boolean found = oss.doesObjectExist(bucket, objectName);

            //获取URL地址，限期为3600s,即生成的URL一小时后失效
//            Date expiration = new Date(new Date().getTime() + 3600 * 1000);
//            URL url = oss.generatePresignedUrl(bucket, objectName, expiration);
//            returnURL = url.toString();

            returnURL = "https://public-read-miracle-happen-bucket.oss-cn-guangzhou.aliyuncs.com/"+objectName;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (oss != null) {
                oss.shutdown();
            }
        }
        return returnURL;
    }
}