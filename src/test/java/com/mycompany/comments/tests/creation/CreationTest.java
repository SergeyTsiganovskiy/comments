package com.mycompany.comments.tests.creation;

import com.mycompany.comments.pages.EditorPage;
import com.mycompany.comments.pages.IndexPage;
import com.mycompany.comments.pages.Table;
import com.mycompany.comments.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.mycompany.comments.data.CommentRepository.getValidActiveComment;
import static org.testng.Assert.assertTrue;

public class CreationTest extends BaseTest {

    private EditorPage editorPage;

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        IndexPage indexPage = new IndexPage();
        editorPage = indexPage.clickNewLink();
    }

    @Test
    public void testValidCommentCreation() {
        editorPage.fillNewCommentsFields(getValidActiveComment());
        editorPage.saveAndReturn.click();
        Table table = new Table();
        assertTrue(table.isCommentInTable(getValidActiveComment().getNumber()));
    }
}