package Week1.DesignPatterns;

public class BuilderPatternExample {

    static class Computer {

        private String cpu;
        private String ram;

        private String storage;
        private String gpu;

        private Computer(Builder builder) {
            this.cpu = builder.cpu;
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.gpu = builder.gpu;
        }

        public void displayConfig() {
            System.out.println(" Computer Config:");
            System.out.println("CPU: " + cpu);
            System.out.println("RAM: " + ram);
            System.out.println("Storage: " + (storage != null ? storage : "Not added"));
            System.out.println("GPU: " + (gpu != null ? gpu : "Not added"));
            System.out.println("----------------------------");
        }

        public static class Builder {
            private String cpu;
            private String ram;
            private String storage;
            private String gpu;

            public Builder(String cpu, String ram) {
                this.cpu = cpu;
                this.ram = ram;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGpu(String gpu) {
                this.gpu = gpu;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    public static void main(String[] args) {

        Computer basicPC = new Computer.Builder("Intel i5", "8GB").build();
        basicPC.displayConfig();

        Computer gamingPC = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD")
                .setGpu("NVIDIA RTX 3080")
                .build();
        gamingPC.displayConfig();

        Computer workstation = new Computer.Builder("AMD Ryzen 9", "64GB")
                .setStorage("2TB NVMe SSD")
                .build();
        workstation.displayConfig();
    }
}
