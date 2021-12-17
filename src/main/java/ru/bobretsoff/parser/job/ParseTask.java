package ru.bobretsoff.parser.job;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.bobretsoff.parser.model.Company;
import ru.bobretsoff.parser.service.CompanyService;

import java.io.*;

/** выполнение парсинга. */
@Component
public class ParseTask {

    /** автоматическая инъекция companyService. */
    @Autowired
    private CompanyService companyService;

    /** выполнение кода по расписанию каждые 10 мин. */
    @Scheduled(fixedDelay = 600000)
    public void parseCompany() {
        String url = "https://finviz.com/screener.ashx?v=111&f=idx_sp500&o=-marketcap";
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Chrome")
                    .timeout(5000)
                    .referrer("https://google.com")
                    .get();

            int k = 0;
            for (int i = 0; i < 20; i++) {
                Element ticker = doc.getElementsByClass("screener-link-primary").get(i);
                Element company = doc.select("a[class=screener-link]").get(i + k + 1);
                Element sector = doc.select("a[class=screener-link]").get(i + k + 2);
                Element industry = doc.select("a[class=screener-link]").get(i + k + 3);

                String vTicker = ticker.ownText();
                String vCompany = company.ownText();
                String vSector = sector.ownText();
                String vIndustry = industry.ownText();

                Document page2 = Jsoup.connect("https://query1.finance.yahoo.com/v8/finance/chart/" + vTicker).ignoreContentType(true).get();
                Element price = page2.body();

                String vPrice = price.toString();
                vPrice = vPrice.substring(vPrice.indexOf("regularMarketPrice") + 20, vPrice.indexOf(",", vPrice.indexOf("regularMarketPrice")));

                Company obj = new Company();
                obj.setTicker(vTicker);
                obj.setCompany(vCompany);
                obj.setSector(vSector);
                obj.setIndustry(vIndustry);
                obj.setPrice(vPrice);

                companyService.save(obj);
                k = k + 9;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
