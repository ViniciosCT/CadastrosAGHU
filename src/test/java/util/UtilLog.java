package util;

import model.Log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UtilLog {

    public void geraLog(Log log){

        String logString = "Codigo: " + log.getDado().getId() + " \t " +
                "Data: " + log.getData() + " \t " +
                "Mensagem: " + log.getMensagem();
        System.out.println(logString);

        try {
            FileWriter arq = new FileWriter("log.txt", true);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println( logString );
            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
