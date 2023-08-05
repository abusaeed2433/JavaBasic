package q_Interfaces.partThree;

import java.io.IOException;

public class MyCustom implements Clickable,Pressable{

    @Override
    public void onPressed() throws IOException {

    }

    @Override
    public void onClicked() {
        Clickable.super.onClicked();
    }

}
