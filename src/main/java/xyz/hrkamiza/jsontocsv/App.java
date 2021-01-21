package xyz.hrkamiza.jsontocsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
public class App 
{
    public static void main( String[] args )
    {

		// ler arquivo json

		List<CADCliente> logins = lerArquivoJson();

		// gerar csv

		System.out.println("tamano logins: " + logins.size());
		gerarcsv(logins);

	}

	private static void gerarcsv(List<CADCliente> logins) {
		Workbook workbook = new XSSFWorkbook();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		Sheet sheet = workbook.createSheet("RegistroLogin" + sdf.format(new Date()));
		sheet.setColumnWidth(0, 4000);
		sheet.setColumnWidth(1, 4000);
		sheet.setColumnWidth(2, 3000);
		sheet.setColumnWidth(3, 5000);
		sheet.setColumnWidth(4, 1000);
		sheet.setColumnWidth(5, 4000);
		sheet.setColumnWidth(6, 3000);
		sheet.setColumnWidth(7, 4000);
		sheet.setColumnWidth(8, 4000);

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
		String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";

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

		int linha = 2;

		for (cadcliente login : cadclientes) {

			if (linha %10000==0) {

				System.out.println("Gerando linha: " + linha);
			}
			Row row = sheet.createRow(linha++);
			Cell cell = row.createCell(0);
			cell.setCellValue(login.getItem().getClienteIP().getS());
			cell.setCellStyle(style);

			cell = row.createCell(1);
			cell.setCellValue(login.getItem().getClienteMAC().getS());
			cell.setCellStyle(style);

			cell = row.createCell(2);
			cell.setCellValue(login.getItem().getCpf().getN());
			cell.setCellStyle(style);

			cell = row.createCell(3);
			cell.setCellValue(login.getItem().getDataRegistro().getS());
			cell.setCellStyle(style);

			cell = row.createCell(4);
			cell.setCellValue(login.getItem().getDuracaoSessao().getN());
			cell.setCellStyle(style);

			cell = row.createCell(5);
			cell.setCellValue(login.getItem().getGatewayID().getN());
			cell.setCellStyle(style);

			cell = row.createCell(6);
			cell.setCellValue(login.getItem().getLoja().getN());
			cell.setCellStyle(style);

			cell = row.createCell(7);
			cell.setCellValue(login.getItem().getNodeID().getN());
			cell.setCellStyle(style);

			cell = row.createCell(8);
			cell.setCellValue(login.getItem().getNodeMAC().getS());
			cell.setCellStyle(style);

		}
		System.out.println("Lista executara");
	}

	private static void criaHeader(Row header, CellStyle headerStyle) {

		String[] headers = { "clienteIp", "clienteMac", "cpf", "dataRegistro", "duracaoSessao", "gatewayId", "loja",
				"nodeId", "nodeMac" };

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
    }
}
