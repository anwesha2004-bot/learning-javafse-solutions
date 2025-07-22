public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void callMultipleTimes() {
        System.out.println(api.getData());
        System.out.println(api.getData());
        System.out.println(api.getData());
    }
}
