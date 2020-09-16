import com.jcraft.jsch.*;


public class SFTPManager {
    private Session session;
    private ChannelSftp channelSftp;
    private String host;
    private String user;
    private String password;
    private JSch sftpClient = new JSch();

    public SFTPManager(String host, String user, String password) {
        this.host = host;
        this.user = user;
        this.password = password;
    }

    public void setSession(String host, String user, String password) throws JSchException {
        this.session = this.sftpClient.getSession(user, host);
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.setPassword(password);
        this.session.connect();
    }

    public void setChannelSftp(ChannelSftp channelSftp) {
        this.channelSftp = channelSftp;
    }

    public void connect() {
        try {
            this.setSession(this.host, this.user, this.password);
        } catch (JSchException e) {
            System.out.println("session not established" + e);
        }
        try {
            this.setChannelSftp((ChannelSftp) this.session.openChannel("sftp"));
            this.channelSftp.connect();
        } catch (JSchException e) {
            System.out.println("channel not established");
        }
    }

    public void disconnect() {
        this.session.disconnect();
        this.channelSftp.disconnect();
    }

    public void insertFile(String src, String dst) {
        try {
            channelSftp.put(src, dst);
        } catch (SftpException e) {
            System.out.println("file insert failed");
        }

    }

    public void downloadFile(String src, String dst, String fileName) throws SftpException {
        try {
            channelSftp.get(src, dst + fileName);
        } catch (SftpException e) {
            System.out.println("file download failed");
        }
    }

}
