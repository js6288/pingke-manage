package manage.mapper;

import java.util.List;

import manage.pojo.Item;
import manage.pojo.ItemExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ItemMapper {

    List<Item> getItemsToBeFinished(String adminId);

    List<Item> getFinishedItemsByAdminId(String adminId);

    void setItemToBeFinished(String itemId, String adminId);

    void refuseItem(String itemId, String adminId, String refuseReason);

    long countByExample(ItemExample example);

    int deleteByExample(ItemExample example);

    int deleteByPrimaryKey(Integer itemId);

    int insert(Item record);

    int insertSelective(Item record);

    List<Item> selectByExample(ItemExample example);

    Item selectByPrimaryKey(Integer itemId);

    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

}