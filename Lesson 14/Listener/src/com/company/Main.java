package com.company;

public class Main {

    public static void main(String[] args) {
        MotionSensor motionSensor = new MotionSensor();
        Police police = new Police();
        motionSensor.setListener(police);//Police implements the Motion, so I can use it, you only know to inform which the motion is acting up.
        motionSensor.detectMotion();
    }
}

class MotionSensor{
    private MotionSensorListener listener;

    public void setListener(MotionSensorListener listener){
        this.listener = listener;
    }

    public void detectMotion(){
        if (listener != null)
            listener.motionDetected();
    }

}
interface MotionSensorListener{
    public void motionDetected();
}

class Police implements MotionSensorListener{

    @Override
    public void motionDetected() {
        System.out.println("stop you are under arrest!");
    }
}
