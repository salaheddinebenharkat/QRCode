package org.example.qrcode.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.example.qrcode.models.Person;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {

    public static void generateQRCode(Person person) throws WriterException, IOException {
        String qrCodePath = "C:\\Users\\Administrator\\Desktop\\QRCodes\\";
        String qrCodeName = qrCodePath+person.getFullName()+"-QRCode.png";

        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "ID: "+person.getId()+ "\n"+
                        "FullName: "+person.getFullName()+ "\n"+
                        "Occupation: "+person.getOccupation()+ "\n"+
                        "Email: "+person.getEmail(),
                BarcodeFormat.QR_CODE, 400,400);

        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
