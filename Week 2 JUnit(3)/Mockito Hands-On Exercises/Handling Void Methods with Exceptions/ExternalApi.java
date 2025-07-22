public interface ExternalApi {
    void connect();

    void sendData(String data);

    void disconnect();
}
