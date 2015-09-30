package excelaccess;

import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import classes.*;
import data.*;

public class ExcelAccess {
	
	static XSSFSheet sheets[] = new XSSFSheet[3];
	
	public static void loadSheets(){
		
        try {
        	
        	System.out.println("Acessando o servidor...");
        	
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("\\\\DLINK-275271\\Volume_1\\HYPERION\\TI\\Projeto Adiantamentos\\Cadastro.xlsm"));
            
           // 0 = planilha de Clientes; 1 = planilha de Empreendimentos; 2 = planilha de Colaboradores (Listas)
            
            sheets[0] = workbook.getSheetAt(1);
            sheets[1] = workbook.getSheetAt(3);
            
            workbook.close();
            
            workbook = new XSSFWorkbook(new FileInputStream("\\\\DLINK-275271\\Volume_1\\HYPERION\\TI\\Projeto Adiantamentos\\Listas.xlsx"));
            
            sheets[2] = workbook.getSheetAt(0);
            
            workbook.close();

            System.out.println("Planilhas carregadas...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void loadDados() {
		System.out.println("Carregando dados...");
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Empreendimento> empreendimentos = new ArrayList<Empreendimento>();
		ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
		
		loadSheets();
		
		// Alocando Clientes
		
		int i = 4;
		Row atual = sheets[0].getRow(i);
		while(!atual.getCell(2).getStringCellValue().equals("")){
			Cliente c = new Cliente(atual.getCell(2).getStringCellValue(),
									atual.getCell(3).getStringCellValue());
			clientes.add(c);
			i++;
			atual = sheets[0].getRow(i);
		}

		// Alocando Empreendimentos
		i = 4;
		atual = sheets[1].getRow(i);
		while(!atual.getCell(2).getStringCellValue().equals("")){
			Empreendimento e = new Empreendimento(atual.getCell(2).getStringCellValue(),
												  atual.getCell(3).getStringCellValue());
			empreendimentos.add(e);
			i++;
			atual = sheets[1].getRow(i);
		}
		
		// Alocando Colaboradores		
		i = 3;
		atual = sheets[2].getRow(3);
		while(!atual.getCell(30).getStringCellValue().equals("")){
			Colaborador c = new Colaborador(atual.getCell(30).getStringCellValue(),
											atual.getCell(31).getStringCellValue());
			colaboradores.add(c);
			i++;
			atual = sheets[2].getRow(i);
		}
		
		
		
		Data.clientes = clientes;
		Data.empreendimentos = empreendimentos;
		Data.colaboradores = colaboradores;
		
		System.out.println("Dados carregados...");
			
	}
	
}
