package z_medium;

interface TV {
    void showNextChannel();
    void switchToChannel(int channelId);
    void adjustVolume(int delta);
}

class AppleTV implements TV{
    int volume = 12;
    @Override
    public void showNextChannel(){
        System.out.println("Switching...");
    }
    @Override
    public void switchToChannel(int channelId){
        System.out.println(channelId +" switching done");
    }
    @Override
    public void adjustVolume(int delta){
        volume += delta;
        if(volume < 0) volume = 0;
        if(volume > 100) volume = 100;

        System.out.println("Volume set to "+volume);
    }

    public void startCamera(){
        System.out.println("Camera started");
    }
}

class SamsungTV implements TV{
    int volume = 12;
    @Override
    public void showNextChannel(){
        System.out.println("Switched to next channel");
    }
    @Override
    public void switchToChannel(int channelId){
        System.out.println("Switched to channel" + channelId);
    }
    @Override
    public void adjustVolume(int delta){
        volume += delta;
        volume = Math.max( Math.min(volume, 100), 0 );
        System.out.println(volume);
    }

    public void startBixby(){
        System.out.println("Voice command enabled");
    }
}

class ChineseRemote{
    private TV tv;

    public ChineseRemote(TV tv){
        this.tv = tv;
    }

    public void pressNextChannelButton(){
        tv.showNextChannel();
    }

    public void pressIncreaseVolume(){
        tv.adjustVolume(1);
    }
    public void pressDecreaseVolume(){
        tv.adjustVolume(-1);
    }
}

public class Medium {

    public static void main(String... args){
        TV samsungTV = new SamsungTV();
        TV appleTV = new AppleTV();
        ChineseRemote samsungRemote = new ChineseRemote(samsungTV);
        ChineseRemote appleRemote = new ChineseRemote(appleTV);
        // ChineseRemote remote = new ChineseRemote(appleTV); // both are valid


        samsungRemote.pressIncreaseVolume();
        samsungRemote.pressNextChannelButton();
        System.out.println("-------------------------");
        appleRemote.pressIncreaseVolume();
        appleRemote.pressNextChannelButton();
    }

}
