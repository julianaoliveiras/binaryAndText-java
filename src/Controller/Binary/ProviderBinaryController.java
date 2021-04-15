package Controller.Binary;

import Controller.ControllerBinaryFile;
import Model.Provider;
import java.util.Iterator;

/**
 *
 * @author Juliana Oliveira
 */
public class ProviderBinaryController extends ControllerBinaryFile{
    public ProviderBinaryController(int typeFile) {
        setFile("Providers", typeFile);
    }
    
        public boolean remove(int id) {
        int check = genericList.size();
        
        Iterator itr = genericList.iterator(); 
        while (itr.hasNext()) 
        { 
            Provider x = (Provider)itr.next(); 
            if (x.getId() == id) 
                itr.remove(); 
                write(false);
        }             
        return check != genericList.size() ? true : false;
    }
    
    public boolean Update(Provider model) {
        try {
            genericList.forEach((item) -> {
                Provider edited = (Provider) item;
                if (edited.getId() == model.getId()) {
                    edited.nome = model.nome;
                    edited.cnpj = model.cnpj;
                    write(false);
                }
            });
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
