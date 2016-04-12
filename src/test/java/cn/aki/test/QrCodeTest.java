package cn.aki.test;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
/**
 * 二维码
 * @author aki
 * 2016年4月11日 上午10:27:56
 */
public class QrCodeTest {
	/**
	 * 生成二维码
	 */
	@Test
	public void testEncode(){
		String targetPath="D:/qdcode.png";
		String contents="http://www.baidu.com/中文";
		int width=200;
		int height=200;
		OutputStream os=null;
		//额外参数(可选)
		Map<EncodeHintType, Object> hints=new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.MARGIN, 1);
		try {
			//生成二维码
			BitMatrix matrix=new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
			//二维码保存为图片
			os = new FileOutputStream(targetPath);
			//二维码颜色(可选)
			MatrixToImageConfig config=new MatrixToImageConfig(MatrixToImageConfig.BLACK, MatrixToImageConfig.WHITE);
			MatrixToImageWriter.writeToStream(matrix, "png", os, config);
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 扫描二维码
	 */
	@Test
	public void testDecode(){
		String sourcePath="D:/qdcode.png";
		InputStream is=null;
		try {
			is=new FileInputStream(sourcePath);
			BufferedImage image = ImageIO.read(is);
			LuminanceSource source=new BufferedImageLuminanceSource(image);
			Binarizer binarizer=new HybridBinarizer(source);
			BinaryBitmap bitmap=new BinaryBitmap(binarizer);
			//额外参数(可选)
			Map<DecodeHintType, Object> hints=new HashMap<DecodeHintType, Object>();
			hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
			Result result=new MultiFormatReader().decode(bitmap, hints);
			System.err.println(result.getText());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		} finally {
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
