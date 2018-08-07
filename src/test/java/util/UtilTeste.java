package util;

import model.Dado;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

import static pages.Login.setLinhaLogin;

public class UtilTeste {

    private static Collection<Dado> dados = new ArrayList<Dado>();

    public static Dado getProximoDado() {
        if(dados.isEmpty() || dados == null){
            carregaDados();
        }
        if (dados.size() != 0){
            Dado dado = (Dado) dados.toArray()[0];
            dados.remove(dado);
            return dado;
        }else{
            return null;
        }
    }

    public static void carregaDados(){
        try {

            JFileChooser fc = new JFileChooser();
            int escolha = fc.showOpenDialog(new JFrame());
            if (escolha != JFileChooser.APPROVE_OPTION){
                return;
            }

            BufferedReader br = new BufferedReader( new FileReader(fc.getSelectedFile().getAbsolutePath()) );
            int i = 0;
            while(br.ready()){
                String linha = br.readLine();
                if(i==0){
                    setLinhaLogin(linha);
                    i++;
                }else {
                    Dado dado = linhaParaDado(linha);
                    dados.add(dado);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Dado linhaParaDado(String linha) {
        Dado dado = new Dado();
        String[] dados = linha.split(Pattern.quote ("|"));
        boolean checked;
        if(dados[1].equals("y")){
            checked = true;
            String temperatura = dados[2];
            Long id = Long.valueOf( dados[0] );
            dado.setTemperatura(temperatura);
            dado.setId(id);
        }else if(dados[1].equals("n")){
            Long id = Long.valueOf( dados[0] );
            dado.setId( id );
            checked = false;
        }else{
            checked = false;
            System.out.println(" >> [Dado errado no arquivo] << ");
        }
        dado.setChecked(checked);
        return dado;
    }

    public static int getQtdDados(){
        if(dados.isEmpty() || dados == null){
            carregaDados();
        }
        return dados.size();
    }

}
