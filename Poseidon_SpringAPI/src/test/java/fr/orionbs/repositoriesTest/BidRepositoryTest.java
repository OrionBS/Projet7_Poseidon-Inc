package fr.orionbs.repositoriesTest;

import fr.orionbs.repositories.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class BidRepositoryTest {

    @Autowired
    private BidRepository bidListRepository;


}
