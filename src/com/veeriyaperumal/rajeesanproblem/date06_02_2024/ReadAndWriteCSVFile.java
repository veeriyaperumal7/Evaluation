package com.veeriyaperumal.rajeesanproblem.date06_02_2024;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class Stock {
	String name;
	float price;

	public Stock(String name, float price) {
		this.name = name;
		this.price = price;
	}
}

public class ReadAndWriteCSVFile {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader(
				"D:\\zsgsworkspace\\evaluation\\src\\com\\veeriyaperumal\\rajeesanproblem\\date06_02_2024\\Stock Price.txt");
		int val;
		StringBuilder sb = new StringBuilder();
		while ((val = fr.read()) != -1) {
			sb.append((char) val);
		}
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		String arr[] = sb.toString().split(",");
		for (int i = 0; i < arr.length; i += 2) {
			Stock stock = new Stock(arr[i], Float.parseFloat(arr[i + 1]));
			stocks.add(stock);
		}

		Collections.sort(stocks, new Comparator<Stock>() {
			@Override
			public int compare(Stock o1, Stock o2) {
				return (int) (o1.price - o2.price);
			}

		});
		System.out.flush();
		FileWriter fw = new FileWriter("StockList1.txt");
		for (Stock s : stocks) {
			fw.write(s.name + "," + String.valueOf(s.price) + "\n");
		}
		fw.close();

	}
}
