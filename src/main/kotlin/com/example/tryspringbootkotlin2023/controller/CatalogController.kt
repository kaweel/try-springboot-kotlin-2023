package com.example.tryspringbootkotlin2023.controller

import com.example.tryspringbootkotlin2023.model.Catalog
import com.example.tryspringbootkotlin2023.service.CatalogService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("catalog")
class CatalogController(val catalogService: CatalogService) {
    @GetMapping("")
    fun listAllCatalog(): List<Catalog> {
        return catalogService.listAllCatalog()
    }
}