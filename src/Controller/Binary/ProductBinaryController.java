package Controller.Binary;

import Controller.ControllerBinaryFile;
import Model.Product;
import java.util.Iterator;

/**
 *
 * @author Juliana Oliveira
 */
public class ProductBinaryController extends ControllerBinaryFile{
    public ProductBinaryController(int typeFile) {
        setFile("Products", typeFile);
    }
    
    public boolean remove(int id) {
        int check = genericList.size();
        
        Iterator itr = genericList.iterator(); 
        while (itr.hasNext()) 
        { 
            Product x = (Product)itr.next(); 
            if (x.getId() == id) 
                itr.remove(); 
                write(false);
        }             
        return check != genericList.size() ? true : false;
    }
    
    public boolean Update(Product model) {
        try {
            genericList.forEach((item) -> {
                Product edited = (Product) item;
                if (edited.getId() == model.getId()) {
                    edited.nome = model.nome;
                    edited.tipo = model.tipo;
                    write(false);
                }
            });
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
