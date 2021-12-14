package ru.bobretsoff.parser.job;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.bobretsoff.parser.model.Company;
import ru.bobretsoff.parser.service.CompanyService;

import javax.xml.crypto.Data;
import java.io.*;

@Component
public class ParseTask {

    @Autowired
    CompanyService companyService;
    private Data data;

    @Scheduled(fixedDelay = 10000)
    public void ParseCompany(){
        String url="https://finviz.com/screener.ashx?v=111&f=idx_sp500&o=-marketcap";
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Chrome")
                    .timeout(5000)
                    .referrer("https://google.com")
                    .get();

            int k=0;
            for (int i = 0; i < 20; i++){
                Element ticker = doc.getElementsByClass("screener-link-primary").get(i);
                Element company = doc.select("a[class=screener-link]").get(i+k+1);
                Element sector = doc.select("a[class=screener-link]").get(i+k+2);
                Element industry = doc.select("a[class=screener-link]").get(i+k+3);

                String Ticker = ticker.ownText();
                String Company = company.ownText();
                String Sector = sector.ownText();
                String Industry = industry.ownText();

                Document page2 = Jsoup.connect("https://query1.finance.yahoo.com/v8/finance/chart/"+Ticker).ignoreContentType(true).get();
                Element price = page2.body();

                String Price = price.toString();
                Price = Price.substring(Price.indexOf("regularMarketPrice")+20,Price.indexOf(",",Price.indexOf("regularMarketPrice")));

                Company obj = new Company();
                obj.setTicker(Ticker);
                obj.setCompany(Company);
                obj.setSector(Sector);
                obj.setIndustry(Industry);
                obj.setPrice(Price);

                companyService.save(obj);
                k=k+9;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
