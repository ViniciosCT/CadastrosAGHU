package teste;

import model.Dado;
import model.Log;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.EditarMaterial;
import pages.Inicio;
import pages.ListarMateriais;
import pages.Login;
import util.UtilLog;

import java.util.Date;

import static util.UtilTeste.carregaDados;
import static util.UtilTeste.getProximoDado;
import static util.UtilTeste.getQtdDados;

public class CadastrarMateriais {

    static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\vinicios.tomazetti\\Documents\\Projetos\\Cadastro\\Selenio\\geckodriver-v0.20.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://10.60.1.20:8080/stg-aghu/pages/casca/casca.xhtml");
    }

    @Test
    public void test() throws InterruptedException {
        carregaDados();

        Login login = new Login(driver);
        login.logar();

        Inicio inicio = new Inicio(driver);
        driver = inicio.selecionaListMateriais();

        Thread.sleep(4000);
        ListarMateriais listarMateriais = new ListarMateriais(driver);
        listarMateriais.pesquisar();

        int qtdDados = getQtdDados();
        for(int i = 0; i < qtdDados; i++) {
            Dado dado = getProximoDado();

            String mensagem;
            try {
                listarMateriais.seleciona(dado.getId());
                EditarMaterial editarMaterial = new EditarMaterial(driver);
                if (dado.isChecked()) {
                    editarMaterial.checkTermolabil();
                    editarMaterial.setTemperatura(dado.getTemperatura());
                } else {
                    editarMaterial.notCheckTermolabil();
                }
                mensagem = editarMaterial.finalizar();
            }catch (Exception ex) {
                mensagem = "[Erro: Código não encontrado!]";
            }
            Log log = new Log();
            log.setMensagem(mensagem);
            log.setDado(dado);
            log.setData(new Date());
            UtilLog utilLog = new UtilLog();
            utilLog.geraLog(log);
        }
    }

    @AfterClass
    public static void tearDownAfterClass() {
        String mensagem = "[Processo de edicao dos materiais finalizado] \n";

        Log log = new Log();
        log.setMensagem(mensagem);
        log.setDado(new Dado());
        log.setData(new Date());
        UtilLog utilLog = new UtilLog();
        utilLog.geraLog(log);

        driver.close();
    }

}
