import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {

    // 1-January-2000 22-February-2000 Monday
    static class Stock {
        String date;
        double open;
        double high;
        double low;
        double close;
    }

    static class Stocks {
        int page;
        int per_page;
        int total;
        int total_pages;
        List<Stock> data;
    }

    enum Days {
        Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
    }

    static void openAndClosePrices(String firstDate, String lastDate, String weekDay) {
        List<Stock> updatedStocks = Collections.emptyList();
        try {
            updatedStocks = readAllPages();
            selectStocksPerCriteria(firstDate, lastDate, weekDay, updatedStocks);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void selectStocksPerCriteria(String firstDate,
            String lastDate,
            String weekDay,
            List<Stock> updatedStocks
    ) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        Date firstParsedDate = formatter.parse(firstDate);
        Date lastParsedDate = formatter.parse(lastDate);
        Boolean first = true;
        for (Stock stock : updatedStocks) {
            Date stockDate = formatter.parse(stock.date);
            if (checkDate(stockDate, firstParsedDate, lastParsedDate) && checkDay(weekDay, stockDate)) {
                if (first) {
                    printStockInfo(stock, false);
                    first = false;
                } else {
                    printStockInfo(stock, true);
                }
            }
        }
    }

    private static Boolean checkDate(Date stockDate, Date firstDate, Date lastDate) {
        return (stockDate.compareTo(firstDate) >= 0) && (stockDate.compareTo(lastDate) <= 0);
    }

    private static Boolean checkDay(String weekDay, Date stockDate) {
        int day = stockDate.getDay();
        int ordinal = Days.valueOf(weekDay).ordinal();
        return day == ordinal;
    }

    private static void printStockInfo(Stock stock, Boolean newLine) {
        if (newLine) {
            System.out.println();
            System.out.print(stock.date + " " + stock.open + " " + stock.close);
        } else {
            System.out.print(stock.date + " " + stock.open + " " + stock.close);
        }
    }

    /**
     * Update Stocks class with all stocks after pagination
     *
     * @throws Exception
     */
    private static List<Stock> readAllPages() throws Exception {
        int pageNumber = 1;
        // initial API hit
        String json = readUrl("https://jsonmock.hackerrank.com/api/stocks?page=" + pageNumber);
        Gson gson = new Gson();
        Stocks stocks = gson.fromJson(json, Stocks.class);

        while (pageNumber < stocks.total_pages) {
            ++pageNumber;
            String jsonPerPage = readUrl("https://jsonmock.hackerrank.com/api/stocks?page=" + pageNumber);
            Stocks tempStocks = gson.fromJson(jsonPerPage, Stocks.class);
            stocks.data.addAll(tempStocks.data);
        }
        return stocks.data;
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String _firstDate;
        try {
            _firstDate = in.nextLine();
        } catch (Exception e) {
            _firstDate = null;
        }

        String _lastDate;
        try {
            _lastDate = in.nextLine();
        } catch (Exception e) {
            _lastDate = null;
        }

        String _weekDay;
        try {
            _weekDay = in.nextLine();
        } catch (Exception e) {
            _weekDay = null;
        }

        openAndClosePrices(_firstDate, _lastDate, _weekDay);

    }
}