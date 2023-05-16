package manage.pojo;

import io.swagger.annotations.ApiModel;

import java.text.SimpleDateFormat;
import java.util.Date;

@ApiModel("用户请求对象")
public class Item {

    //以下formatted*变量需要时在Controller中实例化，用于前端显示正确的时间格式
    public String formattedCreateTime;
    public String getFormattedCreateTime() {
        return formattedCreateTime;
    }
    public void setFormattedCreateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
        String format = sdf.format(createTime);
        this.formattedCreateTime = format;
    }

    public String formattedEndTime;
    public String getFormattedEndTime() {
        return formattedEndTime;
    }
    public void setFormattedEndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
        String format = sdf.format(endTime);
        this.formattedEndTime = format;
    }

    public String formattedFinishedTime;
    public String getFormattedFinishedTime() {
        return formattedFinishedTime;
    }
    public void setFormattedFinishedTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
        String format = sdf.format(finishedTime);
        this.formattedFinishedTime = format;
    }

    public Item(Integer itemId, Integer userId, Date createTime, Date endTime, Date finishedTime, String itemType, String requirement, String refuseMessage, String contactName, String contactNumber, Integer adminId, String itemStatus, String uploadAddress, String downloadAddress) {
        this.itemId = itemId;
        this.userId = userId;
        this.createTime = createTime;
        this.endTime = endTime;
        this.finishedTime = finishedTime;
        this.itemType = itemType;
        this.requirement = requirement;
        this.refuseMessage = refuseMessage;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.adminId = adminId;
        this.itemStatus = itemStatus;
        this.uploadAddress = uploadAddress;
        this.downloadAddress = downloadAddress;
    }

    public Item() {
    }

    private Integer itemId;

    private Integer userId;

    private Date createTime;

    private Date endTime;

    private Date finishedTime;

    private String itemType;

    private String requirement;

    private String refuseMessage;

    private String contactName;

    private String contactNumber;

    private Integer adminId;

    private String itemStatus;

    private String uploadAddress;

    private String downloadAddress;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getRefuseMessage() {
        return refuseMessage;
    }

    public void setRefuseMessage(String refuseMessage) {
        this.refuseMessage = refuseMessage;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getUploadAddress() {
        return uploadAddress;
    }

    public void setUploadAddress(String uploadAddress) {
        this.uploadAddress = uploadAddress;
    }

    public String getDownloadAddress() {
        return downloadAddress;
    }

    public void setDownloadAddress(String downloadAddress) {
        this.downloadAddress = downloadAddress;
    }
}