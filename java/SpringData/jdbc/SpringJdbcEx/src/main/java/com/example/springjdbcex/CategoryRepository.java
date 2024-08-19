package com.example.springjdbcex;

import org.springframework.data.repository.CrudRepository;

interface CategoryRepository extends CrudRepository<Category,Long>, WithInsert<Category> {
}
