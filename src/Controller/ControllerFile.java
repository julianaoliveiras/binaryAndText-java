package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import javax.swing.JFileChooser;

/**
 *
 * @author Juliana Oliveira
 */
public abstract class ControllerFile {
    String rootFolder = System.getProperty("user.home");
	protected File path = null;
	protected String model = "";
	
	protected File file = null;
	public abstract String read();
	public abstract boolean write(boolean append);
	
	
	public File getFile() {
            return file;
	}
        
        //0 = Binário e 1 = Texto
        //Model = Cliente, Produto, Fornecedor
	public void setFile(String model, int typeFile ) {
            if (typeFile == 0) {
                rootFolder += "/binaryFolder/";
            } else if (typeFile == 1) {
                rootFolder += "/textFolder/";
            } else {
                //throwException - tipo inválido
            }
            path = new File(rootFolder);
            if(!path.exists()){
		path.mkdir();
            }
            if (model.isEmpty()) {
                //Exception arquivo vazio
            }
            this.model = model;
            file = new File(path,model);
        }
}
