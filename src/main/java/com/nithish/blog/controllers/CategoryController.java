package com.nithish.blog.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nithish.blog.payloads.ApiResponse;
import com.nithish.blog.payloads.CategoryDto;
import com.nithish.blog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	
	@Autowired
	private CategoryService categorySerive;
	// create
	@PostMapping("/")
	 public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		 CategoryDto createdCategory = this.categorySerive.createCategory(categoryDto);
		 return new ResponseEntity<CategoryDto>(createdCategory,HttpStatus.CREATED);
	 }
	
	//update
	
	@PutMapping("/{catId}")
	 public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId){
		 CategoryDto updatedCategory = this.categorySerive.updateCategory(categoryDto,catId);
		 return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);
	 }
	
	// delete
	@DeleteMapping("/{catId}")
	 public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
		 this.categorySerive.deleteCategory(catId);
		 return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!",true),HttpStatus.OK);
	 }
	
	// get
	
	@GetMapping("/{catId}")
	 public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
		 CategoryDto categoryDto = this.categorySerive.getCategory(catId);
		 return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
	 }
	
	// get all
	
	@GetMapping("/")
	 public ResponseEntity<List<CategoryDto>> getCategory(){
		 List<CategoryDto> categories = this.categorySerive.getCategory();
		return ResponseEntity.ok(categories); 
	 }
	
}
