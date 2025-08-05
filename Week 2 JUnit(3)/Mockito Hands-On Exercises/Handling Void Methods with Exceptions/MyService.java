public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void safeSend(String msg) {
        try {
            api.sendData(msg);
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
