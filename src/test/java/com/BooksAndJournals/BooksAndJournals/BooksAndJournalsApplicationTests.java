package com.BooksAndJournals.BooksAndJournals;

import com.BooksAndJournals.BooksAndJournals.model.Resource;
import com.BooksAndJournals.BooksAndJournals.model.Type;
import com.BooksAndJournals.BooksAndJournals.service.ResourceServices;
import com.BooksAndJournals.BooksAndJournals.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BooksAndJournalsApplication.class)
@WebAppConfiguration
class BooksAndJournalsApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private ResourceServices resourceServices;

	@Test
	void addBook() {
        Resource resource = new Resource();
        resource.setName("Ammar");
        resource.setDescription("Book description");
        resource.setAuthor("Author");
        resource.setAvailability(true);
        resource.setResourceType(Type.BOOK);
        Resource savedResource = resourceServices.addResource(resource);
        Optional<Resource> resourceById = resourceServices.getById(savedResource.getId());
        Assert.assertTrue(resourceById.isPresent());
        Assert.assertEquals(savedResource.getId(), resourceById.get().getId());
	}

}
