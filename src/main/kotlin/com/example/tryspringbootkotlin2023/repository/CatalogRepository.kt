package com.example.tryspringbootkotlin2023.repository

import com.example.tryspringbootkotlin2023.document.CatalogDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CatalogRepository : MongoRepository<CatalogDocument, String> {

}