package manage.service;

import manage.mapper.AdminMapper;
import manage.mapper.ItemMapper;
import manage.mapper.RollAdMapper;
import manage.pojo.Admin;
import manage.pojo.Item;
import manage.pojo.ItemExample;
import manage.pojo.RollAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    AdminMapper adminMapper;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    RollAdMapper rollAdMapper;

    public void changeRollAd(String imgId,String imgSrc){
        rollAdMapper.updateByPrimaryKey(new RollAd(Integer.parseInt(imgId),imgSrc));
    }

    public List<RollAd> getRollAds(){
        return rollAdMapper.selectByExample(null);
    }

    public void updateFinshedInfo(int itemId,int adminId,String downloadAddress){

        Item item = itemMapper.selectByPrimaryKey(itemId);
        item.setFinishedTime(new Date());
        item.setAdminId(adminId);
        item.setItemStatus("finished");
        item.setDownloadAddress(downloadAddress);

        ItemExample itemExample=new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        itemMapper.updateByExample(item,itemExample);
    }

    public Admin queryUserByName(String name) {
        return adminMapper.queryAdminByName(name);
    }

    public List<Item> queryAllItemsToBesolved() {
        ItemExample itemExample=new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andItemStatusEqualTo("toBeSolved");
        List<Item> itemsToBeSolved = itemMapper.selectByExample(itemExample);
        return itemsToBeSolved;
    }

    public List<Item> queryUnfinishedItemsByAdminId(Integer adminId) {
        ItemExample itemExample=new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andItemStatusEqualTo("toBeFinished").andAdminIdEqualTo(adminId);
        List<Item> itemsToBeFinished = itemMapper.selectByExample(itemExample);
        return itemsToBeFinished;
    }

    public List<Item> queryFinishedItemsByAdminId(int adminId) {
        ItemExample itemExample=new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andAdminIdEqualTo(adminId).andItemStatusEqualTo("finished");
        List<Item> itemsFinished = itemMapper.selectByExample(itemExample);
        return itemsFinished;
    }

    public Item queryItemById(int id) {
        return itemMapper.selectByPrimaryKey(id);
    }

    public void acceptItem(String itemId, String adminId) {
        itemMapper.setItemToBeFinished(itemId,adminId);
    }

    public void refuseItem(String itemId, String adminId, String refuseReason) {
        itemMapper.refuseItem(itemId,adminId,refuseReason);
    }

    public List<Item> getFinishedItemsByAdminId(String adminId) {
        return itemMapper.getFinishedItemsByAdminId(adminId);
    }

    public List<Item> toBeFinishedByAdminId(String adminId) {
        return itemMapper.getItemsToBeFinished(adminId);
    }

    public String[] getIndexData(int adminId) {
        String[] data=new String[4];
        //待处理toBeSolved
        ItemExample itemExampleToBeSolved = new ItemExample();
        itemExampleToBeSolved.createCriteria().andItemStatusEqualTo("toBeSolved");
        long toBeSolved = itemMapper.countByExample(itemExampleToBeSolved);
        //我的任务adminId,toBeFinished
        ItemExample itemExampleToBeFinished = new ItemExample();
        itemExampleToBeFinished.createCriteria().andItemStatusEqualTo("toBeFinished").andAdminIdEqualTo(adminId);
        long toBeFinished = itemMapper.countByExample(itemExampleToBeFinished);
        //已完成finished
        ItemExample itemExampleFinished = new ItemExample();
        itemExampleFinished.createCriteria().andItemStatusEqualTo("finished").andAdminIdEqualTo(adminId);
        long finished = itemMapper.countByExample(itemExampleFinished);
        //团队处理数量all
        ItemExample itemExampleSettled = new ItemExample();
        List<String> list=new ArrayList<>();
        list.add("refused");
        list.add("finished");
        itemExampleSettled.createCriteria().andItemStatusIn(list);
        long settled = itemMapper.countByExample(itemExampleSettled);
        data[0]=String.valueOf(toBeSolved);
        data[1]=String.valueOf(toBeFinished);
        data[2]=String.valueOf(finished);
        data[3]=String.valueOf(settled);
        return data;
    }
}
