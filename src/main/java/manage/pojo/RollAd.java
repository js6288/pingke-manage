package manage.pojo;

public class RollAd {
    public RollAd() {
    }

    public RollAd(Integer imgId, String imgSrc) {
        this.imgId = imgId;
        this.imgSrc = imgSrc;
    }

    private Integer imgId;

    private String imgSrc;

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}