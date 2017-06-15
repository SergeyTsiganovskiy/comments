package com.mycompany.comments.tests.deletion;

import com.mycompany.comments.pages.DeleteConfirmationPopup;
import com.mycompany.comments.pages.IndexPage;
import com.mycompany.comments.pages.Table;
import com.mycompany.comments.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletionOneTest extends BaseTest {

    @Test
    public void testDeleteOneComment() {
        IndexPage indexPage = new IndexPage();
        Table table = new Table();
        String NUMBER_OF_DELETED_COMMENT = table.getTableRows().get(1).getCommentNumber().getText();
        table.getTableRows().get(1).getCheckbox().click();
        indexPage.clickDeleteLink();
        new DeleteConfirmationPopup().clickYes();
        Assert.assertFalse(table.isCommentOnPage(NUMBER_OF_DELETED_COMMENT));
    }
}

