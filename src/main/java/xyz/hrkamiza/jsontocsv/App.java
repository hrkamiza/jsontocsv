package xyz.hrkamiza.jsontocsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// ler arquivo json

		List<CADCliente> cadcliente = lerArquivoJson();

		// gerar csv

		System.out.println("tamanho: " + cadcliente.size());
		gerarcsv(cadcliente);

	}

	private static void gerarcsv(List<CADCliente> logins) {
		Workbook workbook = new XSSFWorkbook();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		Sheet sheet = workbook.createSheet("CadRegistro" + sdf.format(new Date()));
		sheet.setColumnWidth(0, 3000);
		sheet.setColumnWidth(1, 3000);
		sheet.setColumnWidth(2, 3000);
		sheet.setColumnWidth(3, 5000);
		sheet.setColumnWidth(4, 5000);
		sheet.setColumnWidth(5, 3000);

		Row header = sheet.createRow(0);

		CellStyle headerStyle = workbook.createCellStyle();

		XSSFFont font = ((XSSFWorkbook) workbook).createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 16);
		font.setBold(true);
		headerStyle.setFont(font);

		criaHeader(header, headerStyle);

		criarlista(logins, workbook, sheet);

		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		String fileLocation = path.substring(0, path.length() - 1) + "CadWifiCli2020.xlsx";

		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(fileLocation);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

	}

	private static void criarlista(List<CADCliente> cadclientes, Workbook workbook, Sheet sheet) {
		CellStyle style = workbook.createCellStyle();
		style.setWrapText(true);

		int linha = 1;

		for (CADCliente cadcliente : cadclientes) {

			if (linha % 10000 == 0) {

				System.out.println("Gerando linha: " + linha);
			}
			Row row = sheet.createRow(linha++);
			Cell cell = row.createCell(0);
			cell.setCellValue(cadcliente.getItem().getCpf().getN());
			cell.setCellStyle(style);

			cell = row.createCell(1);
			cell.setCellValue(dateConverter(cadcliente.getItem().getDataCadastroCliente().getS()));
			cell.setCellStyle(style);

			cell = row.createCell(2);
			cell.setCellValue(cadcliente.getItem().getDataNascimento().getS());
			cell.setCellStyle(style);

			cell = row.createCell(3);
			if (cadcliente.getItem().getEmail() != null) {
				cell.setCellValue(cadcliente.getItem().getEmail().getS());

			} else {
				cell.setCellValue("N/A");
			}
			cell.setCellStyle(style);

			cell = row.createCell(4);
			cell.setCellValue(cadcliente.getItem().getNome().getS());
			cell.setCellStyle(style);

			cell = row.createCell(5);
			if (cadcliente.getItem().getNumeroCelular() != null) {
				cell.setCellValue(cadcliente.getItem().getNumeroCelular().getN());

			} else {
				cell.setCellValue("N/A");
			}

			cell.setCellStyle(style);

		}
		System.out.println("Lista executada");
	}

	private static void criaHeader(Row header, CellStyle headerStyle) {

		String[] headers = { "cpf", "dataCadastroCliente", "dataNascimento", "email", "nome", "numeroCelular" };

		for (int i = 0; i < headers.length; i++) {

			Cell headerCell = header.createCell(i);
			headerCell.setCellValue(headers[i]);
			headerCell.setCellStyle(headerStyle);

		}

	}

	private static List<CADCliente> lerArquivoJson() {

		// LER ARQUIVO (ffcewlfzpaztfjqjaevk5x236y.json)

		List<CADCliente> cadclientes = new ArrayList<CADCliente>();

		// for nos arquivos teerminados em .json

		BufferedReader br;
		try {
			Gson gson = new Gson();

			File[] files = new File(".//").listFiles(new FileFilter() {
				public boolean accept(File pathname) {
					return pathname.getName().endsWith(".json");
				}
			});

			for (File file : files) {
				System.out.println("Lendo arquivo: " + file.getName());
				br = new BufferedReader(new FileReader(file));
				while (br.ready()) {

					String linha = br.readLine();

					CADCliente cadcliente = gson.fromJson(linha, CADCliente.class);

					cadclientes.add(cadcliente);
//					System.out.println(login);

				}
				br.close();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cadclientes;

	}

	public static String dateConverter(String strDate) {
		java.util.Date date = Date.from(Instant.parse(strDate));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}
}
