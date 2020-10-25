package com.iecisa.gtfsprocessor.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.net.SocketException;

public class FtpClient {

    private org.apache.commons.net.ftp.FTPClient ftp;

    public FtpClient(String server, String username, String password)
    {
        try {
            this.ftp = new FTPClient();
            this.ftp.connect(server);
            this.ftp.login(username, password);
            this.ftp.enterLocalPassiveMode();
            this.ftp.setFileType(FTP.BINARY_FILE_TYPE);

        } catch (SocketException e) {
        } catch (IOException e) {
        }
    }

    public void downloadFile(String fileName, String path)
    {
        File file = new File(path);
        if(!file.exists() && !file.getParentFile().exists() && !file.getParentFile().mkdirs()) return;

        try {

            ftp.listFiles();
            OutputStream os = new FileOutputStream(file);
            ftp.retrieveFile(fileName, os);
            os.flush();
            os.close();

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

    }

    public void close()
    {
        try {
            if (ftp.isConnected()) {
                ftp.logout();
                ftp.disconnect();
            }

        } catch (IOException e) {
        }
    }
}
