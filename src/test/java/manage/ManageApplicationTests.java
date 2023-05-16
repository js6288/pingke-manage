package manage;

import manage.mapper.ItemMapper;
import manage.pojo.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ManageApplicationTests {

    @Autowired
    ItemMapper itemMapper;

    @Test
    void contextLoads() {
        for(int i=0;i<10;i++){
            itemMapper.insert(
                    new Item(null,1,new Date(),
                            new Date(150,5,23), null,
                            "ppt","我想要精美的ppt",null,
                            "小花","13524855484",
                            null,"toBeSolved",
                            "fileAddress","g"
                    )
            );
        }
    }

}
