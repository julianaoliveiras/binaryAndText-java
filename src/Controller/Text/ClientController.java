package Controller.Text;

import Controller.ControllerTextFile;

/**
 *
 * @author Juliana Oliveira
 */
public class ClientController extends ControllerTextFile{
    public ClientController(int typeFile) {
        setFile("Clients", typeFile);
    }
}
