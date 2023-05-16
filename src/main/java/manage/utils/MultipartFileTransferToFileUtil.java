package manage.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

//将网页传过来的MultipartFile对象转换成File对象
public class MultipartFileTransferToFileUtil {
    public File transferToFile(MultipartFile multipartFile) {
//        选择用缓冲区来实现这个转换即使用java 创建的临时文件 使用 MultipartFile.transferto()方法 。
        File file = null;
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            String[] filename = originalFilename.split("\\.");
            String theName="";
            for(int i=0;i< filename.length-1;i++){
                if(i== filename.length-2){
                    theName=theName+filename[i];
                }else {
                    theName=theName+filename[i]+".";
                }
            }
            //上传到服务器需要防止重名
            String tempStr = String.valueOf(System.currentTimeMillis()).substring(0, 5);
            file=File.createTempFile(theName+tempStr, "."+filename[filename.length-1]);
            multipartFile.transferTo(file);
            file.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
