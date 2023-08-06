package q_Interfaces.partTwo;

public interface Job {

    class EmptyJob implements Job {
        private EmptyJob() {
            // Do not allow outside to create its object
        }
        public void runJob() {
            System.out.println("Nothing");
        }
    }

    Job EMPTY_JOB = new EmptyJob(); // constant
    void runJob();
}
