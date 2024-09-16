import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = {"/ImprimeEntrada"}
)
public class ImprimeEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public ImprimeEntrada() {
        super();
    }


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cantDias = request.getParameter("dias");

		if (cantDias.equals("2")) {
			int abonos2dias = Integer.parseInt((String) getServletContext().getAttribute("Abonos2Dias")) ;
			if (abonos2dias > 0) {
				abonos2dias = abonos2dias - 1;
				String a = String.valueOf(abonos2dias);
				getServletContext().setAttribute("Abonos2Dias", a);
			}
		}else if (cantDias.equals("3")){
			int abonos3dias = Integer.parseInt((String) getServletContext().getAttribute("Abonos3Dias"));
			if (abonos3dias > 0) {
				abonos3dias = abonos3dias - 1;
				String a = String.valueOf(abonos3dias);
				getServletContext().setAttribute("Abonos3Dias", a);
			}
		}


		OutputStream outputStream = response.getOutputStream();
		// Crear Imagen
		BufferedImage image = new BufferedImage(1500, 1500, BufferedImage.TYPE_INT_BGR);
		Graphics2D graphics = image.createGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, 1500, 1500);
		BufferedImage img = ImageIO.read(this.getServletContext().getResourceAsStream("/WEB-INF/img/logo.jpg"));
		int logoX = (1500 - img.getWidth());
		graphics.drawImage(img, logoX, 0, null);
		//Crear QR
		BufferedImage qr = generarQR(ganoPremio(request));
		int qrX = (1500 - 400) / 2; // QR size is 400x400, center it horizontally
		int qrY = 600; // Position it at the bottom part of the image
		graphics.drawImage(qr, qrX, qrY, 400, 400, null); // Set size to 400x400

		// Write the image as JPEG and close the output stream
		ImageIO.write(image, "jpeg", outputStream);
		outputStream.close();

	}

	private String ganoPremio(HttpServletRequest request) {
		String texto = "Entrada para " + request.getParameter("nombre") + request.getParameter("apellido") + " dni "
				+ request.getParameter("dni");
		if ((Math.random() * 100 + 1) > 50) {
			texto = texto
					+ "¡Felicitaciones! Te ganaste una remera. El día del evento pasá por el Stand TTPS y retirala con el QR";
		} else {
			texto = texto + "No te ganaste una remera, pero esperamos disfrutes mucho el show";
		}

		return texto;
	}


	private BufferedImage generarQR(String texto) {
		QRCodeWriter writer = new QRCodeWriter();
		try {
			BitMatrix bit = ((com.google.zxing.Writer) writer).encode(texto, BarcodeFormat.QR_CODE, 400, 400);
			return MatrixToImageWriter.toBufferedImage(bit);
		} catch (WriterException e) {
			return null;
		}
	}

}
