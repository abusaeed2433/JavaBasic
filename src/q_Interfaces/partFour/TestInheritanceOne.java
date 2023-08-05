package q_Interfaces.partFour;

public class TestInheritanceOne {

    public static void main(String[] args) {
        CharitySinger singer = new MySinger();
        singer.setRate(345);
        System.out.println(singer.getRate());

        SingerWriter singerWriter = new MyWriterSinger();
        singerWriter.sing();  // Singing...
        singerWriter.write(); // Writing...
    }

    static class MySinger implements CharitySinger {
        @Override
        public void sing() {
            System.out.println("Singing free...");
        }
    }

    interface SingerWriter extends Singer, Writer {
        // No code
    }

    interface CharitySinger extends Singer { // no problem

        @Override
        default void setRate(double rate) {
        }

        @Override
        default double getRate() {
            return 0.0;
        }

    }


    interface Singer {
        void sing();

        void setRate(double rate);

        double getRate();
    }

    interface Writer {
        void write();

        void setRate(double rate);

        double getRate();
    }

    interface Player {
        void play();

        void setRate(double rate);

        default double getRate() {
            return 300.0;
        }
    }

}
