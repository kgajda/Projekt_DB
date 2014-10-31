package pl.agh.projekt.db.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by karol on 31.10.14.
 */
@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @Column(name = "CategoryID", length = 11, nullable = false)
    private int categoryId;
    @Column(name = "CategoryName", length = 15)
    private String categoryName;
    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "Picture", length = 40)
    private String picture;

    public Categories() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
