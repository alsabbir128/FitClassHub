package fitclasshub.models;


public class ClassSchedule {
    private String className;
    private String time;
    private String trainerName;

    public ClassSchedule(String className, String time, String trainerName) {
        this.className = className;
        this.time = time;
        this.trainerName = trainerName;
    }

    @Override
    public String toString() {
        return className + " | Time: " + time + " | Trainer: " + trainerName;
    }
}
