package dc.ufscar.es2;

import net.sf.jabref.model.entry.BibEntry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

public class InsertionTestCase {

    private BibEntry entry;
    private BibEntry emptyEntry;

    @Before
    public void setUp(){
        entry = new BibEntry();

        // Empty entry for some tests
        emptyEntry = new BibEntry();
        emptyEntry.setType("article");
        emptyEntry.setChanged(false);
    }

    @After
    public void tearDown(){
        entry = null;
    }

    @Test
    public void nullBibEntry(){
        entry.setField("","");
        Assert.assertTrue(entry.getKeywords(',').isEmpty());
    }

    @Test
    public void invalidIdBibEntry(){
        String id = "99999999999999999999999999999999999999";
        String expected = "99999999999999999999999999999999999999";
        entry.setId(id);
        id = entry.getId();
        Assert.assertEquals(expected, id);
    }

    //Teste para validação do CiteKey (Não é o mesmo ID mas não deve ser nula)
    @Test
    public void invalidCiteKey(){
        String citeKeyTest = ""; //citeKey não pode ser vazia
        String expected = "1";
        entry.setCiteKey(citeKeyTest);
        citeKeyTest = entry.getCiteKey();
        Assert.assertEquals(expected, citeKeyTest);
    }
}