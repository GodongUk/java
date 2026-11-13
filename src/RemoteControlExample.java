public class RemoteControlExample {
    public static void main(String[] args) {

        RemoteControl rc = new RemoteControl() {
            public void turnOn() {
                System.out.println("익명객체실행문입니다.");
            }

            public void turnOff() {
                System.out.println("익명객체 실행문 입니다.");
            }

            public void setVolume(int volume) {
                System.out.println("익명객체 실행문 입니다.");
            }
        };
        rc.turnOn();
        rc = new Television2();
        rc.turnOn();
        rc = new SmartTelevision();
        rc.turnOn();
    }
}
