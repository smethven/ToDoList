import model.UrgentItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class UrgentItemTest extends ItemTest {

    @Override
    @BeforeEach
    public void setup() {
        i = new UrgentItem();
    }

    @Test
    public void constructorTest() {
        assertEquals("URGENT!: general", i.getCategory());
    }

    @Override
    @Test
    public void getNoCategoryTest(){
        i.setCategory("");
        assertEquals("URGENT!: ", i.getCategory());
    }

    @Override
    @Test
    public void getLittleCategoryTest(){
        i.setCategory("a");
        assertEquals("URGENT!: a", i.getCategory());
    }

    @Override
    @Test
    public void setLotsCategory(){
        i.setCategory("blah blah blah");
        assertEquals("URGENT!: blah blah blah", i.getCategory());
    }

    @Override
    @Test
    public void setLittleCategory(){
        i.setCategory("a");
        assertEquals("URGENT!: a", i.getCategory());
    }

    @Override
    @Test
    public void setNoCategory(){
        i.setCategory("");
        assertEquals("URGENT!: ",i.getCategory());
    }

    @Override
    @Test
    public void getLotsCategoryTest() {
        i.setCategory("blah blah blah");
        assertEquals("URGENT!: blah blah blah", i.getCategory());
    }
}
