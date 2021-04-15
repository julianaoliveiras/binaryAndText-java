package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Juliana Oliveira
 */
public class ControllerTextFile extends ControllerFile {

    protected BufferedWriter writer = null;
    protected BufferedReader reader = null;
    protected String newModel;
    protected int modelId;

    public String getNewModel() {
        return newModel;
    }

    public void setNewModel(String newModel) {
        this.newModel = newModel;
    }

    @Override
    public String read() {
        try {
            reader = new BufferedReader(new FileReader(new File(path, model)));
            while (reader.ready()) {
                String line = reader.readLine();
                if (!line.isEmpty()) {

                    if (ExtractId(line) == modelId) {
                        reader.close();
                        return line;
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "";
    }

    @Override
    public boolean write(boolean append) {
        try {
            writer = new BufferedWriter(new FileWriter(new File(path, model), true));
            //((ConsumidorModel)model).setId(buscarUltimoId());
            writer.write(newModel);
            writer.newLine();
            writer.flush();
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public int ExtractId(String lineModel) {
        String[] splited = lineModel.split(",");

        return Integer.parseInt(splited[0]);
    }

    public ArrayList<String> ReadAll() {
        ArrayList<String> results = new ArrayList<String>();

        try {
            reader = new BufferedReader(new FileReader(new File(path, model)));
            while (reader.ready()) {
                String line = reader.readLine();
                if (!line.isEmpty()) {
                    results.add(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return results;
    }

    public boolean remove(int id) {
        try {
            reader = new BufferedReader(new FileReader(new File(path, model)));
            StringBuffer inputBuffer = new StringBuffer();

            while (reader.ready()) {
                String line = reader.readLine();
                String[] splited = line.split(",");

                if (Integer.parseInt(splited[0]) == id) {
                    //Considerando linha encontrada
                } else {
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                }
            }
            reader.close();

            String update = inputBuffer.toString();
            FileOutputStream fileOut = new FileOutputStream(new File(path, model));
            fileOut.write(update.getBytes());
            fileOut.close();
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public boolean Update(int id) {
        try {
            reader = new BufferedReader(new FileReader(new File(path, model)));
            StringBuffer inputBuffer = new StringBuffer();

            while (reader.ready()) {
                String line = reader.readLine();
                String[] splited = line.split(",");

                if (Integer.parseInt(splited[0]) == id) {
                    line = newModel;
                    inputBuffer.append(line);
                    inputBuffer.append("\n");
                }else{
                    inputBuffer.append(line);
                    inputBuffer.append("\n");
                }				
            }
		
            reader.close();

            String update = inputBuffer.toString();
            FileOutputStream fileOut = new FileOutputStream(new File(path,model));
            fileOut.write(update.getBytes());
            fileOut.close();
            return true;
	} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
        return false;
    }
}
