package manage.pojo;

import io.swagger.annotations.ApiModel;

@ApiModel("广告对象")
public class AdObject {

    public AdObject() {
    }

    public AdObject(Integer adId, String adName, String adSrc, String adIntroduce, Integer adAdminid) {
        this.adId = adId;
        this.adName = adName;
        this.adSrc = adSrc;
        this.adIntroduce = adIntroduce;
        this.adAdminid = adAdminid;
    }

    private Integer adId;

    private String adName;

    private String adSrc;

    private String adIntroduce;

    private Integer adAdminid;

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdSrc() {
        return adSrc;
    }

    public void setAdSrc(String adSrc) {
        this.adSrc = adSrc;
    }

    public String getAdIntroduce() {
        return adIntroduce;
    }

    public void setAdIntroduce(String adIntroduce) {
        this.adIntroduce = adIntroduce;
    }

    public Integer getAdAdminid() {
        return adAdminid;
    }

    public void setAdAdminid(Integer adAdminid) {
        this.adAdminid = adAdminid;
    }
}