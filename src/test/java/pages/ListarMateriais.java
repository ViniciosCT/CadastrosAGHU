package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListarMateriais {

    private static WebDriver driver;

    public ListarMateriais(WebDriver driver) {
        this.driver = driver;
    }

    public void pesquisar(){
        WebElement botaoPesquisa = driver.findElement( By.id("bt_pesquisar:button") );
        botaoPesquisa.click();
    }

    public void seleciona(Long id) throws Exception{
        WebElement pesquisa = driver.findElement(By.id("codigo:codigo:inputId_input"));
        pesquisa.clear();
        pesquisa.sendKeys( String.valueOf(id) );
        this.pesquisar();
        WebElement editaElemento = driver.findElement(By.id("tabelaMateriais:resultList:0:j_idt284:link"));
        editaElemento.click();
    }

//    private int contaPaginas(int qtdRegistrosPorPagina) {
//        WebElement informacao = driver.findElement(By.xpath("/html/body/form[3]/div/div[1]/div[2]/span[6]"));
//        String informacoes = informacao.getText();
//        String[] dados = informacoes.split(Pattern.quote (" "));
//        int qtdRegistros = Integer.valueOf( dados[5] );
//        double resultadoDivisao = qtdRegistros / qtdRegistrosPorPagina;
//        int qtdPaginas = (int) Math.ceil(resultadoDivisao);
//        return qtdPaginas;
//    }

//    private WebElement encontraElemento(Long id){
//        //conta elementos da tabela
//        WebElement tabela = driver.findElement(
//                By.xpath("/html/body/form[3]/div/div[1]/div[1]/table/tbody") );
//        Collection<WebElement> linhasTabela = tabela.findElements(By.tagName("tr"));
//        for(WebElement linha : linhasTabela){
//            Collection<WebElement> tds = linha.findElements(By.tagName("td"));
//            String idElementoS = ( (WebElement) tds.toArray()[1] ).getText();
//            Long idElemento = Long.valueOf(idElementoS);
//            if( id.equals(idElemento) ){
//                WebElement opcoesLinha = (WebElement) tds.toArray()[0];
//                return (WebElement) opcoesLinha.findElements(By.tagName("a")).toArray()[0];
//            }
//        }
//        return null;
//    }

}
