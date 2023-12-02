package com.example.tryspringbootkotlin2023.service

import com.example.tryspringbootkotlin2023.model.Catalog
import com.example.tryspringbootkotlin2023.repository.CatalogRepository
import org.springframework.stereotype.Service

@Service
class CatalogService(val repository: CatalogRepository) {

    fun listAllCatalog(): List<Catalog> {
        return repository.findAll().map { it -> Catalog(it.code, it.name) }
    }

}