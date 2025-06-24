public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void sendWorkflow() {
        api.connect();
        api.sendData("Important Data");
        api.disconnect();
    }
}
