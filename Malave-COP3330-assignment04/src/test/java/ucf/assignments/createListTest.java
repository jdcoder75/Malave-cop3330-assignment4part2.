package ucf.assignments;

import org.junit.jupiter.api.Test;

class createListTest {
    @Test
    public void listCreateTest()
    {


        Controller controller = new Controller();

        controller.addButton();
        controller.saveButton();
        controller.loadButton();
        controller.displayComp();
        controller.displayIncom();
        controller.removeButton();
        controller.deleteAll();

    }

}