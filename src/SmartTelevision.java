public class SmartTelevision implements RemoteControl, Searchable {
    private int volume;

    public void turnOn() {
        System.out.println("smart TV를 켭니다.");
    }

    public void turnOff() {
        System.out.println("smart TV를 끕니다.");
    }

    public void setVolume(int volume) {
        if (volume > RemoteControl.MAX_VOLUM) {
            this.volume = RemoteControl.MAX_VOLUM;
        } else if (volume < RemoteControl.MIN_VOLUM) {
            this.volume = RemoteControl.MIN_VOLUM;
        } else {
            this.volume = volume;
        }
        System.out.println("현재 TV 볼륨 : " + volume);
    }

    public void search(String url) {
        System.out.println(url + "을 검색합니다.");
    }
}
