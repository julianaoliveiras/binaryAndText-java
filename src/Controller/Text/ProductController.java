package Controller.Text;

import Controller.ControllerTextFile;

/**
 *
 * @author Juliana Oliveira
 */
public class ProductController extends ControllerTextFile{
        public ProductController(int typeFile) {
        setFile("Products", typeFile);
    }
}
