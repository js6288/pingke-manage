package manage.mapper;

import java.util.List;
import manage.pojo.RollAd;
import manage.pojo.RollAdExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RollAdMapper {
    long countByExample(RollAdExample example);

    int deleteByExample(RollAdExample example);

    int deleteByPrimaryKey(Integer imgId);

    int insert(RollAd record);

    int insertSelective(RollAd record);

    List<RollAd> selectByExample(RollAdExample example);

    RollAd selectByPrimaryKey(Integer imgId);

    int updateByExampleSelective(@Param("record") RollAd record, @Param("example") RollAdExample example);

    int updateByExample(@Param("record") RollAd record, @Param("example") RollAdExample example);

    int updateByPrimaryKeySelective(RollAd record);

    int updateByPrimaryKey(RollAd record);
}