package domainTest;

import dao.ItemsDao;
import domain.Items;
import impl.ItemsDaoImpl;
import org.junit.Test;

import java.util.List;

public class ItemsTest {
    @Test
    public void findAll() throws Exception {
        ItemsDao itemsDao=new ItemsDaoImpl();
        List<Items> list = itemsDao.findAll();
        for (Items items : list) {
            System.out.println(items.getNAME());
        }
    }
}
