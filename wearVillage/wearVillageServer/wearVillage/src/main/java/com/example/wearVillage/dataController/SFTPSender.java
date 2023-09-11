package com.example.wearVillage.dataController;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SFTPSender {
    public static void SFTPSend() {
        System.out.println("접근확인2");

        String user = "ubuntu";  // 서버의 유저 이름
        String host = "3.39.167.250";  // 서버의 주소
        String password ="";
        int port = 22;  // SSH 포트 번호 (기본값은 보통 22입니다)

        try {
            JSch jsch = new JSch();
            String privateKeyPath = "C:\\wearVillage.pem";   // 비밀 키 파일(.pem) 경로
            jsch.addIdentity(privateKeyPath);

            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            System.out.println("접근확인6");


            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            session.connect();

            Channel channel=session.openChannel("sftp");

            channel.connect();

            ChannelSftp sftp=(ChannelSftp)channel;
            System.out.println("접근확인5");

            // 원하는 로컬 파일 경로와 목적지 경로 설정 후 전송
            String localFile= "C:\\upload\\2023\\09\\11\\test.jpg";
            String remoteDir= "/home/ubuntu/upload/test.jpg";

            sftp.put(localFile, remoteDir);

            System.out.println("File transfered successfully to host.");

            channel.disconnect();
            session.disconnect();

        } catch(Exception e){
            System.out.println("접근확인3");
            System.err.print(e);
        }
    }
}