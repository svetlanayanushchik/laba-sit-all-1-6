package entity;

import javax.persistence.*;

/**
 * Created by NotePad on 27/03/2015.
 */
@Entity
@Table(name = "smi_news_region", schema = "", catalog = "statistics")
public class SmiNewsRegion {
    private int smiNewsRegionId;
    private Integer purchaseCount;
    private News newsByNewsId;
    private Region regionByRegionId;
    private Smi smiBySmiId;

    @Id
    @Column(name = "smi_news_region_id")
    public int getSmiNewsRegionId() {
        return smiNewsRegionId;
    }

    public void setSmiNewsRegionId(int smiNewsRegionId) {
        this.smiNewsRegionId = smiNewsRegionId;
    }

    @Basic
    @Column(name = "purchase_count")
    public Integer getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(Integer purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmiNewsRegion that = (SmiNewsRegion) o;

        if (smiNewsRegionId != that.smiNewsRegionId) return false;
        if (purchaseCount != null ? !purchaseCount.equals(that.purchaseCount) : that.purchaseCount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = smiNewsRegionId;
        result = 31 * result + (purchaseCount != null ? purchaseCount.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "news_id", referencedColumnName = "news_id")
    public News getNewsByNewsId() {
        return newsByNewsId;
    }

    public void setNewsByNewsId(News newsByNewsId) {
        this.newsByNewsId = newsByNewsId;
    }

    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "region_id")
    public Region getRegionByRegionId() {
        return regionByRegionId;
    }

    public void setRegionByRegionId(Region regionByRegionId) {
        this.regionByRegionId = regionByRegionId;
    }

    @ManyToOne
    @JoinColumn(name = "smi_id", referencedColumnName = "smi_id")
    public Smi getSmiBySmiId() {
        return smiBySmiId;
    }

    public void setSmiBySmiId(Smi smiBySmiId) {
        this.smiBySmiId = smiBySmiId;
    }
}
