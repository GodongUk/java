public class Audio implements RemoteControl {
    // 필드
    private int volume;

    // turnOn() 추상 메소드의 실체 메소드
    public void turnOn() {
        System.out.println("Audio를 켭니다.");
    }

    // turnOff() 추상 메소드의 실체 메소드
    public void turnOff() {
        System.out.println("Audio를 끕니다.");
    }

    // setVolume() 추상 메소드의 실체 메소드
    public void setVolume(int volume) {
        if (volume > RemoteControl.MAX_VOLUM) {
            this.volume = RemoteControl.MAX_VOLUM;
        } else if (volume < RemoteControl.MIN_VOLUM) {
            this.volume = RemoteControl.MIN_VOLUM;
        } else {
            this.volume = volume;
        }
        System.out.println("현재Audio 볼륨 : " + volume);
    }
}