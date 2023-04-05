package Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void testWhenRemoveProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Книга", 500);
        Product product2 = new Product(2, "Телефон", 50_000);
        Product product3 = new Product(3, "Самокат", 20_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testWhenRemoveProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Книга", 500);
        Product product2 = new Product(2, "Телефон", 50_000);
        Product product3 = new Product(3, "Самокат", 20_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Product[] actual = repo.findAll();
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(4)
        );

    }

}