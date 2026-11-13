public class RemoteControl2Example {
    public static void main(String[] args) {
        RemoteControl remoteControl;
        SmartTelevision smartTelevision = new SmartTelevision();
        remoteControl = new Television2();
        remoteControl.turnOn();
        remoteControl.turnOff();
        remoteControl = new SmartTelevision();
        remoteControl.turnOn();
        remoteControl.turnOff();
        smartTelevision.search("ㅎㅇ");
    }
}
