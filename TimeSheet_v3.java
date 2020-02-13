import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TimeSheet_v3 {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Informa endereço do WebDriver do Selenium:
        System.setProperty("webdriver.chrome.driver", "C:/TEMP/WebDriver/Chrome/chromedriver.exe");
        // Abre navegador Chrome:
        WebDriver pagina = new ChromeDriver();
        // Informa endereço que deve ser carregado:
        pagina.get("https://ps2010.dbserver.com.br/pwa/timesheet.aspx");
        // Efetua a autenticação de proxy para endereços externos:
        Runtime.getRuntime().exec("C:\\Temp\\ProxyAuthentication\\TimeSheetAuthentication.exe");
        // Maximiza janela do navegador:
        pagina.manage().window().maximize();
        TimeUnit.SECONDS.sleep(5);


        // Artifício de espera no Selenium:
        WebDriverWait wait = new WebDriverWait(pagina, 30);


//        // Aguarda botão "Próxima semna" estar disponível pra clique:
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("Ribbon.ContextualTabs.TiedMode.Home.Period.NextPeriod-Large")));
//        TimeUnit.SECONDS.sleep(6);
//
//        // Pesquisa elemento na página e realiza clique para próximo período:
//        pagina.findElement(By.id("Ribbon.ContextualTabs.TiedMode.Home.Period.NextPeriod-Large")).click();


        // Laço para percorrer Semana:
        for (int PercorreSemana = 0; PercorreSemana < 5; PercorreSemana++) {

            // Cria array Dias da Semana:
            String[] diasDaSemana = new String [5];

            // Array Dias da Semana:
            diasDaSemana[0] = "Segunda-feira";
            diasDaSemana[1] = "Terça-feira";
            diasDaSemana[2] = "Quarta-feira";
            diasDaSemana[3] = "Quinta-feira";
            diasDaSemana[4] = "Sexta-feira";

            // Imprime array Dias da Semana:
            System.out.println(">>> Preenchendo " +diasDaSemana[PercorreSemana] +" <<<");

            // Cria array b=Box da Semana:
            String[] boxDaSemana = new String [5];

            boxDaSemana[0] = "/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div/div[2]/div[3]/div[1]/table[2]/tbody/tr[2]/td[2]";
            boxDaSemana[1] = "/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div/div[2]/div[3]/div[1]/table[2]/tbody/tr[2]/td[3]";
            boxDaSemana[2] = "/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div/div[2]/div[3]/div[1]/table[2]/tbody/tr[2]/td[4]";
            boxDaSemana[3] = "/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div/div[2]/div[3]/div[1]/table[2]/tbody/tr[2]/td[5]";
            boxDaSemana[4] = "/html/body/form/div[8]/div/div[3]/div[2]/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div/div[2]/div[3]/div[1]/table[2]/tbody/tr[2]/td[6]";

            // Aguarda elemento box carregar
            WebElement segunda = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(boxDaSemana[PercorreSemana])));

            // Efetua o clique no box da semana - td[x]):
            pagina.findElement(By.xpath(boxDaSemana[PercorreSemana])).click();

            // Cria array para selecionar iFrame:
            String[] SelecionaIframe = new String [5];

            SelecionaIframe[0] = "/html/body/div[3]/div/div[2]/iframe[starts-with(@id,'DlgFrame')]";
            SelecionaIframe[1] = "/html/body/div[4]/div/div[2]/iframe[starts-with(@id,'DlgFrame')]";
            SelecionaIframe[2] = "/html/body/div[4]/div/div[2]/iframe[starts-with(@id,'DlgFrame')]";
            SelecionaIframe[3] = "/html/body/div[4]/div/div[2]/iframe[starts-with(@id,'DlgFrame')]";
            SelecionaIframe[4] = "/html/body/div[4]/div/div[2]/iframe[starts-with(@id,'DlgFrame')]";

            // Alterna da página para o iframe:
            new WebDriverWait(pagina, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(SelecionaIframe[PercorreSemana])));
            System.out.println("   (x) iFrame de " +diasDaSemana[PercorreSemana]);
            TimeUnit.SECONDS.sleep(6);

            // Laço para percorrer período de preenchimento de horas:
            for (int PercorrePeriodo = 1; PercorrePeriodo <3; PercorrePeriodo++) {

                switch (PercorrePeriodo){

                    // Preenche horário da manhã:
                    case 1:
                        //Localiza e preenche horário inicial:
                        WebElement horainicialsegunda= pagina.findElement(By.id("ctl00_PlaceHolderMain_HoraInicio"));
                        horainicialsegunda.click();
                        horainicialsegunda.sendKeys("0800");

                        // Localiza e preenche horário final:
                        WebElement horafinalsegunda= pagina.findElement(By.id("ctl00_PlaceHolderMain_HoraTermino"));
                        horafinalsegunda.click();
                        horafinalsegunda.sendKeys("1200");

                        // Clica no botão adicionar período:
                        pagina.findElement(By.id("ctl00_PlaceHolderMain_SalvarPeriodo")).click();
                        TimeUnit.SECONDS.sleep(3);

                        break;

                    // Preeenche horário da tarde:
                    case 2:
                        // Localiza e preenche horário inicial:
                        WebElement horainicialsegunda2= pagina.findElement(By.id("ctl00_PlaceHolderMain_HoraInicio"));
                        horainicialsegunda2.click();
                        horainicialsegunda2.sendKeys("1300");

                        // Localiza e preenche horário final:
                        WebElement horafinalsegunda2= pagina.findElement(By.id("ctl00_PlaceHolderMain_HoraTermino"));
                        horafinalsegunda2.click();
                        horafinalsegunda2.sendKeys("1700");

                        //Clica no botão adicionar período:
                        pagina.findElement(By.id("ctl00_PlaceHolderMain_SalvarPeriodo")).click();
                        TimeUnit.SECONDS.sleep(3);
                        break;
                } // FIM switch PercorrePeriodo.
            } // FIM laço PercorrePeriodo.

            //Clica no botão "OK":
            pagina.findElement(By.id("ctl00_PlaceHolderMain_Confirmar")).click();
            TimeUnit.SECONDS.sleep(6);

        } //FIM laço PercorreSemana.

        System.out.println("Períodos cadastrados com sucesso!");
        System.out.println("   ");

        // Mensagem e fechamento da janela:
        System.out.println("==================");
        System.out.println("Fechando janela...");
        System.out.println("==================");
        System.out.println("   ");

        for (int TimerFechaJanela = 10; TimerFechaJanela >0; TimerFechaJanela--) {

            System.out.println("Tempo restante: " +TimerFechaJanela);
            TimeUnit.SECONDS.sleep(01);
        }

        // Sair do WebDriver:
        //pagina.quit();
    }
}
