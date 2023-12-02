package com.example.tryspringbootkotlin2023.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "catalog")
data class CatalogDocument(
    @Id
    var id: String?, var code: String, var name: String
) {

}