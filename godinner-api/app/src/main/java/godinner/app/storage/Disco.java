package godinner.app.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import godinner.app.helper.Date;
import net.bytebuddy.asm.Advice.This;

@Component
public class Disco {

<<<<<<< HEAD
	private String teste = "batatinha";
	
	private String raiz = "C:\\Users\\18175241";
=======
	@Value("${contato.disco.raiz}")
	public String raiz;
>>>>>>> ad20a94a4d02f1f1b49dcc460f9cb1f2d3934491

	@Value("${contato.disco.diretorio-fotos}")
	private String diretorioFotos;
	
	
	

	public String salvarFoto(MultipartFile foto, String pasta) {
		return this.salvar(this.diretorioFotos + "/" + pasta, foto);
	}

	public String salvar(String diretorio, MultipartFile arquivo) {
		String local = null;
		String caminhoCompleto = null;
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		
		System.out.println("---------------->" + this.raiz);

		Date data = new Date();
		local = (String) (data.getData() + "-" + arquivo.getOriginalFilename());

		Path arquivoPath = diretorioPath.resolve(local);

		try {

			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());
			caminhoCompleto = (raiz + "/" + diretorio + "/" + local);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return caminhoCompleto;
	}

	public boolean deleteFoto(String foto) {
		File f = new File(raiz + "/" + this.diretorioFotos + foto);
		return f.delete();
	}
<<<<<<< HEAD
	
	
	
	
	public void escreverArquivo(String arquivo, String dominio) {
		
    	
	//String  caminhoPasta = "C:\\Users\\18175241\\pages\\" + dominio + "\\public_html";
	String  caminhoPasta = this.raiz + "\\pages\\" + dominio + "\\public_html";
	
	System.out.println(this.raiz);


   	 File pasta = new File(caminhoPasta);
   	 
   	 //CRIA A PASTA
      Boolean pastaRestaurante = pasta.mkdirs();
        
    
   	 //VERIFICA SE A PASTA EXISTE    	 
   	 if (pastaRestaurante) { 
   		 
   		  //ESCREVE NO ARQUIVO
   		 String tempFile = caminhoPasta +"/index.html";
          File file = new File(tempFile);
         
          
            OutputStream outputStream;
			try {
				outputStream = new FileOutputStream(file.getAbsoluteFile()); 
				Writer writer=new OutputStreamWriter(outputStream);
				writer.write(arquivo);
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
   		  
            System.out.println("Pasta criada"); 
          
           
           
        } 
        else { 
           
            System.out.println("Pasta já existe"); 
            
            
        } 
		
=======

	public void escreverArquivo(String arquivo, String dominio) {		

		String caminhoPasta = "C:\\Users\\Marina\\Documents\\pages\\" + dominio + "\\public_html";
>>>>>>> ad20a94a4d02f1f1b49dcc460f9cb1f2d3934491
		

		File pasta = new File(caminhoPasta);

		// CRIA A PASTA
		Boolean pastaRestaurante = pasta.mkdirs();

		// VERIFICA SE A PASTA EXISTE
		if (pastaRestaurante) {

			// ESCREVE NO ARQUIVO
			String tempFile = caminhoPasta + "/index.html";
			File file = new File(tempFile);

			OutputStream outputStream;
			try {
				outputStream = new FileOutputStream(file.getAbsoluteFile());
				Writer writer = new OutputStreamWriter(outputStream);
				writer.write(arquivo);
				writer.close();

				System.out.println("Pasta criada");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			System.out.println("Pasta já existe");

		}

	}

}
