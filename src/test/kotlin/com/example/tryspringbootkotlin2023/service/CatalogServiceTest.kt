package com.example.tryspringbootkotlin2023.service

import com.example.tryspringbootkotlin2023.document.CatalogDocument
import com.example.tryspringbootkotlin2023.repository.CatalogRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CatalogServiceTest {

    var catalogRepository: CatalogRepository = mockk()
    val catalogService: CatalogService = CatalogService(catalogRepository)

    @Test
    fun `should return empty list of catalog when catalog doesn't exits`() {
        every { catalogRepository.findAll() } returns emptyList()

        val listAllCatalog = catalogService.listAllCatalog();

        Assertions.assertEquals(listAllCatalog.size, 0)
    }

    @Test
    fun `should return list of catalog when catalog exits`() {
        every { catalogRepository.findAll() } returns listOf(
            CatalogDocument(null, "c1", "n1"),
            CatalogDocument(null, "c1", "n1")
        )

        val listAllCatalog = catalogService.listAllCatalog();

        Assertions.assertEquals(listAllCatalog.size, 2)
    }
}