package com.gametopvideos.service;

import com.gametopvideos.base.AbstractService;
import com.gametopvideos.dto.CategoryDTO;
import com.gametopvideos.dto.IdNameDTO;
import com.gametopvideos.entity.Category;
import com.gametopvideos.enums.LOLHeroes;
import com.gametopvideos.repo.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService extends AbstractService<Category, CategoryDTO> {

    private CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<CategoryDTO> getAllCategories(){
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        List<Category> categoryList = categoryRepo.findAll();
        return toDTOList(categoryList,categoryDTOList);
    }

    public List<IdNameDTO> getLOLHeroes(){
        Object[] lolHeroes = LOLHeroes.class.getEnumConstants();
        List<IdNameDTO> idNameDTOList = new ArrayList<>();

        for(Object o : lolHeroes){
            IdNameDTO idNameDTO = new IdNameDTO();
            idNameDTO.setId(((LOLHeroes) o).getId());
            idNameDTO.setName(((LOLHeroes) o).getName());
            idNameDTOList.add(idNameDTO);
        }
        return idNameDTOList;
    }
}
