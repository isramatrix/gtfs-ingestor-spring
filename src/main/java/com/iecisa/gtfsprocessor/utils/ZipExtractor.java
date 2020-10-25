package com.iecisa.gtfsprocessor.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipExtractor
{
    public List<File> extract(String zipPath, String unzippingPath) throws IOException
    {
        byte[] buffer = new byte[1024];

        File folder = new File(unzippingPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipPath))) {
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                String nombreArchivo = ze.getName();
                File archivoNuevo = new File(unzippingPath + nombreArchivo);
                new File(archivoNuevo.getParent()).mkdirs();
                try (FileOutputStream fos = new FileOutputStream(archivoNuevo)) {
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
                ze = zis.getNextEntry();
            }
            zis.closeEntry();
        }

        File dir = new File(unzippingPath);
        return Arrays.asList(dir.listFiles());
    }
}
