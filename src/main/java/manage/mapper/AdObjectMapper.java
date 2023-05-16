package manage.mapper;

import java.util.List;
import manage.pojo.AdObject;
import manage.pojo.AdObjectExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdObjectMapper {
    long countByExample(AdObjectExample example);

    int deleteByExample(AdObjectExample example);

    int deleteByPrimaryKey(Integer adId);

    int insert(AdObject record);

    int insertSelective(AdObject record);

    List<AdObject> selectByExample(AdObjectExample example);

    AdObject selectByPrimaryKey(Integer adId);

    int updateByExampleSelective(@Param("record") AdObject record, @Param("example") AdObjectExample example);

    int updateByExample(@Param("record") AdObject record, @Param("example") AdObjectExample example);

    int updateByPrimaryKeySelective(AdObject record);

    int updateByPrimaryKey(AdObject record);
}