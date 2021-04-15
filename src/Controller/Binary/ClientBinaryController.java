package Controller.Binary;

import Controller.ControllerBinaryFile;
import Model.Client;
import java.util.Iterator;

/**
 *
 * @author Juliana Oliveira
 */
public class ClientBinaryController extends ControllerBinaryFile {

    public ClientBinaryController(int typeFile) {
        setFile("Clients", typeFile);
    }

    public boolean remove(int id) {
        int check = genericList.size();
        
        Iterator itr = genericList.iterator(); 
        while (itr.hasNext()) 
        { 
            Client x = (Client)itr.next(); 
            if (x.getId() == id) 
                itr.remove(); 
                write(false);
        }             
        return check != genericList.size() ? true : false;
    }
    
    public boolean Update(Client model) {
        try {
            genericList.forEach((item) -> {
                Client edited = (Client) item;
                if (edited.getId() == model.getId()) {
                    edited.nome = model.nome;
                    edited.endereço = model.endereço;
                    write(false);
                }
            });
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
