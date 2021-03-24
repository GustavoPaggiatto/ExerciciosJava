/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmltwojson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class XmlTwoJson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("*************** XML 2 JSON ***************");

        if (args == null || args.length == 0) {
            System.out.println("Informe um caminho de arquivo válido...");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(XmlTwoJson.class.getName()).log(Level.SEVERE, null, ex);
            }

            return;
        }

        File entry = new File(args[0]);

        if (!entry.exists()) {
            System.out.println("Arquivo inexistente, verifique...");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(XmlTwoJson.class.getName()).log(Level.SEVERE, null, ex);
            }

            return;
        }

        List<String> lines = null;
        System.out.println("Lendo o arquivo...");

        try {
            lines = readFile(entry);
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro durante a leitura do arquivo. "
                    + "Isso é comum em permissões de pastas, arquivo em uso etc...");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Logger.getLogger(XmlTwoJson.class.getName()).log(Level.SEVERE, null, e);
            }

            return;
        }

        //call stack resolver method bellow...
        System.out.println("Formatando XML na memória (em objeto)...");
        String json = null;

        try {
            String total = "";

            for (String line : lines) {
                total += line.trim();
            }

            System.out.println("Efetuando o parser para JSON...");

            XmlParser xmlParser = new XmlParser();
            XmlElement root = xmlParser.parse(total);
            JsonWriter wJson = new JsonWriter();

            json = wJson.convert(root);
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro durante o carregamento do XML em objeto interno...");
        }

        if (json != null) {
            try {
                writeFile(json, args[0]);
            } catch (Exception ex) {
                System.out.println("Ocorreu um erro durante a escrita do arquivo. "
                        + "Isso é comum com permissões inválidas etc...");
            }
        }

        System.out.println("Finalizando processamento...");
        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
            //nothing...
        }
    }

    private static List<String> readFile(File file) throws FileNotFoundException {
        Scanner reader = null;

        try {
            reader = new Scanner(file);
            List<String> result = new ArrayList<String>();

            while (reader.hasNextLine()) {
                result.add(reader.nextLine());
            }

            return result;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    private static void writeFile(String json, String path) throws IOException {
        String[] pathParts = path.split("\\\\");
        String newPath = "";

        for (int i = 0; i < pathParts.length - 1; i++) {
            newPath += pathParts[i] + "\\";
        }

        newPath += "out.txt";

        FileWriter writer = new FileWriter(newPath);

        writer.write(json);
        writer.flush();
        writer.close();
    }
}
