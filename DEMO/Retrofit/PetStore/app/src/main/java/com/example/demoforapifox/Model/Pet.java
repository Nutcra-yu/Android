package com.example.demoforapifox.Model;

import java.util.List;

public class Pet {

    private String name;
    private List<String> photoUrls;
    private Long id;
    private CategoryDTO category;
    private List<TagsDTO> tags;
    private String status;

    public static class CategoryDTO {
        private Integer id;
        private String name;
    }
    public static class TagsDTO {
        private Integer id;
        private String name;
    }

    public Long getId() {
        return id;
    }
    public String getStatus() {
        return status;
    }
    public String getName() {
        return name;
    }
    public CategoryDTO getCategory() {
        return category;
    }
    public List<String> getPhotoUrls() {
        return photoUrls;
    }
    public List<TagsDTO> getTags() {
        return tags;
    }
}
