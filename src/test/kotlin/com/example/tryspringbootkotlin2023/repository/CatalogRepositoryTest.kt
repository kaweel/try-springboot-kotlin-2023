package com.example.tryspringbootkotlin2023.repository

import com.example.tryspringbootkotlin2023.document.CatalogDocument
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@DataMongoTest
class CatalogRepositoryTest {
    @Autowired
    lateinit var repository: CatalogRepository

    companion object {
        @Container
        val container: MongoDBContainer = MongoDBContainer("mongo:7.0.4");

        @DynamicPropertySource
        @JvmStatic
        fun setProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.data.mongodb.uri", container::getReplicaSetUrl)
        }
    }

    @BeforeEach
    fun setUp() {
        repository.deleteAll()
    }

    @Test
    fun `should return all list of catalog when catalog exists`() {
        repository.saveAll(
            listOf(
                CatalogDocument(null, "code#1", "name#1"),
                CatalogDocument(null, "code#2", "name#2"),
                CatalogDocument(null, "code#3", "name#3")
            )
        )

        val catalogs = repository.findAll()

        assertThat(catalogs).hasSize(3).extracting("code").contains("code#3")
    }

    @Test
    fun `should return all list of catalog when catalog doesn't exists`() {
        val catalogs = repository.findAll()

        assertThat(catalogs).hasSize(0)
    }
}