package pdf;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import javax.servlet.http.HttpServletRequest;

import entidade.Cliente;
import entidade.Endereco;
import entidade.Orcamento;
import entidade.Telefone;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class GeradorPdf {

	public static void gerar(List<Orcamento> o,String caminho) throws JRException{
		try {
			
		
			InputStream fonte = GeradorPdf.class.getResourceAsStream("/report/orcamento.jrxml");
			JasperReport report = JasperCompileManager.compileReport(fonte);
			JRDataSource dsComponente = new JRBeanCollectionDataSource(o);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("componentes", dsComponente);
			
			for (Orcamento orcamento : o) {
				
			
			
			JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(o));
			
			// Define o caminho(pasta) local do PC
			final String caminhoPDF = System.getenv("USERPROFILE") + File.separator + "documents" + File.separator + "hidemiPhone" + File.separator + "Orçamentos";
			
			// Cria a pasta
			//String arquivo = "mkdir " + caminhoPDF;
			try {
				File f = new File(caminhoPDF);
				if(!f.exists()) {
					f.mkdirs();
				//Runtime.getRuntime().exec("cmd /c" + arquivo);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			JasperExportManager.exportReportToPdfFile(print, caminhoPDF + "/orcamento-" + orcamento.getCliente().getNome().replace(" ", "-")+ "-" + new SimpleDateFormat("dd-MM-yyyy").format(new Date())+".pdf");
			//JasperViewer.viewReport(print,false);
			System.out.println("gerado em: "+caminhoPDF);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erro: " + e.getMessage());
			
		}
	}

}