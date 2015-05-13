package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by NotePad on 27/03/2015.
 */
@Entity
public class Smi {
    private int smiId;
    private String title;

    @Id
    @Column(name = "smi_id")
    public int getSmiId() {
        return smiId;
    }

    public void setSmiId(int smiId) {
        this.smiId = smiId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Smi smi = (Smi) o;

        if (smiId != smi.smiId) return false;
        if (title != null ? !title.equals(smi.title) : smi.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = smiId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
