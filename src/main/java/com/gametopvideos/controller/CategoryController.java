package com.gametopvideos.controller;

import com.gametopvideos.dto.CategoryDTO;
import com.gametopvideos.dto.IdNameDTO;
import com.gametopvideos.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ResponseEntity getCategories(){
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategories();
        return new ResponseEntity<List<CategoryDTO>>(categoryDTOList, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity getLOLHeroes(){
        return new ResponseEntity<List<IdNameDTO>>(categoryService.getLOLHeroes(),HttpStatus.OK);
    }


}
