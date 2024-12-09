package z_medium;

public class Medium {

    static class Point {
        int x, y;

        public Point(int x, int y) { this.x = x; this.y = y; }

        @Override
        public String toString() {
            return "("+x+", "+y+")";
        }

    }

    static class Artist {
        private final Point point = new Point(0,0);
        private boolean isCurrentPointDrawn = true;

        public synchronized void productNextPoint(int value) {
            while (!isCurrentPointDrawn) {
                try {
                    wait(); // Wait if current point isn't drawn yet
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }

            //try{ Thread.sleep(2000); }catch (InterruptedException e){}
            point.x += value;
            point.y += value;
            System.out.println("Produced: " + point);
            isCurrentPointDrawn = false;
            notify(); // Notify that point is available to draw
        }


        public synchronized void drawCurrentPoint() {
            while (isCurrentPointDrawn) {
                try {
                    //System.out.println("whiellll");
                    wait(); // Wait if no point is available to draw
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Drawn: " + point);
            isCurrentPointDrawn = true;
            notify(); // Notify the waiting producer that point has been drawn
        }
    }

     public static void main(String[] args) {
         final Artist resource = new Artist();
         final int noOfPoints = 3;

         Thread producerThread = new Thread(new Runnable() {
             @Override
             public void run() {
                 for (int i = 0; i < noOfPoints; i++) {
                     resource.productNextPoint(i);
                 }
             }
         });
         Thread consumerThread = new Thread(new Runnable() {
             @Override
             public void run() {
                 for (int i = 0; i < noOfPoints; i++) {
                     resource.drawCurrentPoint();
                 }
             }
         });

         producerThread.start();
         consumerThread.start();

     }

}
