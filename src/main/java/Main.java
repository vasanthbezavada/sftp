import com.jcraft.jsch.*;

public class Main {
    public static void main(String[] args) throws SftpException {
//        try{
//            String user= "test_user";
//            String password = "test";
//            String host = "127.0.0.1";
//            JSch jsch = new JSch();
//            java.util.Properties config = new java.util.Properties();
//            config.put("StrictHostKeyChecking", "no");
//            Session session = jsch.getSession(user,host);
//            session.setConfig(config);
//            session.setPassword(password);
//            session.connect();
//            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
//            channelSftp.connect();
//            channelSftp.put("G:\\sftp\\filesToSend\\file1.txt","inbound\\");
//            System.out.println("file_sent");
//            channelSftp.disconnect();
//            session.disconnect();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
        SFTPManager sftpManager = new SFTPManager("172.0.0.1","test_user","test");
        sftpManager.connect();
        sftpManager.insertFile("G:\\sftp\\filesToSend\\file1.txt","inbound\\");
    }
}
